#include "GrafoDeRutas.h"




GrafoDeRutas::GrafoDeRutas(Vertice * origen, Vertice * destino){

	this-> listaDeAdyacencia = new Lista<NodoDeAdyacencia *>;
	this->agregarVertice(origen);
	this->agregarVertice(destino);
}


void GrafoDeRutas::agregarArista(Vertice * unVertice, Vertice * otroVertice, double peso){

	NodoDeAdyacencia * nodoDeUnVertice;
	NodoDeAdyacencia * nodoDeOtroVertice;
	NodoDeAdyacencia * nodoDeAdyacencia;
	Vertice * vertice;

	this->listaDeAdyacencia->iniciarCursor();
	while(this->listaDeAdyacencia->avanzarCursor()){

		nodoDeAdyacencia = this->listaDeAdyacencia->obtenerCursor();
		vertice = nodoDeAdyacencia->obtenerVertice();

		if(vertice == unVertice){

			nodoDeUnVertice = nodoDeAdyacencia;

		}
		else if(vertice == otroVertice){

			nodoDeOtroVertice = nodoDeAdyacencia;
		}
	}

	nodoDeUnVertice->agregarArista(otroVertice, peso);
	nodoDeOtroVertice->agregarArista(unVertice, peso);


}


void GrafoDeRutas::agregarVertice(Vertice * aAgregar){

	NodoDeAdyacencia* nodoAdyacente = new NodoDeAdyacencia(aAgregar);

	this->listaDeAdyacencia->agregar(nodoAdyacente);

}


bool GrafoDeRutas::estaElVertice(double longitud, double latitud){

	bool esta = false;

	NodoDeAdyacencia * nodoDeAdyacencia;
	Vertice * vertice;

	this->listaDeAdyacencia->iniciarCursor();
	while(this->listaDeAdyacencia->avanzarCursor()){

		nodoDeAdyacencia = this->listaDeAdyacencia->obtenerCursor();
		vertice = nodoDeAdyacencia->obtenerVertice();
		if(sonIguales(longitud, latitud, vertice)){
			esta = true;
		}
	}
	return esta;
}

bool GrafoDeRutas::estaLaArista(Vertice * unVertice, Vertice * otroVertice){


	NodoDeAdyacencia * nodoDeAdyacencia;
	Vertice * vertice;

	bool esta = false;

	this->listaDeAdyacencia->iniciarCursor();
	while(this->listaDeAdyacencia->avanzarCursor()){

		nodoDeAdyacencia = this->listaDeAdyacencia->obtenerCursor();
		vertice = nodoDeAdyacencia->obtenerVertice();

		if(unVertice == vertice){

			esta = nodoDeAdyacencia->yaEsAdyacente(otroVertice);

		}
	}
	return esta;
}


Vertice* GrafoDeRutas::obtenerVertice(double longitud, double latitud){

	NodoDeAdyacencia * nodoDeAdyacencia;
	Vertice * verticePedido = NULL;

	this->listaDeAdyacencia->iniciarCursor();
	while(this->listaDeAdyacencia->avanzarCursor()){

		nodoDeAdyacencia = this->listaDeAdyacencia->obtenerCursor();
		Vertice * vertice = nodoDeAdyacencia->obtenerVertice();
		if(sonIguales(longitud, latitud, vertice)){
			verticePedido = vertice;
		}
	}

	if(verticePedido == NULL){

		throw std::string("No estaElVertice pedido para obtener");
	}

	return verticePedido;
}


Lista<NodoArista *> * GrafoDeRutas::obtenerAdyacentes(Vertice * unVertice){


	Lista<NodoArista*> * adyacentes = NULL;

	this->listaDeAdyacencia->iniciarCursor();
	while(this->listaDeAdyacencia->avanzarCursor()){

		NodoDeAdyacencia * nodoDeAdyacencia = this->listaDeAdyacencia->obtenerCursor();
		Vertice * vertice = nodoDeAdyacencia->obtenerVertice();

		if(unVertice == vertice){

			adyacentes = nodoDeAdyacencia->obtenerVerticesAdyacentes();
		}
	}

	return adyacentes;
}


Lista<NodoDeAdyacencia *> * GrafoDeRutas::obtenerListaDeAdyacencia(){

	return listaDeAdyacencia;

}

bool GrafoDeRutas::sonIguales(double longitud, double latitud, Vertice* vertice){

	return(longitud == vertice->obtenerLongitud())&&(latitud == vertice->obtenerLatitud());

}

GrafoDeRutas::~GrafoDeRutas(){

	this->listaDeAdyacencia->iniciarCursor();
	while(this->listaDeAdyacencia->avanzarCursor()){

		delete this->listaDeAdyacencia->obtenerCursor();
	}
	delete this->listaDeAdyacencia;
}
