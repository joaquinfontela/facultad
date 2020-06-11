import csv
import random
import sys
COMANDOS_VALIDOS = ['generar', 'trending', 'favoritos']

def verif_comando():
	'''La función verifica que se haya ingresado un comando.'''
	try:
		comando = sys.argv [1]
		return comando
	except IndexError:
		return False

def validar_comando(comando):
	'''La función verifica que se haya ingresado un comando válido.'''
	if comando not in COMANDOS_VALIDOS:
		return False
	return comando

def crear_set_de_usuarios_validos():
	'''Crea el set de usuarios válidos según el archivo de tweets sobre el cual funcionará el programa.'''
	usuarios_validos = set()
	with open('tweets.csv', 'r', encoding = "utf-8") as lista_de_tweets:
		for linea in lista_de_tweets:
			linea = linea.rstrip('\n')
			linea = linea.split('\t')
			#Separo cada linea en usuario y tweet.
			usuario = linea [0]
			usuarios_validos.add(usuario)
	return usuarios_validos

def validar_generar():
	'''Validación de lo ingresado cuando el comando fue 'generar'.
	Si lo ingresado es válido, devuelve la lista de usuarios a tener en cuenta para la generación de tweets.'''
	input_ingresado = sys.argv
	users = []
	usuarios_validos = crear_set_de_usuarios_validos()
	try:
		usuarios_elegidos = input_ingresado [2:]
		#Se genera una lista de los usuarios ingresados.
		for usuario in usuarios_elegidos:
			if usuario in users:
			#El usuario ya está en la lista.
				continue
			elif usuario in usuarios_validos:
			#El usuario es válido.
				users.append(usuario)
			else:
			#El usuario no es válido.
				return False
		if users == []:
		#No se ha ingresado ningun usuario, se evalúan todos.
			return usuarios_validos
		return users
	except IndexError:
		return usuarios_validos

def calcular_probabilidades_cadena_de_markov(lista_de_usuarios):
	'''Según la lista de usuarios dada, y a partir del método de la Cadena de Markov,
	define un diccionario en el que cada palabra es una clave, y su valor es una lista
	con las posibles palabras a continuación de ésta.'''
	diccionario = {}
	try:
		with open('tweets.csv', 'r', encoding = "utf-8") as lista_de_tweets:
			for linea in lista_de_tweets:
				linea = linea.rstrip('\n')
				linea = linea.split('\t')
				#Separo cada linea en usuario y tweet.
				usuario = linea [0]
				tweet = linea [1]
				tweet = tweet.split(' ')
				if usuario in lista_de_usuarios:
					for palabra in range(len(tweet)):
						if tweet[palabra] in diccionario:
							if palabra != len(tweet) - 1:
								diccionario [tweet[palabra]].append(tweet [palabra + 1])
							else:
								#Si es la última palabra/cadena de la oración.
								diccionario [tweet[palabra]].append('\n')
						if not tweet[palabra] in diccionario:
							if palabra != len(tweet) - 1:
								diccionario [tweet[palabra]] = [tweet [palabra + 1]]
							else:
								diccionario [tweet[palabra]] = []
								diccionario [tweet[palabra]].append('\n')
				else:
					continue
	except FileNotFoundError:
		return False
	return diccionario

def eleccion_primera_palabra(diccionario):
	'''Mediante un random entre todas las palabras de todos los tweets elegidos, utiliza una para iniciar un tweet'''
	cadena_inicial = random.choice(list(diccionario.keys()))
	return cadena_inicial

def random_sig_palabra(ult_palabra, diccionario_probabilidades):
	'''Mediante un random entre todas las palabras posibles a continuación de la última seleccionada,
	se elige una al azar para continuar el tweet.'''
	sig_palabra = random.choice(diccionario_probabilidades[ult_palabra])
	return sig_palabra

def reducir_cant_caracteres(lista_tweet):
	'''Elimina la ultima palabra de un tweet si este ha sobrepasado la cantidad de caracteres permitidos (280).'''
	lista_tweet.pop()
	tweet = ' '.join(lista_tweet)
	return tweet

def generar_tweet(usuarios):
	'''Recibe uno o más usuarios y genera un tweet a partir de las probabilidades de la Cadena de Markov
	evaluadas en anteriores funciones.'''
	if calcular_probabilidades_cadena_de_markov(usuarios) == False:
		return False
	diccionario_probabilidades = calcular_probabilidades_cadena_de_markov(usuarios)
	lista_tweet = []
	ult_palabra_elegida = eleccion_primera_palabra(diccionario_probabilidades)
	lista_tweet.append(ult_palabra_elegida)
	while True:
		prox_palabra = random_sig_palabra(ult_palabra_elegida, diccionario_probabilidades)
		if prox_palabra == '\n':
			tweet = ' '.join(lista_tweet)
			return tweet
		lista_tweet.append(prox_palabra)
		ult_palabra_elegida = prox_palabra
		tweet = ' '.join(lista_tweet)
		if len (tweet) > 280:
			tweet = reducir_cant_caracteres(lista_tweet)
			break
	return tweet

