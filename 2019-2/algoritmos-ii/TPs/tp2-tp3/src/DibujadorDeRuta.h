#ifndef DIBUJADORDERUTA_H_
#define DIBUJADORDERUTA_H_

#include "Lista.h"
#include "Coordenada.h"
#include "DibujadorBMP.h"
#include <string>


/*
 * Constantes
 */
const int OFFSET = 100;
const int GROSOR = 5;
const int RADIO = 10;

const std::string COLOR_PUNTO_SALIDA = "Rojo"; //Color es "Rojo", "Verde" o "Azul"
const std::string COLOR_PUNTO_INTERMEDIOS = "Azul";
const std::string COLOR_PUNTO_LLEGADA = "Verde";
const std::string COLOR_LINEA = "Azul";


/*
 * Un DibujadorDeRuta se encarga del dibujado de la ruta a
 * un formato en imagen BMP
 *
 */
class DibujadorDeRuta {

	private:

		DibujadorBMP * dibujador;
		int anchoDeLaImagen;
		int largoDeLaImagen;
		Lista<Coordenada<int>*> * recorridoParaDibujar;


	public:

		/*
		 * Pre: recorrido no esta vacia, anchoDeLaImagen, largoDeLaImagen son numeros naturales
		 * Post: Crea un DibujadorDeRuta en condiciones de dibujarRuta
		 *
		 */
		DibujadorDeRuta(Lista<Coordenada<double>*> * recorrido, int anchoDeLaImagen, int largoDeLaImagen);

		/*
		 * Pre: rutaImagen es la ruta donde se guardara la imagen BMP
		 * Post: Se ha dibujado y guardado la imagen
		 *
		 */
		void dibujarRuta(std::string rutaImagen);

		/*
		 * Pre:
		 * Post: Libera recursos tomados por el DibujadorDeRuta
		 *
		 */
		~DibujadorDeRuta();

	private:


		/*
		 * Pre: recorrido no esta vacia
		 * Post: Convierte las coordenadas del recorrido guardando en recorridoParaDibujar
		 * coordenadas escaladas para el dibujo
		 */
		void convertirCoordenadas(Lista<Coordenada<double>*> * recorrido);


		/*
		 * Pre: recorrido no esta vacia
		 * Post: Devuelve los minimos y maximos presentes en recorrido
		 */
		void obtenerCoordenadasCriticas(Lista<Coordenada<double>*> * recorrido,
										double & minimoX, double & minimoY,
										double & maximoX, double & maximoY);

		/*
		 * Pre: Se han convertido las coordenadas
		 * Post: Dibuja las conexiones del recorrido en la imagen
		 */
		void dibujarConexiones();


		/*
		 * Pre: Se han convertido las coordenadas
		 * Post: Dibuja las paradas del recorrido
		 */
		void dibujarParadas();


		/*
		 * Pre: Se han convertido coordenadas
		 * Post: Se libera los recursos tomados por recorridoParaDibujar
		 */
		void borrarRecorrido();


};

#endif /* DIBUJADORDERUTA_H_ */
