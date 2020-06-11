#ifndef LECTORCSV_H_
#define LECTORCSV_H_

#include <iostream>
#include <fstream>
#include <string>
#include "Cola.h"



/*
 * Un LectorCSV se encarga de la lectura de archivos CSV,
 * facilitando la obtencion de sus datos
 *
 */
class LectorCSV{

	private:

		Cola<std::string> * lineaParseada;

	public:

		/*
		 * Pre:
		 * Post: Crea un LectorCSV en condiciones de ser usado
		 */
		LectorCSV();

		/*
		 * Pre: El archivo ya se encuentra abierto y no ha llegado al final
		 * Post: Lee una linea del archivo guardando sus campos en una Cola
		 * de strings
		 *
		 */
		void leerLinea(std::ifstream& archivo, unsigned int campos,char delimitador);

		/*
		 * Pre: El archivo ya se encuentra abierto y no ha llegado al final
		 * Post: Lee una linea del archivo, salteandola
		 *
		 */
		void saltearLinea(std::ifstream& archivo);

		/*
		 * Pre: El archivo ya se encuentra abierto y no ha llegado al final
		 * Post: Cuenta la cantidad de campos en una linea separada por un delimitador,
		 * salteando dicha linea
		 */
		unsigned int contarCampos(std::ifstream& archivo, char delimitador);

		/*
		 * Pre:
		 * Post: Devueleve un puntero a la lineaParseada o NULL
		 */
		Cola<std::string> * obtenerLineaParseada() const;

		/*
		 * Pre: El valor debe ser un digito ejemplo:
		 * 		valor = "5"  ---->  devuelve 5
		 * Post: Devuelve el valor convertido a entero
		 */
		int convertirStringAInt(std::string valor);


		/*
		 * Pre: El valor debe ser un digito ejemplo:
		 * 		valor = "3.1415"  ---->  devuelve 3.1415
		 * Post: Devuelve el valor convertido a double
		 *
		 */
		double convertirStringADouble(std::string valor);


		/*
		 * Pre:
		 * Post: Libera los recursos tomados
		 */
		~LectorCSV();

};

#endif /* LECTORCSV_H_ */
