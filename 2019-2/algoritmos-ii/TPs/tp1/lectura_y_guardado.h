/*
 * lectura_y_guardado.h
 *
 *  Created on: Sep 11, 2019
 *      Author: joaquinfontela
 */

#ifndef LECTURA_Y_GUARDADO_H_
#define LECTURA_Y_GUARDADO_H_

#include <string>

//Pre: debe recibir un archivo y un array de structs validos.
//Pos: guardara todos los datos del archivo en el array de structs, de manera que cada linea del archivo sea un struct del array.

void leerArchivoYGuardarInformacion (std :: string rutaArchivo, struct LineaArchivo lineas[]);

#endif /* LECTURA_Y_GUARDADO_H_ */
