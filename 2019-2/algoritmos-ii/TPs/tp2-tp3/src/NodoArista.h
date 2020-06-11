#ifndef NODOARISTA_H_
#define NODOARISTA_H_

#include "Vertice.h"

/*
 * Un NodoArista tiene un puntero al vertice que conecta la arista
 * y su peso
 *
 */
class NodoArista {

	private:

		Vertice * vertice;
		double peso;

	public:

		/*
		 * Pre:
		 * Post: Se ha creado la arista con el vertice y el peso
		 */
		NodoArista(Vertice * vertice, double peso);

		/*
		 * Pre:
		 * Post: Devuelve el vertice
		 */
		Vertice * obtenerVertice();

		/*
		 * Pre:
		 * Post: Devuelve el Peso
		 */
		double obtenerPeso();

		/*
		 * Pre:
		 * Post: Se ha cambiado el vertice a nuevoVertice
		 */
		void cambiarVertice(Vertice * nuevoVertice);

		/*
		 * Pre:
		 * Post: Se ha cambiado el peso a nuevoPeso
		 */
		void cambiarPeso(double nuevoPeso);

		/*
		 * Pre:
		 * Post: Libera recursos tomados por el nodoArista
		 */
		~NodoArista();
};

#endif /* NODOARISTA_H_ */
