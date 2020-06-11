#ifndef VERTICE_H_
#define VERTICE_H_

#include "PuntosDeTrasbordo.h"

/*
 * Un Vertice tiene una longitud y latitud, y los
 * transportes que se encuentran en el
 *
 */
class Vertice {

	private:

		double longitud;
		double latitud;
		PuntosDeTrasbordo * transportesEnElVertice;


	public:

		/*
		 * Pre:
		 * Post: Crea un vertice sin transportes en esa longitud y latitud
		 */
		Vertice(double longitud, double latitud);

		/*
		 * Pre:
		 * Post: agrega una nuevaParada a la lista de paradasDeColectivos
		 *
		 */
		void agregarParadaDeColectivo(ParadaDeColectivo* nuevaParada);

		/*
		 * Pre:
		 * Post: agrega una nuevaBocaDeSubte a la lista de bocasDeSubtes
		 *
		 */
		void agregarBocaDeSubte(BocaDeSubte* nuevaBocaDeSubte);
		/*
		 * Pre:
		 * Post: agrega una nuevaEstacionDeTren a la lista de estacionesDeTrenes
		 *
		 */
		void agregarEstacionDeTren(EstacionDeTren* nuevaEstacionDeTren);

		/*
		 * Pre:
		 * Post: agrega un nuevoGaraje a la lista de Garajes
		 *
		 */
		void agregarGaraje(Garaje* nuevoGaraje);


		/*
		 * Pre:
		 * Post: Devuelve la latitud
		 */
		double obtenerLatitud();

		/*
		 * Pre:
		 * Post: Devuelve la longitud
		 */
		double obtenerLongitud();


		/*
		 * Pre:
		 * Post: Devuelve un puntero a transportesEnElVertice
		 */
		PuntosDeTrasbordo * obtenerTransportesEnElVertice();
		
		/*
		 * Pre:
		 * Post: Libera los recursos tomados por el Vertice
		 */
		~Vertice();

	private:

		/*
		 * Pre:
		 * Post: Devuelve true si no esta nuevaParada
		 */
		bool noEstaLaParada(ParadaDeColectivo* nuevaParada);

		/*
		 * Pre:
		 * Post: Devuelve true si no esta nuevaBocaDeSubte
		 */
		bool noEstaLaBocaDeSubte(BocaDeSubte* nuevaBocaDeSubte);

		/*
		 * Pre:
		 * Post: Devuelve true si no esta nuevaEstacionDeTren
		 */
		bool noEstaLaEstacionDeTren(EstacionDeTren* nuevaEstacionDeTren);


		/*
		 * Pre:
		 * Post: Devuelve true si no esta nuevoGaraje
		 */
		bool noEstaElGaraje(Garaje* nuevoGaraje);
};

#endif /* VERTICE_H_ */
