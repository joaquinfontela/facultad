#include "Ruta.h"
using namespace std;



Ruta::Ruta(PuntosDeTrasbordo* todosLosTransportes, double xInicial, double xFinal, double yInicial, double yFinal){


	this-> geolocalizador = new GeolocalizadorDeCombinaciones(todosLosTransportes, xFinal, yFinal, xInicial, yInicial, DOS_CUADRAS);

	GrafoDeRutas * grafo = geolocalizador->obtenerGrafo();

	this-> dijkstra = new Dijkstra(grafo);

	this-> coordenadasDeLaRuta = new Lista<Coordenada<double>*>;

	this-> mejorRuta = calcularRuta(xInicial, xFinal, yInicial, yFinal);

	this-> transportesDeMejorRuta = generarRutaDeTransportes();
}



Lista<Vertice*> * Ruta::calcularRuta(double xInicial, double xFinal, double yInicial, double yFinal){


	Vertice * origen = geolocalizador->obtenerGrafo()->obtenerVertice(xInicial, yInicial);
	Vertice * destino = geolocalizador->obtenerGrafo()->obtenerVertice(xFinal, yFinal);

	this->dijkstra->calcularRutaMinima(origen, destino);

	this->dijkstra->reconstruirRutaMinima(origen, destino);

	return this->dijkstra->obtenerRutaMinima();

}

Lista<PuntosDeTrasbordo *> * Ruta::generarRutaDeTransportes(){


	Lista<PuntosDeTrasbordo *> * rutaConTranportes = new Lista<PuntosDeTrasbordo *>;
	this-> mejorRuta->iniciarCursor();
	while(this->mejorRuta->avanzarCursor()){

		PuntosDeTrasbordo * transportes = this->mejorRuta->obtenerCursor()->obtenerTransportesEnElVertice();
		rutaConTranportes->agregar(transportes);

	}
	return rutaConTranportes;

}

Lista<PuntosDeTrasbordo*> * Ruta::obtenerRuta(){



	return transportesDeMejorRuta;
}



Lista<Coordenada<double>*>* Ruta::obtenerCoordenadas(){

	return coordenadasDeLaRuta;

}



void Ruta::setCoordenadas(){


	this->mejorRuta->iniciarCursor();
	while(this->mejorRuta->avanzarCursor()){

		Vertice * vertice = this->mejorRuta->obtenerCursor();

		Coordenada<double> * coordenada = new Coordenada<double>(vertice->obtenerLongitud(), vertice->obtenerLatitud());

		this->coordenadasDeLaRuta-> agregar(coordenada);

	}


}



bool Ruta::hayRuta(){

	return (this->mejorRuta != NULL && !this->mejorRuta->estaVacia());
}


Ruta::~Ruta(){


	this->coordenadasDeLaRuta->iniciarCursor();

	while(this->coordenadasDeLaRuta->avanzarCursor()){
		delete this->coordenadasDeLaRuta->obtenerCursor();
	}

	delete this->coordenadasDeLaRuta;

	delete this->dijkstra;

	delete this->transportesDeMejorRuta;

	delete geolocalizador;

}
