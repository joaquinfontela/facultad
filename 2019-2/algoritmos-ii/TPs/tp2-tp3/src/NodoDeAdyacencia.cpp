#include "NodoDeAdyacencia.h"


NodoDeAdyacencia::NodoDeAdyacencia(Vertice * elVertice){

	this->elVertice = elVertice;
	this->verticesAdyacentes = new Lista<NodoArista*>;

}

void NodoDeAdyacencia::agregarArista(Vertice * otroVertice, double peso){

	if(!yaEsAdyacente(otroVertice)){

		NodoArista* nodoArista = new NodoArista(otroVertice, peso);
		this->verticesAdyacentes->agregar(nodoArista);
	}
}


bool NodoDeAdyacencia::yaEsAdyacente(Vertice * unVertice){

	NodoArista* nodoArista;

	this->verticesAdyacentes->iniciarCursor();
	while(this->verticesAdyacentes->avanzarCursor()){

		nodoArista = verticesAdyacentes->obtenerCursor();

		if(nodoArista->obtenerVertice() == unVertice){
			return true;
		}
	}

	return false;

}


bool NodoDeAdyacencia::sonIguales(Vertice* vertice){

	return((vertice->obtenerLongitud() == this->elVertice->obtenerLongitud())&&(vertice->obtenerLatitud() == this->elVertice->obtenerLatitud()));
}



Vertice * NodoDeAdyacencia::obtenerVertice(){

	return this->elVertice;

}

Lista<NodoArista *> * NodoDeAdyacencia::obtenerVerticesAdyacentes(){

	return this->verticesAdyacentes;
}

NodoDeAdyacencia::~NodoDeAdyacencia(){

	this->verticesAdyacentes->iniciarCursor();
	while(this->verticesAdyacentes->avanzarCursor()){
		delete this->verticesAdyacentes->obtenerCursor();
	}

	delete this->verticesAdyacentes;

}