def obtener_diccionario_de_trends():
	'''Devuelve un diccionario cuya clave es el tema del hashtag, y su respectivo valor es la cantidad de apariciones de éste.'''
	try:
		with open('tweets.csv', 'r', encoding = "utf-8") as lista_de_tweets:
			diccionario_de_trends = {}
			for linea in lista_de_tweets:
				linea = linea.rstrip('\n')
				linea = linea.split('\t')
				#Separo cada linea en usuario y tweet.
				usuario = linea [0]
				tweet = linea [1]
				tweet = tweet.split(' ')
				for palabra in tweet:
					if palabra[0] == '#':
					#La palabra comienza con un hashtag.
						if palabra in diccionario_de_trends:
							diccionario_de_trends[palabra] += 1
						else:
							diccionario_de_trends[palabra] = 1
			return diccionario_de_trends
	except FileNotFoundError:
		return False

def validar_trending():
	'''Validación de lo ingresado por el usuario cuando ejecuta el comando trending.
	Si se valida, devuelve la cantidad de temas a listar solicitados.'''
	input_ingresado = sys.argv
	if len(input_ingresado) != 3:
		return False
	elif not (input_ingresado[2]).isdigit():
		return False
	elif int(input_ingresado[2]) < 1:
		return False
	else:
		return input_ingresado[2]

def obtener_trending_topics(diccionario_trends, cant_temas):
	'''Recibe un diccionario cuya clave es un trend, y un valor(puntuación), que cuán más alto es, más comun es el tema del hashtag.
	Devuelve una lista con la cantidad elegida de temas comunes.'''
	lista_cant_apariciones_trends = list(diccionario_trends.keys())
	lista_cant_apariciones_trends.sort(key = lambda trend: diccionario_trends[trend], reverse = True)
	return lista_cant_apariciones_trends[0:int(cant_temas)]

def opcion_agregar_a_favoritos():
	'''Le da la opción al usuario de agregar el tweet generado a favoritos.'''
	respuesta = ''
	while not (respuesta == 's' or respuesta == 'n'):
		respuesta = input('¿Desea agregar este tweet a favoritos? [s/n] ')
	if respuesta == 's':
		return True

def agregar_tweet_a_archivo_favoritos(tweet):
	'''Recibe un tweet y lo agrega a un archivo donde están guardados todos los favoritos.'''
	try:
		with open('favoritos.txt', 'r', encoding = "utf-8") as tweets_fav:
			contenido = tweets_fav.read()
		contenido = tweet + '\n' + contenido
		with open('favoritos.txt', 'w', encoding = "utf-8") as tweets_fav:
			tweets_fav.write(contenido)
	except FileNotFoundError:
		with open('favoritos.txt', 'w', encoding = "utf-8") as tweets_fav:
			tweets_fav.write(tweet + '\n')

def imprimir_favoritos(cant_tweets_a_impr):
	'''Recibe una numero e imprime esa cantidad de tweets favoritos.'''
	try:
		with open('favoritos.txt', 'r', encoding = "utf-8") as arch_con_tweets:
			if cant_tweets_a_impr == -1:
				for tw in arch_con_tweets:
					print(tw)
			else:
				for linea in range(int(cant_tweets_a_impr)):
						tw = arch_con_tweets.readline()
						print(tw)
	except FileNotFoundError:
		print('Todavía no hay tweets guardados como favoritos.')

def validar_favoritos():
	'''Validación de lo ingresado por el usuario al elegir el comando 'favoritos'.
	Si se valida, se devuelve la cantidad de tweets favoritos a imprimir en pantalla.'''
	input_ingresado = sys.argv
	if len(input_ingresado) == 2:
		return -1
	elif len(input_ingresado) == 3:
		if not (input_ingresado[2]).isdigit():
			return False
		if int(input_ingresado[2]) < 1:
			return False
		return input_ingresado[2]
	else:
		return False

def main():
	comando = verif_comando()
	if comando == False:
		return print('Debe ingresar un comando.')
	comando = validar_comando(comando)
	if comando == False:
		return print('Debe ingresar un comando válido ("generar", "trending" o "favoritos").')
	if comando == 'generar':
		usuarios = validar_generar()
		if usuarios == False:
			return print('Se ha ingresado un usuario inválido.')
		print('Generando tweet...')
		if generar_tweet(usuarios) == False:
			return print('El archivo "tweets.csv" no está en la carpeta del programa.')
		tweet = generar_tweet(usuarios)
		print(tweet)
		respuesta = opcion_agregar_a_favoritos()
		if respuesta == True:
			agregar_tweet_a_archivo_favoritos(tweet)
	elif comando == 'trending':
		cant_temas_a_mostrar = validar_trending()
		if cant_temas_a_mostrar == False:
			return print('Ha ingresado un valor inválido de temas a mostrar.')
		if obtener_diccionario_de_trends() == False:
			return print('El archivo "tweets.csv" no está en la carpeta del programa.')
		dicc_de_trends = obtener_diccionario_de_trends()
		lista_ordenada_de_trends = obtener_trending_topics(dicc_de_trends, cant_temas_a_mostrar)
		for trend in lista_ordenada_de_trends:
			print(trend)
	elif comando == 'favoritos':
		accion = validar_favoritos()
		if accion == -1:
			imprimir_favoritos(accion)
		elif accion == False:
			return print('La cantidad ingresada de favoritos a imprimir no es válida.')
		else:
			imprimir_favoritos(accion)
main()
