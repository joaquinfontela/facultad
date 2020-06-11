import string
import random

def tablero_inicial(cant_filas, cant_columnas):
	'''
	Cuando la función es llamada, devuelve el tablero incial, con los casilleros cubiertos.
	'''
	tablero_buscaminas = []
	for fila in range (0, cant_filas+1):
		filas = []
		# En cada iteración, la variable 'filas' vuelve a ser una lista vacía para poder rellenarla nuevamente.
		for columna in range (0, cant_columnas+1):
			if fila == 0 and columna == 0:
				filas.append(' ')
			elif fila == 0:
				filas.append(str(columna))
			else:
				if columna == 0:
					filas.append(string.ascii_uppercase[fila-1])
				else:
					if columna < 10:
						filas.append('.')
					else:
						filas.append('. ')
		tablero_buscaminas.append(' '.join(filas))
	return '\n'.join(tablero_buscaminas)


def random_minas(cant_filas, cant_columnas, cant_minas):
	'''
	La función define, al azar, las 10 posiciones del tablero en las que habrá minas.
	'''
	lista_minas = []
	while not len(lista_minas) > cant_minas - 1:
		mina = ''
		fila = random.choice(list(string.ascii_uppercase)[0:cant_filas])
		columna = random.randint(1, cant_columnas)
		mina = fila + str(columna)
		if not mina in lista_minas:
			lista_minas.append(mina)
	return lista_minas


def obtener_posicion_casillero(cant_filas, cant_columnas, casillero):
	'''
	La función recibe el casillero ingresado por el jugador
	y devuelve la posición de esa casilla en el tablero de manera que sea entendible por el intérprete.
	'''
	c = casillero.upper()
	if len(c) == 2:
		posicion_tablero = 0
		for fila in range(0, cant_filas):
			if c [0] == list(string.ascii_uppercase)[fila]:
				if cant_columnas < 10:
					posicion_tablero += (cant_columnas*2 + 2) * (fila + 1)
					posicion_tablero += int(c[1]) * 2
				else:
					posicion_tablero += (23 + ((cant_columnas - 10) * 3)) * (fila + 1)
					posicion_tablero += int(c[1]) * 2
		return posicion_tablero
	elif len(c) == 3:
		posicion_tablero = 0
		if c [0] in string.ascii_uppercase[0: cant_columnas] and c[1:3].isdigit() and int(c[1:3]) <= cant_columnas:
			for fila in range(0, cant_filas):
				if c [0] == list(string.ascii_uppercase)[fila]:
					posicion_tablero += (23 + ((cant_columnas - 10) * 3)) * (fila + 1)
					posicion_tablero += 20 + (int(c[1:3])-10) * 3
		return posicion_tablero

def minas_alrededor(cant_filas, lista_de_minas, casilla):
	'''
	Recibe una casilla y devuelve la cantidad de minas que tiene a su alrededor.
	No hace falta evaluar la primera y última columnas, así como tampoco la fila superior y la inferior si estas no son A y Z
	ya que, en el caso de las columnas evaluaría las fila 0 y (cant_filas + 1), que no existen y por lo tanto nunca tendrán una mina,
	y en el caso de las filas, si no existe una fila Z, la fila -1 equivaldría a ella y nunca tendría una mina. 
	'''
	contador = 0
	fila_casilla = list(string.ascii_uppercase[0:cant_filas]).index(casilla[0])
	if casilla[0] == 'A':
		if len(casilla) == 2:
			columna_casilla = int(casilla[1])
		else:
			columna_casilla = int(casilla[1:3])
		casilla_evaluada = ''
		for col in range (columna_casilla-1, columna_casilla+1+1):
			for fil in range (fila_casilla, fila_casilla+1+1):
				fila = string.ascii_uppercase[fil]
				casilla_evaluada = fila + str(col)
				if casilla_evaluada in lista_de_minas:
					contador += 1
	elif casilla[0] == 'Z':
		if len(casilla) == 2:
			columna_casilla = int(casilla[1])
		else:
			columna_casilla = int(casilla[1:3])
		casilla_evaluada = ''
		for col in range (columna_casilla-1, columna_casilla+1+1):
			for fil in range (fila_casilla-1, fila_casilla+1):
				fila = string.ascii_uppercase[fil]
				casilla_evaluada = fila + str(col)
				if casilla_evaluada in lista_de_minas:
					contador += 1
	else: 
		if len(casilla) == 2:
			columna_casilla = int(casilla[1])
		else:
			columna_casilla = int(casilla[1:3])
		casilla_evaluada = ''
		for col in range (columna_casilla-1, columna_casilla+1+1):
			for fil in range (fila_casilla-1, fila_casilla+1+1):
				fila = string.ascii_uppercase[fil]
				casilla_evaluada = fila + str(col)
				if casilla_evaluada in lista_de_minas:
					contador += 1
	return contador

