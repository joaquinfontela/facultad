#include "NodoDeCandidatos.h"

NodoDeCandidatos::NodoDeCandidatos(Vertice * vertice, double peso, Vertice * predecesor) {

	this->vertice = vertice;
	this->peso = peso;
	this->predecesor = predecesor;
	this->yaSeVisito = false;
}


void NodoDeCandidatos::cambiarPredecesor(Vertice * nuevoPredecesor){

	this->predecesor = nuevoPredecesor;

}

void NodoDeCandidatos::cambiarPeso(double nuevoPeso){

	this->peso = nuevoPeso;
}

void NodoDeCandidatos::cambiarSiYaHaSidoVistado(){

	this->yaSeVisito = true;

}

bool NodoDeCandidatos::yaHaSidoVisitado(){

	return this->yaSeVisito;
}



Vertice * NodoDeCandidatos::obtenerVertice(){

	return this->vertice;

}

double NodoDeCandidatos::obtenerPeso(){

	return this->peso;
}

Vertice * NodoDeCandidatos::obtenerPredecesor(){

	return this->predecesor;
}

NodoDeCandidatos::~NodoDeCandidatos() {

}

