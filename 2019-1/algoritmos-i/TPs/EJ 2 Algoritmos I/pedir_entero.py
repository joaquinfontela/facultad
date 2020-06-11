def es_numero(num):
	if num.isdigit():
		return True
	else:
		resto = num[1:]
		if ((num[0]=='-') and (resto.isdigit())):
			return True
		else:
			return False
			
def pedir_entero(mensaje, min, max):
	edad = input(mensaje + ' [' + str(min) + '-' + str(max) + '] ')
	while not ((es_numero(edad)) and ((min<=int(edad)) and (int(edad)<=max))):
		print ('Por favor, ingrese un valor entre ' + str(min) + ' y ' + str(max) + '.')
		edad = input(mensaje + ' [' + str(min) + '-' + str(max) + '] ')
	return edad




valor=pedir_entero('¿Cuántos años tenes?', -3, 150)
print(valor)


