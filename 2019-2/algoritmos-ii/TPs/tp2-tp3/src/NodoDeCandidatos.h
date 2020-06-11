#ifndef NODODECANDIDATOS_H_
#define NODODECANDIDATOS_H_

#include "Vertice.h"


/*
 * Un NodoDeCandidatos contiene a un vertice,
 * el peso correspondiente que cuesta llegar
 * a el desde su predecesor y un bool que indica
 * si ya ha sido visitado
 *
 */
class NodoDeCandidatos {

	private:

		Vertice * vertice;
		double peso;
		Vertice * predecesor;
		bool yaSeVisito;

	public:

		/*
		 * Pre:
		 * Post: Crea un NodoDeCoste con un vertice, su predecesor
		 * y el peso correspondiente que cuesta llegar desde su
		 * predecesor a el
		 */
		NodoDeCandidatos(Vertice * vertice, double peso, Vertice * predecesor);

		/*
		 * Pre:
		 * Post: Se ha cambiado el predecesor
		 */
		void cambiarPredecesor(Vertice * nuevoPredecesor);

		/*
		 * Pre:
		 * Post: Se ha cambiado el peso
		 */
		void cambiarPeso(double nuevoPeso);

		/*
		 * Pre:
		 * Post: El candidato yaHaSidoVisitado
		 */
		void cambiarSiYaHaSidoVistado();

		/*
		 * Pre:
		 * Post: Devuelve true si yaHaSidoVistado
		 */
		bool yaHaSidoVisitado();

		/*
		 * Pre:
		 * Post: Devuelve el vertice
		 */
		Vertice * obtenerVertice();

		/*
		 * Pre:
		 * Post: Devuelve el peso
		 */
		double obtenerPeso();

		/*
		 * Pre:
		 * Post: Devuelve el Predecesor
		 */
		Vertice * obtenerPredecesor();

		/*
		 * Pre:
		 * Post: Libera los recursos tomados por el NodoDeCandidatos
		 */
		~NodoDeCandidatos();
};

#endif /* NODODECANDIDATOS_H_ */