def actualizar_tablero(cant_filas, cant_columnas, tablero, casilla, accion):
	'''
	La función recibe la ultima actualizacion del tablero del buscaminas y la casilla y la acción ingresadas por el jugador, y devuelve el nuevo tablero.
	'''
	tablero_vacio = ''
	if cant_columnas < 10:
		long_cadena_tablero = (cant_columnas * 2 + 2) * (cant_filas + 1) - 1
	else:
		long_cadena_tablero = (23 + ((cant_columnas - 10) * 3)) * (cant_filas + 1) - 1
	for casillero in range(0, long_cadena_tablero):
			#La cadena de la matriz del buscaminas tiene en total mayor longitud que la cantidad de casilleros ya que se cuentan espacios y saltos de línea.
				if casillero == obtener_posicion_casillero(cant_filas, cant_columnas, casilla):
					tablero_vacio += accion
				else:
					tablero_vacio += tablero[casillero]
	tablero = tablero_vacio		
	return tablero


def presentacion(filas, columnas, cant_minas):
	'''
	La función saluda al usuario y le explica brevemente las reglas del juego.
	'''
	print('Bienvenido al Algominas!')
	print('Las reglas son sencillas: ingrese la fila seguida de la columna sin espacios intermedios (ejemplo: A1) para realizar una acción sobre la casilla correspondiente, y presione Enter.')
	print('Luego, ingrese "D" si quiere descubrir esa casilla, "X" para marcarla como mina o "?" si quiere marcarla como duda.')
	print('Si, en cambio, quiere eliminar la acción realizada sobre una casilla, ingrese "E".')
	print('El tablero es de ' + str(filas) + 'x' + str(columnas) + ', y la cantidad total de minas es ' + str(cant_minas) + '. El juego finaliza (con victoria) cuando ha descubierto todas las casillas sin minas.')
	print('Pero usted perderá si descubre una casilla con una mina, y deberá empezar de 0.')


