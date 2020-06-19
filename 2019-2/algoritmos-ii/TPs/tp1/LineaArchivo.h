/*
 * LineaArchivo.h
 *
 *  Created on: Sep 18, 2019
 *      Author: joaquinfontela
 */

#ifndef LINEAARCHIVO_H_
#define LINEAARCHIVO_H_


#include <string>


/* Creo un struct que guardara una linea de informacion,
 * con los datos correspondientes a ella.
 */


struct LineaArchivo {

	long double longitud;
	long double latitud;
	int ID;
	std :: string nombre;
	std :: string calle1;
	std :: string calle2;
	std :: string interseccion;
	std :: string lineasSentidoNorte;
	std :: string lineasSentidoSur;
	std :: string metrobus;
	std :: string nomSentid;
	std :: string observaciones;

};


#endif /* LINEAARCHIVO_H_ */
