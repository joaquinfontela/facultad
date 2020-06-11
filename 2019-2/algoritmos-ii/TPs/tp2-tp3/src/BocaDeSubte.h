#ifndef BOCADESUBTE_H_
#define BOCADESUBTE_H_

#include <string>
/*
 * Una BocaDeSubte es un punto de ingreso y egreso al subte, este guarda su ubicacion
 * en la coordenada longitud y latitud, junto con su linea, el nombreDeEstacion y un id
 *
 */
class BocaDeSubte{
	private:

		double longitud;
		double latitud;
		unsigned int id;
		std::string linea;
		std::string nombreDeEstacion;

	public:

		/*
		 * Pre:
		 * Post: Crea una BocaDeSubte en condiciones de ser usada
		 */
		BocaDeSubte(double longitud, double latitud, unsigned int id, std::string linea, std::string nombreDeEstacion);

		/*
		 * Pre:
		 * Post: Devuelve la coordenada longitud
		 */
		double obtenerLongitud() const;

		/*
		 * Pre:
		 * Post: Devuelve la coordenada latitud
		 */
		double obtenerLatitud() const;

		/*
		 * Pre:
		 * Post: Devuelve el id
		 */
		unsigned int obtenerId() const;

		/*
		 * Pre:
		 * Post: Devuelve la linea de Subte
		 */
		std::string obtenerLinea() const;

		/*
		 * Pre:
		 * Post: Devuelve el nombreDeEstacion de la BocaDeSubte
		 */
		std::string obtenerNombreDeEstacion() const;

		/*
		 * Pre:
		 * Post: Libera los recursos tomados
		 *
		 */
		~BocaDeSubte();

};



#endif /* BOCADESUBTE_H_ */
