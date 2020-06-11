#include "EstacionDeTren.h"


using namespace std;



EstacionDeTren::EstacionDeTren(double longitud, double latitud, unsigned int id, string nombreEstacion, string linea, string ramal){

	this->longitud = longitud;
	this->latitud = latitud;
	this->id = id;
	this->nombreDeEstacion = nombreEstacion;
	this->linea = linea;
	this->ramal = ramal;

}


double EstacionDeTren::obtenerLongitud() const {

	return this->longitud;

}


double EstacionDeTren::obtenerLatitud() const {

	return this->latitud;

}


unsigned int EstacionDeTren::obtenerId() const {

	return this->id;

}


string EstacionDeTren::obtenerNombreDeEstacion() const {

	return this->nombreDeEstacion;

}


string EstacionDeTren::obtenerLinea() const {

	return this->linea;

}


string EstacionDeTren::obtenerRamal() const {

	return this->ramal;

}


EstacionDeTren::~EstacionDeTren(){

}

