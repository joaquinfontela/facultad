#include "NodoArista.h"

NodoArista::NodoArista(Vertice * vertice, double peso){

	this-> vertice = vertice;
	this-> peso = peso;
}


Vertice * NodoArista::obtenerVertice(){

	return this->vertice;

}


double NodoArista::obtenerPeso(){

	return this->peso;

}


void NodoArista::cambiarVertice(Vertice * nuevoVertice){

	this->vertice = nuevoVertice;

}


void NodoArista::cambiarPeso(double nuevoPeso){

	this->peso = nuevoPeso;

}


NodoArista::~NodoArista(){

}


