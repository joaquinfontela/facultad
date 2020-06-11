def ochoReinas():

	listaDeCoordenadas = []

	exito = False 

	j = 0

	while ((j < 8)):

		exito, listaDeCoordenadas = colocarUnaReina(0, j, listaDeCoordenadas)

		j += 1

		if exito: 

			print(listaDeCoordenadas)

			exito = False

			listaDeCoordenadas = []

	
def colocarUnaReina(i, j, listaDeCoordenadas):

	coordenadasReinaActual = (i, j)

	exito = False

	for coordenada in listaDeCoordenadas:

		if ((coordenadasReinaActual [0] == coordenada [0]) or (coordenadasReinaActual [1] == coordenada [1])):

			return False, listaDeCoordenadas

		if (abs(coordenada [1] - coordenadasReinaActual [1]) == abs(coordenada [0] - coordenadasReinaActual [0])): 

			return False, listaDeCoordenadas

	listaDeCoordenadas.append(coordenadasReinaActual)

	if (len(listaDeCoordenadas) == 8):

		return True, listaDeCoordenadas

	k = 0

	while ((k < 8) and (not exito)):

		exito, listaDeCoordenadas = colocarUnaReina(i+1, k, listaDeCoordenadas)

		k += 1

	if not exito: 

		listaDeCoordenadas.pop(i)

	return exito, listaDeCoordenadas


ochoReinas()





