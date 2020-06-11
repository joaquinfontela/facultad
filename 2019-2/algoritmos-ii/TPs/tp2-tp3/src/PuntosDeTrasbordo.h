#ifndef PUNTOSDETRASBORDO_H_
#define PUNTOSDETRASBORDO_H_

#include "EstacionDeTren.h"
#include "BocaDeSubte.h"
#include "ParadaDeColectivo.h"
#include "Garaje.h"
#include "Lista.h"

/*
 *	Se encarga del almacenamiento de PuntosDeTrasbordo de los diferentes medios de transporte tales como:
 *	EstacionesDeTrenes, ParadasDeColectivos, BocasDeSubtes y Garajes
 *
 */
class PuntosDeTrasbordo{

	private:

		Lista<EstacionDeTren*> * estacionesDeTrenes;
		Lista<BocaDeSubte*> * bocasDeSubtes;
		Lista<ParadaDeColectivo*> * paradasDeColectivos;
		Lista<Garaje*> * garajes;

	public:

		/*
		 * Pre:
		 * Post: Se crea la clase sin PuntosDeTrasbordo
		 *
		 */
		PuntosDeTrasbordo();

		/*
		 * Pre:
		 * Post: Copia los PuntosDeTrasbordo de los medios de tranporte de otrosMediosDeTransporte
		 *
		 */
		PuntosDeTrasbordo(PuntosDeTrasbordo * otrosMediosDeTransporte);

		/*
		 * Pre:
		 * Post: Devuelve un puntero a una lista estacionesDeTrenes en caso de que esta no este vacia,
		 *  o un puntero a Null
		 *
		 */
		Lista<EstacionDeTren*>* obtenerEstacionesDeTrenes() const;

		/*
		 * Pre:
		 * Post: Devuelve un puntero a una lista bocasDeSubtes en caso de que esta no este vacia,
		 *  o un puntero a Null
		 *
		 */
		Lista<BocaDeSubte*>* obtenerBocasDeSubtes() const;

		/*
		 * Pre:
		 * Post: Devuelve un puntero a una lista paradasDeColectivos en caso de que esta no este vacia,
		 *  o un puntero a Null
		 *
		 */
		Lista<ParadaDeColectivo*>* obtenerParadasDeColectivos() const;

		/*
		 * Pre:
		 * Post: Devuelve un puntero a una lista de garajes en caso de que esta no este vacia,
		 *  o un puntero a Null
		 *
		 */
		Lista<Garaje*>* obtenerGarajes() const;

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
		 * Post: Devuelve true en caso de que las estacionesDeTren, bocasDeSubtes,
		 * paradasDeColectivos y garajes esta vacia
		 *
		 */
		bool estaVacia();


		/*
		 * Pre:
		 * Post: Devuelve true en caso de que las estacionesDeTren
		 */
		bool estacionesDeTrenEstaVacia();

		/*
		 * Pre:
		 * Post: Devuelve true en caso de que las paradasDeColectivos
		 *
		 */
		bool paradasDeColectivoEstaVacia();

		/*
		 * Pre:
		 * Post: Devuelve true en caso de que las bocasDeSubtes
		 *
		 */
		bool bocasDeSubteEstaVacia();

		/*
		 * Pre:
		 * Post: Devuelve true en caso de que los garajes
		 *
		 */
		bool garajesEstaVacia();


		/*
		 * Pre:
		 * Post: Se liberan los recursos tomados por los medios de transporte
		 *
		 */
		~PuntosDeTrasbordo();

	private:

		/*
		 * Pre:
		 * Post: Agrega las otrasEstacionesDeTrenes en la lista estacionesDeTrenes
		 *
		 */
		void copiarEstacionesDeTrenes(Lista<EstacionDeTren*>& otrasEstacionesDeTrenes);

		/*
		 * Pre:
		 * Post: Agrega las otrasBocasDeSubte en la lista bocasDeSubte
		 *
		 */
		void copiarBocasDeSubtes(Lista<BocaDeSubte*>& otrasBocasDeSubte);

		/*
		 * Pre:
		 * Post: Agrega las otrasParadasDeColectivo en la lista paradasDeColectivo
		 *
		 */
		void copiarParadasDeColectivos(Lista<ParadaDeColectivo*>& otrasParadasDeColectivo);

		/*
		 * Pre:
		 * Post: Agrega los otrosGarajes en la lista garajes
		 *
		 */
		void copiarGarajes(Lista<Garaje*>& otrosGarajes);
};



#endif /* PUNTOSDETRASBORDO_H_ */
