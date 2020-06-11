#ifndef LECTORDEARCHIVOS_H_
#define LECTORDEARCHIVOS_H_

#include <iostream>
#include <fstream>
#include "LectorCSV.h"
#include "PuntosDeTrasbordo.h"


/*
 * Constantes
 */
const char DELIMITADOR = ',';


/*
 * Un lector de archivos se encarga de leer los archivos CSV indicados y guardar
 * temporalmente los datosLeidos en ellos
 *
 */
class LectorDeArchivos{

	private:

		std::string rutaArchivoTrenes;
		std::string rutaArchivoSubtes;
		std::string rutaArchivoColectivos;
		std::string rutaArchivoGarajes;
		LectorCSV * lector;
		PuntosDeTrasbordo * datosLeidos;

	public:

		/*
		 * Pre: Las rutas pasadas por parametro deben ser validas
		 * Post: Crea un Lector de archivos con las rutas pasadas por parametro
		 *
		 */
		LectorDeArchivos(std::string rutaArchivoTrenes, std::string rutaArchivoSubtes,
	 	 	 	         std::string rutaArchivoColectivos, std::string rutaArchivoGarajes);

		/*
		 * Pre:
		 * Post: Carga los datos leidos del archivo en datosLeidos
		 *
		 */
		void leerArchivoTrenes();

		/*
		 * Pre:
		 * Post: Carga los datos leidos del archivo en datosLeidos
		 *
		 */
		void leerArchivoSubtes();

		/*
		 * Pre:
		 * Post: Carga los datos leidos del archivo en datosLeidos
		 *
		 */
		void leerArchivoColectivos();

		/*
		 * Pre:
		 * Post: Carga los datos leidos del archivo en datosLeidos
		 *
		 */
		void leerArchivoGarajes();

		/*
		 * Pre:
		 * Post: Devuelve un puntero a los datosLeidos
		 *
		 */
		PuntosDeTrasbordo * obtenerDatosLeidos();

		/*
		 * Pre:
		 * Post: Libera los recursos tomados por la estructura
		 *
		 */
		~LectorDeArchivos();

	private:

		/*
		 * Pre: Se ha generado una lineaParseada
		 * Post: Guarda los datos presentes en la linea del CSV
		 */
		void guardarDatosTrenes(Cola<std::string> * lineaParseada);

		/*
		 * Pre: Se ha generado una lineaParseada
		 * Post: Guarda los datos presentes en la linea del CSV
		 */
		void guardarDatosSubtes(Cola<std::string> * lineaParseada);

		/*
		 * Pre: Se ha generado una lineaParseada
		 * Post: Guarda los datos presentes en la linea del CSV
		 */
		void guardarDatosColectivos(Cola<std::string> * lineaParseada);

		/*
		 * Pre: Se ha generado una lineaParseada
		 * Post: Guarda los datos presentes en la linea del CSV
		 */
		void guardarDatosGarajes(Cola<std::string> * lineaParseada);








};


#endif /* LECTORDEARCHIVOS_H_ */
