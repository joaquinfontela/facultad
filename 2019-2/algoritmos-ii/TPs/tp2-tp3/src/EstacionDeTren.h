#ifndef ESTACIONDETREN_H_
#define ESTACIONDETREN_H_

#include <string>
/*
 * Una EstacionDeTren contiene su ubicacion en la coordenada longitud y latitud
 * junto con su nombreDeEstacion, su linea y ramal.
 *
 */
class EstacionDeTren{

	private:

		double longitud;
		double latitud;
		unsigned int id;
		std::string nombreDeEstacion;
		std::string linea;
		std::string ramal;

	public:

		/*
		 * Pre:
		 * Post: Crea una EstacionDeTren en condiciones de ser usada
		 *
		 */
		EstacionDeTren(double longitud, double latitud, unsigned int id, std::string nombreEstacion, std::string linea, std::string ramal);

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
		 * Post: Devuelve el nombreDeEstacion
		 */
		std::string obtenerNombreDeEstacion() const;

		/*
		 * Pre:
		 * Post Devuelve la linea del tren
		 */
		std::string obtenerLinea() const;

		/*
		 * Pre:
		 * Post: Devuelve el ramal del tren
		 */
		std::string obtenerRamal() const;

		/*
		 * Pre:
		 * Post: Libera recursos tomados
		 */
		~EstacionDeTren();
};


#endif /* ESTACIONDETREN_H_ */
