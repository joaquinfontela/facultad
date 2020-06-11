#include "Vertice.h"

Vertice::Vertice(double longitud, double latitud){

	this-> longitud = longitud;
	this-> latitud = latitud;
	this->transportesEnElVertice = new PuntosDeTrasbordo;
}

double Vertice::obtenerLatitud(){

	return this->latitud;
}

double Vertice::obtenerLongitud(){

	return this->longitud;
}

void Vertice::agregarParadaDeColectivo(ParadaDeColectivo* nuevaParada){

	if(this->noEstaLaParada(nuevaParada)){

		this->transportesEnElVertice->agregarParadaDeColectivo(nuevaParada);
	}
}

void Vertice::agregarBocaDeSubte(BocaDeSubte* nuevaBocaDeSubte){


	if(this->noEstaLaBocaDeSubte(nuevaBocaDeSubte)){

		this->transportesEnElVertice->agregarBocaDeSubte(nuevaBocaDeSubte);

	}
}

void Vertice::agregarEstacionDeTren(EstacionDeTren* nuevaEstacionDeTren){

	if(this->noEstaLaEstacionDeTren(nuevaEstacionDeTren)){

		this->transportesEnElVertice->agregarEstacionDeTren(nuevaEstacionDeTren);

	}
}
void Vertice::agregarGaraje(Garaje* nuevoGaraje){

	if(this->noEstaElGaraje(nuevoGaraje)){

		this->transportesEnElVertice->agregarGaraje(nuevoGaraje);

	}
}

PuntosDeTrasbordo * Vertice::obtenerTransportesEnElVertice(){

	return transportesEnElVertice;

}

bool Vertice::noEstaLaParada(ParadaDeColectivo* nuevaParada){

	bool noEsta = true;
	Lista<ParadaDeColectivo*> * paradasDeColectivos = this->transportesEnElVertice->obtenerParadasDeColectivos();

	paradasDeColectivos->iniciarCursor();
	while(paradasDeColectivos->avanzarCursor()){

		ParadaDeColectivo * paradaGuardada = paradasDeColectivos->obtenerCursor();
		if(paradaGuardada == nuevaParada){
			noEsta = false;
		}

	}
	return noEsta;
}

bool Vertice::noEstaLaBocaDeSubte(BocaDeSubte* bocaDeSubte){

	bool noEsta = true;
	Lista<BocaDeSubte*> * bocasDeSubte = this->transportesEnElVertice->obtenerBocasDeSubtes();

	bocasDeSubte->iniciarCursor();
	while(bocasDeSubte->avanzarCursor()){

		BocaDeSubte * bocaDeSubte = bocasDeSubte->obtenerCursor();
		if(bocaDeSubte == bocaDeSubte){
			noEsta = false;
		}

	}
	return noEsta;
}

bool Vertice::noEstaLaEstacionDeTren(EstacionDeTren* nuevaEstacionDeTren){

	bool noEsta = true;
	Lista<EstacionDeTren*> * estacionesDeTren = this->transportesEnElVertice->obtenerEstacionesDeTrenes();

	estacionesDeTren->iniciarCursor();
	while(estacionesDeTren->avanzarCursor()){

		EstacionDeTren * estacion = estacionesDeTren->obtenerCursor();
		if(estacion == nuevaEstacionDeTren){
			noEsta = false;
		}

	}
	return noEsta;
}

bool Vertice::noEstaElGaraje(Garaje* nuevoGaraje){


	bool noEsta = true;
	Lista<Garaje*> * garajes = this->transportesEnElVertice->obtenerGarajes();

	garajes->iniciarCursor();
	while(garajes->avanzarCursor()){

		Garaje * garaje = garajes->obtenerCursor();
		if(garaje == nuevoGaraje){
			noEsta = false;
		}

	}
	return noEsta;

}



Vertice::~Vertice(){

	delete transportesEnElVertice;
}
