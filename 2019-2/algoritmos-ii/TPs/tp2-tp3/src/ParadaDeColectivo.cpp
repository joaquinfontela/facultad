#include "ParadaDeColectivo.h"

using namespace std;


ParadaDeColectivo::ParadaDeColectivo(double longitud, double latitud,
									 string calleDeLaParada,
									 string lineaDeColectivo) {

	this->longitud = longitud;
	this->latitud = latitud;
	this->calleDeLaParada = calleDeLaParada;
	this->lineaDeColectivo = lineaDeColectivo;

}



double ParadaDeColectivo::obtenerLongitud() const{

	return this->longitud;
}


double ParadaDeColectivo::obtenerLatitud() const{

	return this->latitud;
}


string ParadaDeColectivo::obtenerCalleDeLaParada() const{

	return this->calleDeLaParada;
}


string ParadaDeColectivo::obtenerLineaDeColectivo() const{

	return this->lineaDeColectivo;
}


ParadaDeColectivo::~ParadaDeColectivo(){

}

