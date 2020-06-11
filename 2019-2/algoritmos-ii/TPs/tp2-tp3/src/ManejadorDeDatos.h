#ifndef MANEJADORDEDATOS_H_
#define MANEJADORDEDATOS_H_

#include "PuntosDeTrasbordo.h"
#include "LectorDeArchivos.h"
#include <iostream>

/*
 * Un ManejadorDeDatos se encarga de cargar los datos de los respectivos .CSV
 * y guardar los respectivos PuntosDeTrabordo presentes en ellos.
 *
 */
class ManejadorDeDatos{

	private:

		PuntosDeTrasbordo * puntosDeTrasbordo;
		LectorDeArchivos * lectorDeArchivos;

	public:

		/*
		 * Pre:
		 * Post: Crea a un manejador de datos cargando los datos
		 *
		 */
		ManejadorDeDatos(std::string rutaArchivoTrenes, std::string rutaArchivoSubtes,
						 std::string rutaArchivoColectivos, std::string rutaArchivoGarajes);

		/*
		 * Pre:
		 * Post: Devuelve puntosDeTrasbordo almacenados, en caso de no haberse
		 * cargado datos devuelve un puntero a Null
		 *
		 */
		PuntosDeTrasbordo * obtenerPuntosDeTrasbordo() const;


		/*
		 * Pre:
		 * Post: Libera los recursos tomados por el manejador de datos
		 *
		 */
		~ManejadorDeDatos();

	private:


		/*
		 * Pre:
		 * Post: Lee los archivos correspondientes almacenando los medios de transporte
		 *
		 */
		void cargarDatos();


		/*
		 * Pre: La estructura esta llena con datos
		 * Post: Se borran los datos almacenados en los puntos de trasbordo cargados
		 */
		void borrarDatos();

		/*
		 * Pre: La estructura esta llena con datos
		 * Post: Se borran los datos de las estacionesDeTren
		 *
		 */
		void borrarEstacionesDeTren();

		/*
		 * Pre: La estructura esta llena con datos
		 * Post: Se borran los datos de las bocasDeSubtes
		 *
		 */
		void borrarBocasDeSubtes();

		/*
		 * Pre: La estructura esta llena con datos
		 * Post: Se borran los datos de las paradasDeColectivo
		 *
		 */
		void borrarParadasDeColectivo();

		/*
		 * Pre: La estructura esta llena con datos
		 * Post: Se borran los datos de los Garajes
		 *
		 */
		void borrarGarajes();



};




#endif /* MANEJADORDEDATOS_H_ */
