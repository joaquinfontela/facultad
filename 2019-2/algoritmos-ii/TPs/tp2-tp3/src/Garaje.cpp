#include "Garaje.h"

using namespace std;



Garaje::Garaje(double longitud, double latitud, string nombreDeLaCalle, unsigned int alturaDeLaCalle){

	this->longitud = longitud;
	this->latitud = latitud;
	this->nombreDeLaCalle = nombreDeLaCalle;
	this->alturaDeLaCalle = alturaDeLaCalle;

}


double Garaje::obtenerLongitud() const{

	return this->longitud;
}

double Garaje::obtenerLatitud() const{

	return this->latitud;
}


string Garaje::obtenerNombreDeLaCalle() const{

	return this->nombreDeLaCalle;
}


unsigned int Garaje::obtenerAlturaDeLaCalle() const{

	return this->alturaDeLaCalle;
}


Garaje::~Garaje(){

}
