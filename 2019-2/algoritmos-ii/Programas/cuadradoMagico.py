def cuadradoMagico(n):

	listaDeNumeros = []

	cuadrado = []

	for i in range (1, n**2 + 1):

		listaDeNumeros.append(i)

	j = 0
	exito = False

	while (j < 9) and (not exito):

		exito, cuadrado = agregarNumero(listaDeNumeros, cuadrado, n**2)

		j += 1

	print(cuadrado)



def agregarNumero(listaDeNumeros, cuadrado, j):

	i = 0

	exito = False

	while (i < j) and (not exito):

		numeroAAgregar = listaDeNumeros.pop(0)

		cuadrado.append(numeroAAgregar)

		if (len(listaDeNumeros) == 0):

			exito = verificarCuadradoMagico(cuadrado)

		else:

			exito, cuadrado = agregarNumero(listaDeNumeros, cuadrado, j-1)

		if not exito:

			cuadrado.remove(numeroAAgregar)

		listaDeNumeros.append(numeroAAgregar)  

		i += 1

	return exito, cuadrado
			


def verificarCuadradoMagico(cuadrado):

	if cuadrado [0] + cuadrado [3] + cuadrado [6] == cuadrado [1] + cuadrado [4] + cuadrado [7] == cuadrado [2] + cuadrado [5] + cuadrado [8]:
		if cuadrado [0] + cuadrado [1] + cuadrado [2] == cuadrado [3] + cuadrado [4] + cuadrado [5] == cuadrado [6] + cuadrado [7] + cuadrado [8]:
			if cuadrado [0] + cuadrado [4] + cuadrado [8] == cuadrado [2] + cuadrado [4] + cuadrado [6]:
				if cuadrado [0] + cuadrado [3] + cuadrado [6] == cuadrado [0] + cuadrado [1] + cuadrado [2] == cuadrado [0] + cuadrado [4] + cuadrado [8]:
					return True

	return False



	

cuadradoMagico(4)