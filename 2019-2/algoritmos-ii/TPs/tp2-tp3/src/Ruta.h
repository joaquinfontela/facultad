#ifndef RUTA_H_
#define RUTA_H_

#include <string>
#include "Lista.h"
#include "PuntosDeTrasbordo.h"
#include "Coordenada.h"
#include "GeolocalizadorDeCombinaciones.h"
#include "Dijkstra.h"

/*
 * Constantes
 */
const double DOS_CUADRAS = 0.0024;

/*
 * Ruta se encarga del calculo de la ruta optima
 */
class Ruta{

	private:

		Lista<Vertice*> * mejorRuta;

		Lista<PuntosDeTrasbordo *> * transportesDeMejorRuta;

		Lista<Coordenada<double>*>* coordenadasDeLaRuta;

		GeolocalizadorDeCombinaciones* geolocalizador;

		Dijkstra * dijkstra;


	public:


		/*
		 * Pre: Recibe transportes iniciales junto las coordenadas del origen y destino.
		 * Post: Crea una Ruta en condiciones de ser usada
		 */
		Ruta(PuntosDeTrasbordo* todosLosTransportes,
			 double xInicial, double xFinal,
			 double yInicial, double yFinal);


		/*
		 * Pre:
		 * Post: Devuelve los  transportes de la mejor ruta.
		 */
		Lista<PuntosDeTrasbordo*> * obtenerRuta();


		/*
		 * Pre:
		 * Post: Devuelve las coordenadas de la mejor ruta.
		 */
		Lista<Coordenada<double>*>* obtenerCoordenadas();


		/*
		 * Pre:
		 * Post: Setea las coordenadas en la lista de coordenadas
		 */
		void setCoordenadas();


		/*
		 * Pre:
		 * Post: Devuelve true si hay una ruta que llega del origen
		 * al destino pedidos
		 */
		bool hayRuta();

		/*
		 * Pre:
		 * Post: Libera recursos
		 */
		~Ruta();


	private:


		/*
		 * Pre: Ya se ha calculado LA mejorRuta
		 * Post: Devuelve los transportesDeLaMejorRuta
		 */
		Lista<PuntosDeTrasbordo *> * generarRutaDeTransportes();

		/*
		 * Pre: Recibe coordenadas iniciales y finales.
		 * Post: Genera la ruta.
		 */
		Lista<Vertice*> * calcularRuta(double xInicial, double xFinal,
									   double yInicial, double yFinal);


};

#endif /* RUTA_H_ */
