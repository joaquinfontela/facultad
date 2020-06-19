/*
 * funciones_secundarias_salida.h
 *
 *  Created on: Sep 19, 2019
 *      Author: joaquinfontela
 */

#ifndef FUNCIONES_SECUNDARIAS_SALIDA_H_
#define FUNCIONES_SECUNDARIAS_SALIDA_H_

#include <string>

// Imprime el menu de opciones por pantalla.

void imprimirMenu() ;

/* Pre: debera recibir un array de structs de 230 elementos, una longitud maxima y una minima, y una respuesta (S o N).
 * Pos: imprimira por pantalla aquellos datos que cumplan con el filtro y respuesta ingresados.
 */

void filtrarDatosPorLongitud(struct LineaArchivo lineas[], long double longitudMinima, long double longitudMaxima, std :: string &respuesta);

/* Pre: debera recibir un array de structs de 230 elementos, una latitud maxima y una minima, y una respuesta (S o N).
 * Pos: imprimira por pantalla aquellos datos que cumplan con el filtro y respuesta ingresados.
 */

void filtrarDatosPorLatitud(struct LineaArchivo lineas[], long double latitudMinima, long double latitudMaxima, std :: string &respuesta);

/* Pre: debera recibir un array de structs de 230 elementos y un ID.
 * Pos: imprimira por pantalla aquellos datos del ID ingresado,
 * o en caso de ser invalido, se advertira al usuario de ello.
 */

void filtrarPorIDExacto(struct LineaArchivo lineas[], int IDIngresado) ;


#endif /* FUNCIONES_SECUNDARIAS_SALIDA_H_ */
