#ifndef GARAJE_H_
#define GARAJE_H_

#include <string>

/*
 *
 * Un Garaje es un punto de interes ubicado en el mapa con un nombreDeLaCalle y una alturaDeLaCalle
 * donde uno puede estacionar su auto. Almacenando su ubicacion en coordenadas longitud
 * y latitud
 *
 *
 */
class Garaje{

	private:

		double longitud;
		double latitud;
		std::string nombreDeLaCalle;
		unsigned int alturaDeLaCalle;

	public:

		/*
		 * Pre:
		 * Post: Crea un Garaje en condiciones de ser usado
		 */
		Garaje(double longitud, double latitud, std::string nombreDeLaCalle, unsigned int alturaDeLaCalle);

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
		 * Post: Devuelve el nombreDeLaCalle donde esta ubicado el Garaje
		 */
		std::string obtenerNombreDeLaCalle() const;

		/*
		 * Pre:
		 * Post: Devuelve la alturaDeLaCalle donde esta ubicado el Garaje
		 */
		unsigned int obtenerAlturaDeLaCalle() const;

		/*
		 * Pre:
		 * Post: Libera los recursos tomados
		 */
		~Garaje();
};

#endif /* GARAJE_H_ */
