/*
 * salida.cpp
 *
 *  Created on: Sep 19, 2019
 *      Author: joaquinfontela
 */

#include "LineaArchivo.h"
#include "salida.h"
#include "funciones_secundarias_salida.h"

#include <iostream>
#include <fstream>
#include <string>

using namespace std;





void imprimirMenu() {

	/*Imprimo el menu para el usuario, para salir de este debera presionar '*'. */

	cout << "Indique lo que desea hacer a continuación:" << endl;
	cout << "1. Filtrar por rango de longitud." << endl;
	cout << "2. Filtrar por rango de latitud." << endl;
	cout << "3. Filtrar por ID exacto." << endl;
	cout << "(Para salir del menú de opciones ingrese '*')." << endl;
	cout << "Su respuesta: ";
}





void filtrarDatosPorLongitud(struct LineaArchivo lineas[], long double longitudMinima, long double longitudMaxima, string &respuesta) {

	/* Muestra por pantalla la cantidad de datos pedidos que cumplen con el filtro ingresado por el usuario */

	int contador = 0; // cuenta la cantidad de hechos que cumplen con el filtro.
	for (int i = 0; i < 230; i++) {

		if (lineas[i].longitud >= longitudMinima && lineas[i].longitud <= longitudMaxima) {

			contador++;
			if (respuesta == "S" || respuesta == "s") {   // el usuario pidio imprimir los datos.

				cout << endl << "ID: " << lineas[i].ID << ". Nombre: " << lineas[i].nombre << ". Longitud: " << lineas[i].longitud;
			}
		}
	}
	cout << endl << endl << "La cantidad total filtrada es de " << contador << "." << endl << endl;
}





void filtrarDatosPorLatitud(struct LineaArchivo lineas[], long double latitudMinima, long double latitudMaxima, string &respuesta) {

	/* Muestra por pantalla la cantidad de datos pedidos que cumplen con el filtro ingresado por el usuario */

	int contador = 0; // cuenta la cantidad de hechos que cumplen con el filtro.
	for (int i = 0; i < 230; i++) {

		if (lineas[i].latitud >= latitudMinima && lineas[i].latitud <= latitudMaxima) {

			contador++;
			if (respuesta == "S" || respuesta == "s") {  // el usuario pidio imprimir los datos.

				cout << endl << "ID: " << lineas[i].ID << ". Nombre: " << lineas[i].nombre << ". Latitud: " << lineas[i].latitud;
			}
		}
	}
	cout << endl << endl << "La cantidad total filtrada es de " << contador << "." << endl << endl;
}





void filtrarPorIDExacto(struct LineaArchivo lineas[], int IDIngresado) {

	/* Muestra por pantalla los datos del ID pedido.
	 * En caso de ser un ID invalido, le advierte por pantalla al usuario. */

	int i = 0;
	while (lineas[i].ID != IDIngresado && i < 231) {

		// busca el id ingresado linea por linea del array.
		i++;
	}

	if (i < 231) {  // imprime los datos del ID ingresado.

		cout << endl << "ID: " << lineas[i].ID << ".";

		cout << endl << "Nombre: " << lineas[i].nombre << ".";

		cout << endl << "Longitud: " << lineas[i].longitud << ". Latitud: " << lineas[i].latitud << ".";

		cout << endl << "Calle 1: " << lineas[i].calle1 << ". Calle 2: " << lineas[i].calle2 << ". Interseccion: " << lineas[i].interseccion << ".";

		cout << endl << "Lineas sentido norte: " << lineas[i].lineasSentidoNorte << ". Lineas sentido sur: " << lineas[i].lineasSentidoSur << ".";

		cout << endl << "Metrobus: " << lineas[i].metrobus << ". Nombre sentido: " << lineas[i].nomSentid << ".";

		cout << endl << "Observaciones: " << lineas[i].observaciones << endl;

	} else {  	// si i llega a valer 231 significa que el programa reviso todo el array y no encontro el ID.

		cout << endl << "El ID ingresado no es valido." << endl << endl;
	}
}





void ejecucionDelArchivo(struct LineaArchivo lineas []){

	string ingresoUsuario = "not *";  // inicializo la variable de manera que entre en el ciclo while.
	while (ingresoUsuario != "*") {

		imprimirMenu();
		cin >> ingresoUsuario;


		/* Usuario ingresa 1 para filtrar por longitud */

		if (ingresoUsuario == "1"){

			long double longitudMinima, longitudMaxima;
			string respuesta;
			
			/* Pide al usuario el rango de longitud */
			cout << endl << "Ingrese la longitud mínima del rango:";
			cin >> longitudMinima;
			cout << endl << "Ingrese la longitud máxima del rango:";
			cin >> longitudMaxima;
			cout << endl << "Desea imprimir los datos? (S/N)  ";

			cin >> respuesta;
			while (respuesta != "S" && respuesta != "s" && respuesta != "N" && respuesta != "n"){
				
				//Validacion de la respuesta.
				
				cout << endl << "Respuesta no valida.";
				cout << endl << "Desea imprimir los datos? (S/N)  ";
				cin >> respuesta;
			}

			filtrarDatosPorLongitud(lineas, longitudMinima, longitudMaxima, respuesta);
		}


		/* Usuario ingresa 2 para filtrar por latitud. */

		else if (ingresoUsuario == "2"){

			long double latitudMinima, latitudMaxima;
			string respuesta;

			/* Pide al usuario el rango de latitud */
			cout << endl << "Ingrese la latitud mínima del rango:";
			cin >> latitudMinima;
			cout << endl << "Ingrese la latitud máxima del rango:";
			cin >> latitudMaxima;
			cout << endl << "Desea imprimir los datos? (S/N)  ";

			cin >> respuesta;
			while (respuesta != "S" && respuesta != "s" && respuesta != "N" && respuesta != "n"){
				//Validacion de la respuesta.
				cout << endl << "Respuesta no valida.";
				cout << endl << "Desea imprimir los datos? (S/N)  ";
				cin >> respuesta;
			}

			filtrarDatosPorLatitud(lineas, latitudMinima, latitudMaxima, respuesta);
		}


		/* Usuario ingresa 3 para filtrar por ID exacto. */

		else if (ingresoUsuario == "3"){

			int IDIngresado;

			/* Pide al usuario el ID exacto. */
			cout << endl << "Ingrese el ID:";
			cin >> IDIngresado;

			filtrarPorIDExacto(lineas, IDIngresado);
		}

		
		/* Usuario ingresa * para salir del menu y del programa. */
		
		else if (ingresoUsuario == "*"){
			cout << endl << "Hasta luego.";
		}
		
		
		
		else {  // en el caso de que el usuario ingrese cualquier otra instruccion (y por lo tanto invalida).
			cout << endl << "La instrucción indicada no es válida." << endl << endl;
		}
	}


}
