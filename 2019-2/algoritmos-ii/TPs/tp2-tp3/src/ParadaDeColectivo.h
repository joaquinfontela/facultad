#ifndef PARADADECOLECTIVO_H_
#define PARADADECOLECTIVO_H_

#include <string>
/*
 *
 * Una ParadaDeColectivo es una ubicacion en el mapa que posee una coordenada longitud y latitud,
 * un nombre de la calleDeLaParada, donde se puede acceder a un colectivo de una determinada lineaDeColectivo
 *
 *
 */
class ParadaDeColectivo{

	private:

		double longitud;
		double latitud;
		std::string calleDeLaParada;
		std::string lineaDeColectivo;


	public:

		/*
		 * Pre:
		 * Post: Crea una ParadaDeColectivo en condiciones de ser usada
		 *
		 */
		ParadaDeColectivo(double longitud, double latitud,
						  std::string calleDeLaParada,
						  std::string lineaDeColectivo);

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
		 * Post: Devuelve la calleDeLaParada de la ParadaDeColectivo
		 */
		std::string obtenerCalleDeLaParada() const;


		/*
		 * Pre:
		 * Post: Devuelve la lineaDeColectivo de la ParadaDeColectivo
		 */
		std::string obtenerLineaDeColectivo() const;


		/*
		 * Pre:
		 * Post: Libera los recursos tomados
		 *
		 */
		~ParadaDeColectivo();

};


#endif /* PARADADECOLECTIVO_H_ */
