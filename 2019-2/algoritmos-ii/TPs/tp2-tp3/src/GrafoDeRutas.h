#ifndef GRAFODERUTAS_H_
#define GRAFODERUTAS_H_

#include "Lista.h"
#include "NodoDeAdyacencia.h"

/*
 * Un GrafoDeRutas modeliza como se comunican distintos Vertices
 * compuestos por PuntosDeTrasbordo formando rutas entre si
 *
 */
class GrafoDeRutas {

	private:

		Lista<NodoDeAdyacencia *> * listaDeAdyacencia;

	public:

		/*
		 * Pre:
		 * Post: Se crea un grafoDeRutas con un Vertice origen y un Vertice destino
		 * sin aristas
		 */
		GrafoDeRutas(Vertice * origen, Vertice * destino);

		/*
		 * Pre: estaElVertice unVertice y otroVertice Y el peso no es negativo
		 * Post: Se ha agregado una arista de peso entre unVertice y otroVertice
		 */
		void agregarArista(Vertice * unVertice, Vertice * otroVertice, double peso);

		/*
		 * Pre: No estaElVertice aAgregar
		 * Post: Se ha agregado el Vertice aAgregar
		 */
		void agregarVertice(Vertice * aAgregar);

		/*
		 * Pre:
		 * Post: Devuelve true si estaElVertice
		 */
		bool estaElVertice(double longitud, double latitud);

		/*
		 * Pre:
		 * Post: Decuelve true si hay una arista entre unVertice y otroVertice
		 */
		bool estaLaArista(Vertice * unVertice, Vertice * otroVertice);
	
		/*
		 * Pre: estaElVertice
		 * Post: Devuelve el vertice pedido
		 */
		Vertice * obtenerVertice(double longitud, double latitud);


		/*
		 * Pre: estaElVertice unVertice
		 * Post: Devuelve la lista de vertices adyacentes a unVertice
		 */
		Lista<NodoArista *> * obtenerAdyacentes(Vertice * unVertice);

		/*
		 * Pre:
		 * Post: Devuelve un puntero a la lista de adyacencia
		 */
		Lista<NodoDeAdyacencia *> * obtenerListaDeAdyacencia();

		/*
		 * Pre:
		 * Post: Verifica si los vertices son iguales
		 */
		bool sonIguales(double longitud, double latitud, Vertice* vertice);

		/*
		 * Pre:
		 * Post: Libera los recursos tomados por el grafoDeRutas
		 */
		~GrafoDeRutas();
};

#endif /* GRAFODERUTAS_H_ */
