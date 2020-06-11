#include "BocaDeSubte.h"


using namespace std;




BocaDeSubte::BocaDeSubte(double longitud, double latitud, unsigned int id, std::string linea, string nombreDeEstacion){

	this->longitud = longitud;
	this->latitud = latitud;
	this->id = id;
	this->linea = linea;
	this->nombreDeEstacion = nombreDeEstacion;

}


double BocaDeSubte::obtenerLongitud() const{

	return this->longitud;

}


unsigned int BocaDeSubte::obtenerId() const {

	return this->id;

}


double BocaDeSubte::obtenerLatitud() const{

	return this->latitud;

}


std::string BocaDeSubte::obtenerLinea() const {

	return this->linea;

}


string BocaDeSubte::obtenerNombreDeEstacion() const {

	return this->nombreDeEstacion;

}


BocaDeSubte::~BocaDeSubte(){

}
