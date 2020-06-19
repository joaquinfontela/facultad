/*
 * funciones_secundarias_lec_y_guard.h
 *
 *  Created on: Sep 19, 2019
 *      Author: joaquinfontela
 */

#ifndef FUNCIONES_SECUNDARIAS_LEC_Y_GUARD_H_
#define FUNCIONES_SECUNDARIAS_LEC_Y_GUARD_H_

#include <string>

/* Pre : Recibe dos contadores (una para el dato a guardar, otro para la linea del archivo), un dato del archivo,
 * y el array de 230 structs.
 * Pos : guarda cada uno de los datos de una linea (dato a dato) en cada uno de los atributos del struct correspondiente.
 */

int procesarUnaLinea(int contadorNumeroDato, std :: string dato, int &contadorLinea, struct LineaArchivo lineas []);

#endif /* FUNCIONES_SECUNDARIAS_LEC_Y_GUARD_H_ */
