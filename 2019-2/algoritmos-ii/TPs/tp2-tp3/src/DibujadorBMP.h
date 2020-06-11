#ifndef DIBUJADORBMP_H_
#define DIBUJADORBMP_H

#include  "./BMP/EasyBMP.h"
#include <string>

/*
 * Constantes:
 */
const int INTENSIDAD_COLOR = 255; //Pertenece al intervalo [0, 255]

/*
 *
 * Un DibujadorBMP se encarga de operaciones como crear el BMP y facilita el dibujado
 * en el, ademas facilita el guardado
 *
 *
 */
class DibujadorBMP {

	private:

		BMP * imagen;
		int anchoDeLaImagen;
		int largoDeLaImagen;
		int grosor;


	public:

		/*
		 * Pre: anchoDeLaImagen, largoDeLaImagen y offset son todos numeros naturales
		 * Post: Se crea una imagen BMP con el anchoDeLaImagen, largoDeLaImagen
		 * y el grosor que seria el ancho de la linea
		 */
		DibujadorBMP(int anchoDeLaImagen, int largoDeLaImagen, int grosor);

		/*
		 * Pre: x pertenece al intervalo [0, anchoDeLaImagen - 1] y y al [0, largoDeLaImagen - 1],
		 *  radio > 0 y color es "Rojo", "Verde" o "Azul"
		 * Post: Dibuja un punto en esas coordenadas de radio y color especificado
		 *
		 */
		void dibujarPunto(int x, int y, int radio, std::string color);

		/*
		 * Pre: x pertenece al intervalo [0, anchoDeLaImagen - 1] y y al [0, largoDeLaImagen - 1] y
		 *  color es "Rojo", "Verde" o "Azul"
		 * Post: Dibuja una linea que conecta ambos puntos
		 */
		void dibujarLinea(int xInicial, int yInicial, int xFinal, int yFinal, std::string color);

		/*
		 * Pre: ruta del archivo donde se guardara el BMP
		 * Post: Se ha guardado el BMP en dicha ruta
		 */
		void escrbirBMP(std::string ruta);

		/*
		 * Pre:
		 * Post: Libera recursos tomados por el DibujadorBMP
		 *
		 */
		~DibujadorBMP();

	private:

		/*
		 * Pre: x pertenece al intervalo [0, anchoDeLaImagen - 1] y y al [0, largoDeLaImagen - 1] y
		 * color es "Rojo", "Verde" o "Azul"
		 * Post: Se ha establecido dicho color en ese pixel
		 */
		void establecerColor(int x, int y, std::string color);

		/*
		 * Pre: x pertenece al intervalo [0, anchoDeLaImagen - 1] y y al [0, largoDeLaImagen - 1] y
		 * color es "Rojo", "Verde" o "Azul"
		 * Post: Se ha dibujado una linea vertical entre esos puntos
		 */
		void dibujarLineaVertical(int x, int yInicial, int yFinal, std::string color);


		/*
		 * Pre: x pertenece al intervalo [0, anchoDeLaImagen - 1] y y al [0, largoDeLaImagen - 1] y
		 * color es "Rojo", "Verde" o "Azul"
		 * Post: Se ha dibujado una linea horizontal entre esos puntos
		 *
		 */
		void dibujarLineaHorizontal(int y, int xInicial, int xFinal, std::string color);
};

#endif /* DIBUJADORBMP_H_ */
