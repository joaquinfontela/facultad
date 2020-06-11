#ifndef NODODEADYACENCIA_H_
#define NODODEADYACENCIA_H_

#include "Vertice.h"
#include "NodoArista.h"


/*
 * Un NodoDeAdyacencia guarda un vertice y sus vertices adyacentes en
 * listas de aristas
 *
 */
class NodoDeAdyacencia {

	private:

		Vertice * elVertice;
		Lista<NodoArista *>* verticesAdyacentes;

	public:

		/*
		 * Pre:
		 * Post: Se ha creado un NodoDeAdyacencia con elVertice y
		 * sin aristas conectadas a dicho vertice
		 */
		NodoDeAdyacencia(Vertice * elVertice);

		/*
		 * Pre: otroVertice no es elVertice y otroVertice no se encuentra en verticesAdyacentes
		 * Post: Se ha agregado otroVertice a los verticesAdyacentes
		 */
		void agregarArista(Vertice * otroVertice, double peso);

		/*
		 * Pre:
		 * Post: Devuelve true si unVertice ya pertence a los verticesAdyacentes
		 */
		bool yaEsAdyacente(Vertice * unVertice);

		/*
		 * Pre:
		 * Post: Devuelve elVertice
		 */
		Vertice * obtenerVertice();

		/*
		 * Pre:
		 * Post: Verifica si los vertices son iguales
		 */
		bool sonIguales(Vertice* vertice);
	
	
		/*
		 * Pre:
		 * Post: devuelve la lista de vertices adyacentes
		 */
		Lista<NodoArista *> * obtenerVerticesAdyacentes();


		/*
		 * Pre:
		 * Post: Se liberan los recursos tomados por el NodoDeAdyacencia
		 */
		~NodoDeAdyacencia();
};

#endif /* NODODEADYACENCIA_H_ */
