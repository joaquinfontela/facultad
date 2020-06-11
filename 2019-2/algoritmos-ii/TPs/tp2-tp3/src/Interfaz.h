#ifndef INTERFAZ_H_
#define INTERFAZ_H_

#include <string>
#include "PuntosDeTrasbordo.h"
#include "Lista.h"
#include <iostream>


/*
 * Una Interfaz es la encargada de la interaccion con el usuario
 * asi como tambien la parte visual del programa
 *
 */
class Interfaz{

private:

	double latitudInicial;
	double latitudFinal;
	double longitudInicial;
	double longitudFinal;

public:

	/*
	 * Pre:
	 * Post: Inicializa la latitud y longitud en 0.0
	 *
	 */
	Interfaz();

	/*
	 * Pre: Recibe la latitud inicial en numeros reales
	 * Post: devuelve la latitud en tipo double
	 *
	 */
	double obtenerLatitudInicial();

	/*
	 * Pre: Recibe la latitud final en numeros reales
	 * Post: devuelve la latitud en tipo double
	 */
	double obtenerLatitudFinal();

	/*
	 * Pre: Recibe la longitud inicial en numeros reales
	 * Post: devuelve la longitud en tipo double
	 */

	double obtenerLongitudInicial();

	/*
	 *	Pre: Recibe la longitud final en numeros reales
	 *	Post: devuelve la longitud en tipo double
	 */
	double obtenerLongitudFinal();

	/*
	 * Post: Muestra un mensaje de bienvenida y pide datos
	 */

	void iniciar();

	/*
	 * Pre: Recibe la mejor ruta
	 * Post: Finaliza el programa, dando los resultados del recorrido a realizarse
	 */

	void finalizar(Lista<PuntosDeTrasbordo*>* mejorRuta, std::string rutaImagen);

private:

	/*
	 * Post: Solicita al usuario que ingrese la latitud inicial
	 * y devuelve como tipo de dato un string
	 */

	void pideLatitudInicial();

	/*
	 * Post: Solicita al usuario que ingrese la latitud final
	 * y devuelve como tipo de dato un string
	 */

	void pideLatitudFinal();

	/*
	 * Post: Solicita al usuario que ingrese la longitud inicial
	 * y devuelve como tipo de dato un string
	 */

	void pideLongitudInicial();

	/*
	 * Post: Solicita al usuario que ingrese la longitud final
	 * y devuelve como tipo de dato un string
	 */

	void pideLongitudFinal();

	/*
	 * Pre: recibe un dato de tipo string
	 * Post: devuelve true si el dato es un numero y es positivo
	 *
	 */

	bool tipoDeDatoValido(std::string const& numero);

	/*
	 * Pre: recibe un dato de tipo string
	 * Post: Devuelve true si es positivo
	 */

	bool esPositivo(std::string const& numero);

	/*
	 * Pre: Recibe una lista de estaciones de trenes de la mejor ruta
	 * Post: Muestra los datos de la lista
	 */

	void mostrarEstacionesDeTrenes(Lista<EstacionDeTren*>* estacionesDeTrenes);

	/*
	 * Pre: Recibe una lista de paradas de colectivos
	 * Post: Muestra los datos de la lista
	 */

	void mostrarParadasDeColectivos(Lista<ParadaDeColectivo*>* paradasDeColectivos);

	/*
	 * Pre: Recibe una lista de bocas de subte
	 * Post: Muestra los datos de la lista
	 */

	void mostrarBocaDeSubte(Lista<BocaDeSubte*>* bocasDeSubte);

	/*
	 * Pre: Recibe una lista de garajes
	 * Post: Muestra los datos de la lista
	 */

	void mostrarGarajes(Lista<Garaje*>* garajes);

};


#endif /* INTERFAZ_H_ */
