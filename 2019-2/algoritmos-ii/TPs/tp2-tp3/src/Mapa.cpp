#include "Mapa.h"


Mapa::Mapa(){

}

void Mapa::iniciarMapa(){


	ManejadorDeDatos * manejadorDeDatos = new ManejadorDeDatos(RUTA_ARCHIVO_TRENES, RUTA_ARCHIVO_SUBTES, RUTA_ARCHIVO_COLECTIVOS, RUTA_ARCHIVO_GARAJES);

	PuntosDeTrasbordo * puntosDeTrasbordoInicial = manejadorDeDatos->obtenerPuntosDeTrasbordo();

	Interfaz* interfaz = new Interfaz();


	interfaz->iniciar();



	Ruta * ruta =  new Ruta(puntosDeTrasbordoInicial,
							interfaz->obtenerLongitudInicial(), interfaz->obtenerLongitudFinal(),
							interfaz->obtenerLatitudInicial(), interfaz->obtenerLatitudFinal());



	interfaz->finalizar(ruta->obtenerRuta(), RUTA_DEL_ARCHIVO_A_DIBUJAR);


	if(ruta->hayRuta()){

		ruta->setCoordenadas();

		DibujadorDeRuta * dibujador = new DibujadorDeRuta(ruta->obtenerCoordenadas(), ANCHO_DE_LA_IMAGEN, LARGO_DE_LA_IMAGEN);

		dibujador->dibujarRuta(RUTA_DEL_ARCHIVO_A_DIBUJAR);

		delete dibujador;
	}

	delete interfaz;
	delete ruta;
	delete manejadorDeDatos;
}

Mapa::~Mapa(){

}
