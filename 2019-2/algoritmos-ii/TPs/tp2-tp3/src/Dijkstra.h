#ifndef DIJKSTRA_H_
#define DIJKSTRA_H_

#include "GrafoDeRutas.h"
#include "NodoDeCandidatos.h"
#include "Pila.h"

/*
 * Constantes
 */
const double PESO_INFINITO = -1;


class Dijkstra {

	private:

		GrafoDeRutas * grafo;
		Lista<NodoDeCandidatos * > * listaDeCandidatos;
		Lista<Vertice * > * rutaMinima;


	public:

		/*
		 * Pre: Existe un grafo conexo con los pesos en las aristas
		 * positivos
		 * Post: Se ha creado Dijkstra con una lista de candidatos
		 */
		Dijkstra(GrafoDeRutas * grafo);

		/*
		 * Pre: origen y destino pertencen al grafo conexo
		 * Post: Se ha calculado la ruta minima
		 */
		void calcularRutaMinima(Vertice * origen, Vertice * destino);

		/*
		 * Pre: Se ha reconstruido la ruta minima
		 * Post: Devuelve una lista con la ruta para llegar al destino
		 */
		Lista<Vertice * > * obtenerRutaMinima();

		/*
		 * Pre:
		 * Post: Se ha reconstruido la ruta calculada por Dijkstra
		 */
		void reconstruirRutaMinima(Vertice * origen, Vertice * destino);

		/*
		 * Pre:
		 * Post: Libera los recursos tomados por Dijkstra
		 */
		~Dijkstra();

	private:


		/*
		 * Pre: Existe un grafo conexo con los pesos en las aristas
		 * positivos
		 * Post: Se ha inicializado la listaDeCandidatos
		 *
		 */
		void inicializarListasDeCandidatos(Vertice * origen);

		/*
		 * Pre:
		 * Post: Inicializa el coste de los vertices adyacentes
		 * al origen
		 */
		void inicializarCosteDeVerticesAdyacentesAl(Vertice * origen);

		/*
		 * Pre:
		 * Post: Devevuelve true si quedanVerticesSinChequear
		 */
		bool quedanVerticesSinChequear();

		/*
		 * Pre:
		 * Post: Se marca al candidato como visitado
		 */
		void chequearCandidato(NodoDeCandidatos * candidato);

		/*
		 * Pre:
		 * Post: Devuelve al mejorCandidato
		 */
		NodoDeCandidatos * obtenerMejorCandidato();

		/*
		 * Pre:
		 * Post: Busca unVertice en la listaDeCandidatos
		 */
		NodoDeCandidatos * buscarEnListaDeCandidatos(Vertice * unVertice);

		/*
		 * Pre:
		 * Post: Devuelve true si el desvio desde otroVertice
		 * mejora el camino
		 */
		bool esUnMejorCamino(double pesoDeUnVerticeDesdeElOrigen,
						   	 double pesoDeOtroVerticeDesdeElOrigen,
						     double pesoDeUnVerticeDesdeOtroVertice);

		/*
		 * Pre:
		 * Post: Devuelve true si unPeso > otroPeso
		 */
		bool esUnPesoMenor(double unPeso,double otroPeso);

		/*
		 * Pre:
		 * Post: Mejora el camino del adyacenteAlCandidato
		 */
		void mejorarCamino(NodoDeCandidatos * adyacenteAlCandidato, double pesoMenor, Vertice * nuevoPredecesor);


};

#endif /* DIJKSTRA_H_ */
