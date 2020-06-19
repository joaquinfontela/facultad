/*
 * lectura_y_guardado.cpp
 *
 *  Created on: Sep 11, 2019
 *      Author: joaquinfontela
 */

#include "lectura_y_guardado.h"
#include "LineaArchivo.h"
#include "funciones_secundarias_lec_y_guard.h"


#include <iostream>
#include <fstream>
#include <string>


using namespace std;


int procesarUnaLinea(int contadorNumeroDato, string dato, int &contadorLinea, struct LineaArchivo lineas []) {

	/* Procesa una linea del archivo y guarda la informacion en el array de structs (un struct = una linea) */

	if (contadorNumeroDato == 0) {
		long double datoLongDouble = stod(dato, NULL); // convierto string en long double.
		lineas[contadorLinea].longitud = datoLongDouble; // lo agrego al array
	}

	if (contadorNumeroDato == 1) {
		long double datoLongDouble = stod(dato, NULL); // convierto string en long double.
		lineas[contadorLinea].latitud = datoLongDouble; // lo agrego al array
	}

	if (contadorNumeroDato == 2) {
		int datoInt = stoi(dato, NULL); // convierto string en int.
		lineas[contadorLinea].ID = datoInt; // lo agrego al array
	}

	if (contadorNumeroDato == 3) {
		lineas[contadorLinea].nombre = dato; // lo agrego al array
	}

	if (contadorNumeroDato == 4) {
		lineas[contadorLinea].calle1 = dato; // lo agrego al array
	}

	if (contadorNumeroDato == 5) {
		lineas[contadorLinea].calle2 = dato; // lo agrego al array
	}

	if (contadorNumeroDato == 6) {
		lineas[contadorLinea].interseccion = dato; // lo agrego al array
	}

	if (contadorNumeroDato == 7) {
		lineas[contadorLinea].lineasSentidoNorte = dato; // lo agrego al array
	}

	if (contadorNumeroDato == 8) {
		lineas[contadorLinea].lineasSentidoSur = dato; // lo agrego al array
	}

	if (contadorNumeroDato == 9) {
		lineas[contadorLinea].metrobus = dato; // lo agrego al array
	}

	if (contadorNumeroDato == 10) {
		lineas[contadorLinea].nomSentid = dato; // lo agrego al array
	}

	if (contadorNumeroDato == 11) {
		lineas[contadorLinea].observaciones = dato; // lo agrego al array
		contadorNumeroDato = -1;  // reseteo el contador (a -1 y no a 0, ya que abajo se le sumara 1).
		contadorLinea++;  //  avanzo en 1 el contador para avanzar de posicion en el array.
	}

	contadorNumeroDato++; //  aumenta en 1 el contador para continuar avanzando en el struct.
	return contadorNumeroDato;

}

void leerArchivoYGuardarInformacion (string rutaArchivo, struct LineaArchivo lineas []) {

	/*Crea la variable archivo y lo abre*/

	ifstream archivo;
	archivo.open(rutaArchivo.c_str());


	/* lee la primera línea completa */

	string primeraLinea, dato;
	getline(archivo, primeraLinea);


	/* Arranco un contador en 0 que ira aumentando y me servira para saber que tipo de dato estoy guardando,
	 * y otro que me permite saber en que linea estoy.
	 * Ademas, arranco un ciclo while que ira guardando la informacion en el array de structs.
	 */

	int contadorNumeroDato = 0, contadorLinea = 0;

	while (! archivo.eof()) {  // ciclo while hasta que lea todo el archivo.

		if (0 <= contadorNumeroDato && contadorNumeroDato < 11){
			getline(archivo, dato, ','); // lee hasta la proxima coma (un elemento de la linea).

		} else {
			getline(archivo, dato, '\n');  // lee hasta el salto de linea, ya que es el ultimo elemento de esta.
		}

		if (! archivo.eof()){

		contadorNumeroDato = procesarUnaLinea(contadorNumeroDato, dato, contadorLinea, lineas);
		}
	}

	archivo.close();	//cierro el archivo.
}