def main(filas, columnas, cant_minas):
	'''
	Es la función principal, ya que es la que ejecuta el juego.
	La cantidad máxima de filas es 26 y la cantidad máxima de columnas es 99 (preferentemente no más de 77 ya que se distorsiona el
	gráfico por exceder la capacidad de la pantalla).
	Mediante un while True, el jugador puede seguir jugando mientras no descubra una casilla con una mina.
	En ese caso, se ejecuta el break luego de un mensaje anunciando que perdió el juego.
	'''
	if filas > 26:
		filas = 26
		print('Se ha excedido la cantidad máxima de filas y se han definido automáticamente 26.')
	if columnas > 99:
		columnas = 77
		print('Se ha excedido la cantidad máxima de columnas y se han definido automáticamente 77.')
	if filas * columnas <= cant_minas:
		return print('Ha excedido el límite de minas para las dimensiones del tablero seleccionadas.')
	presentacion(filas, columnas, cant_minas)
	lista_de_minas = random_minas(filas, columnas, cant_minas)
	tablero_actualizado = tablero_inicial(filas, columnas)
	descubiertas = []
	while True:
		print(tablero_actualizado)
		c = input('Ingrese una casilla: ')
		casilla = c.upper()
		if not (len(casilla) == 2 or len(casilla) == 3):
			print('El casillero ingresado no es válido.')
			continue
		elif len(casilla) == 2:
			if not (casilla [0] in string.ascii_uppercase[0:filas] and casilla[1].isdigit() and int(casilla [1]) <= columnas and int(casilla[1] != '0')):
				print('El casillero ingresado no es válido.')
				continue
		elif len(casilla) == 3:
			if casilla [1] == '0':
				print('El casillero ingresado no es válido.')
				continue
			if not (casilla [0] in string.ascii_uppercase[0:filas] and casilla[1:3].isdigit() and int(casilla [1:3]) <= columnas and int(casilla[1:3] != '0')):
				print('El casillero ingresado no es válido.')
				continue
		if casilla in descubiertas:
			print('El casillero ingresado ya ha sido descubierto.')
			continue
		a = input('Ingrese la acción que desee: ')
		accion = a.upper()
		if not (accion == 'D' or accion == 'X' or accion == '?' or accion == 'E'):
			print('La acción ingresada no es válida')
			continue
		elif accion == 'X':
			#Jugador marca una casilla como mina.
			tablero_actualizado = actualizar_tablero(filas, columnas, tablero_actualizado, casilla, accion)
			continue
		elif accion == '?':
			#Jugador marca una casilla como duda.
			tablero_actualizado = actualizar_tablero(filas, columnas, tablero_actualizado, casilla, accion)
			continue
		elif accion == 'E':
			#Jugador elimina la acción realizada sobre una casilla.
			accion = '.'
			tablero_actualizado = actualizar_tablero(filas, columnas, tablero_actualizado, casilla, accion)
			continue
		elif accion == 'D':
			#Jugador descubre una casilla.
			if tablero_actualizado[obtener_posicion_casillero(filas, columnas, casilla)] == 'X' or tablero_actualizado[obtener_posicion_casillero(filas, columnas, casilla)] == '?':
				#Casilla está marcada como mina o como duda.
				print('Debes desmarcar la casilla para descubrirla.')
				continue
			elif casilla in lista_de_minas:
				if len(descubiertas) == 0:
				#Al ser el primer movimiento del jugador, éste no debe perder.
					while casilla in lista_de_minas:
						lista_de_minas = random_minas(filas, columnas, cant_minas)
					minas = 0
					minas = minas_alrededor(filas, lista_de_minas, casilla)
					accion = str(minas)
					tablero_actualizado = actualizar_tablero(filas, columnas, tablero_actualizado, casilla, accion)
					descubiertas.append(casilla)
					if len(descubiertas) >= (filas * columnas - cant_minas):
						#Se han descubierto todos los casilleros sin minas.
						print(tablero_actualizado)
						print('Felicitaciones! Ha ganado!')
						break
					else:
						continue
				else:
				#Jugador pierde.
					accion = '*'
					tablero_actualizado = actualizar_tablero(filas, columnas, tablero_actualizado, casilla, accion)
					print(tablero_actualizado)
					print ('Ha descubierto un casillero con una mina. Ha perdido!')
					break
			else:
				#Jugador no pierde.
				minas = 0
				minas = minas_alrededor(filas, lista_de_minas, casilla)
				accion = str(minas)
				tablero_actualizado = actualizar_tablero(filas, columnas, tablero_actualizado, casilla, accion)
				descubiertas.append(casilla)
				if len(descubiertas) >= (filas * columnas - cant_minas):
					#Se han descubierto todos los casilleros sin minas.
					print(tablero_actualizado)
					print('Felicitaciones! Ha ganado!')
					break
				else:
					continue
		

main(8, 8, 10)		
				