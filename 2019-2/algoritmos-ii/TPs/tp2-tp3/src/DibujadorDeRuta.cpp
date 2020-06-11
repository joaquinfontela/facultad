#include "DibujadorDeRuta.h"

using namespace std;

DibujadorDeRuta::DibujadorDeRuta(Lista<Coordenada<double>*> * recorrido, int anchoDeLaImagen, int largoDeLaImagen){

	this->recorridoParaDibujar = NULL;
	this->dibujador = new DibujadorBMP(anchoDeLaImagen, largoDeLaImagen, GROSOR);
	this->anchoDeLaImagen = anchoDeLaImagen;
	this->largoDeLaImagen = largoDeLaImagen;
	this->convertirCoordenadas(recorrido);

}

void DibujadorDeRuta::dibujarRuta(string rutaImagen){


	this->dibujarConexiones();

	this->dibujarParadas();

	this->dibujador->escrbirBMP(rutaImagen);
}

void DibujadorDeRuta::dibujarConexiones(){

	Coordenada<int> * puntoAnterior = this->recorridoParaDibujar->obtener(1);

	this->recorridoParaDibujar->iniciarCursor();
	while(this->recorridoParaDibujar->avanzarCursor()){

		Coordenada<int> * puntoSiguiente = this->recorridoParaDibujar->obtenerCursor();



		this->dibujador->dibujarLinea(puntoAnterior->obtenerLongitud(), puntoAnterior->obtenerLatitud(),
									  puntoSiguiente->obtenerLongitud(), puntoSiguiente->obtenerLatitud(), COLOR_LINEA);

		puntoAnterior = puntoSiguiente;

	}
}

void DibujadorDeRuta::dibujarParadas(){

	unsigned int contador = 1;
	this->recorridoParaDibujar->iniciarCursor();
	while(this->recorridoParaDibujar->avanzarCursor()){

		Coordenada<int> * punto = this->recorridoParaDibujar->obtenerCursor();

		if(contador == 1){

			this->dibujador->dibujarPunto(punto->obtenerLongitud(), punto->obtenerLatitud(), RADIO, COLOR_PUNTO_SALIDA);

		}else if(contador == this->recorridoParaDibujar->contarElementos()){

			this->dibujador->dibujarPunto(punto->obtenerLongitud(), punto->obtenerLatitud(), RADIO, COLOR_PUNTO_LLEGADA);

		}else{

			this->dibujador->dibujarPunto(punto->obtenerLongitud(), punto->obtenerLatitud(), RADIO, COLOR_PUNTO_INTERMEDIOS);

		}
		contador++;
	}


}


void DibujadorDeRuta::convertirCoordenadas(Lista<Coordenada<double>*> * recorrido){



	double minimoX, minimoY, maximoX, maximoY;

	this->obtenerCoordenadasCriticas(recorrido, minimoX, minimoY, maximoX, maximoY);


	double desplazamientoX = maximoX - minimoX;
	double desplazamientoY = maximoY - minimoY;


	double factorDeConversionX = (this->anchoDeLaImagen - OFFSET)/ desplazamientoX;
	double factorDeConversionY = (this->largoDeLaImagen - OFFSET)/ desplazamientoY;


	this->recorridoParaDibujar = new Lista<Coordenada<int>*>;

	recorrido->iniciarCursor();
	while(recorrido->avanzarCursor()){

		Coordenada<double> * punto = recorrido->obtenerCursor();

		int x = ((punto->obtenerLongitud() - minimoX) * factorDeConversionX) + (OFFSET/2);
		int y = ((punto->obtenerLatitud() - minimoY) * factorDeConversionY) + (OFFSET/2);

		Coordenada<int> * puntoParaDibujar = new Coordenada<int>(x, y);
		recorridoParaDibujar->agregar(puntoParaDibujar);

	}


}


void DibujadorDeRuta::obtenerCoordenadasCriticas(Lista<Coordenada<double>*> * recorrido,
												 double & minimoX, double & minimoY,
												 double & maximoX, double & maximoY){


	Coordenada<double> * primerCoordenada = recorrido->obtener(1);

	minimoX = primerCoordenada->obtenerLongitud();
	maximoX = primerCoordenada->obtenerLongitud();
	minimoY = primerCoordenada->obtenerLatitud();
	maximoY = primerCoordenada->obtenerLatitud();

	recorrido->iniciarCursor();
	while(recorrido->avanzarCursor()){

		Coordenada<double> * coordenada = recorrido->obtenerCursor();

		double longitud = coordenada->obtenerLongitud();
		double latitud = coordenada->obtenerLatitud();


		if(minimoX > longitud){

			minimoX = longitud;

		}
		if(maximoX < longitud){

			maximoX = longitud;

		}
		if(minimoY > latitud){

			minimoY = latitud;

		}
		if(maximoY < latitud){

			maximoY = latitud;

		}

	}

}


DibujadorDeRuta::~DibujadorDeRuta() {


	this->borrarRecorrido();
	delete this->recorridoParaDibujar;
	delete this->dibujador;

}

void DibujadorDeRuta::borrarRecorrido(){


	this->recorridoParaDibujar->iniciarCursor();
	while(this->recorridoParaDibujar->avanzarCursor()){

		Coordenada<int> * aBorrar = this->recorridoParaDibujar->obtenerCursor();
		delete aBorrar;
	}
}

