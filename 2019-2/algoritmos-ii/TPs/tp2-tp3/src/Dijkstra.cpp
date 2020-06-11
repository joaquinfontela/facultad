#include "Dijkstra.h"


Dijkstra::Dijkstra(GrafoDeRutas * grafo) {

	this->grafo = grafo;
	this->rutaMinima = new Lista<Vertice * >;
	this->listaDeCandidatos = new Lista<NodoDeCandidatos *>;
}


void Dijkstra::calcularRutaMinima(Vertice * origen, Vertice * destino){


	this->inicializarListasDeCandidatos(origen);

	while(this->quedanVerticesSinChequear()){

		NodoDeCandidatos * mejorCandidato = this->obtenerMejorCandidato();

		if(mejorCandidato == NULL){

				return;

		}

		this->chequearCandidato(mejorCandidato);

		Vertice * verticeDelCandidato = mejorCandidato->obtenerVertice();

		if(verticeDelCandidato != destino){

			Lista<NodoArista* > * adyacentes = this->grafo->obtenerAdyacentes(verticeDelCandidato);

			adyacentes->iniciarCursor();
			while(adyacentes->avanzarCursor()){

				NodoArista * aristaAdyacente = adyacentes->obtenerCursor();

				Vertice * VerticeAdyacente = aristaAdyacente->obtenerVertice();

				if(VerticeAdyacente == origen){

					continue;

				}

				NodoDeCandidatos * adyacenteAlMejorCandidato = this->buscarEnListaDeCandidatos(VerticeAdyacente);


				double pesoDelVerticeAdyacenteDesdeElOrigen = adyacenteAlMejorCandidato->obtenerPeso();
				double pesoDelMejorCandidatoDesdeElOrigen = mejorCandidato->obtenerPeso();
				double pesoDelVerticeAdyacenteDesdeElCandidato = aristaAdyacente->obtenerPeso();

				if(this->esUnMejorCamino(pesoDelVerticeAdyacenteDesdeElOrigen,
										 pesoDelMejorCandidatoDesdeElOrigen,
										 pesoDelVerticeAdyacenteDesdeElCandidato)){

					double menorPeso = pesoDelMejorCandidatoDesdeElOrigen + pesoDelVerticeAdyacenteDesdeElCandidato;
					this->mejorarCamino(adyacenteAlMejorCandidato, menorPeso, verticeDelCandidato);
				}
			}
		}
	}
}



void Dijkstra::reconstruirRutaMinima(Vertice * origen, Vertice * destino){


	Pila<Vertice *> pilaDeVertices;

	NodoDeCandidatos * candidatoActual = this->buscarEnListaDeCandidatos(destino);

	while(candidatoActual->obtenerPredecesor() != NULL){

		Vertice * verticeActual = candidatoActual->obtenerVertice();

		pilaDeVertices.apilar(verticeActual);

		Vertice * verticePredecesor = candidatoActual->obtenerPredecesor();

		if(verticePredecesor == origen){

			pilaDeVertices.apilar(verticePredecesor);
			break;
		}

		candidatoActual = this->buscarEnListaDeCandidatos(verticePredecesor);

	}

	while(!pilaDeVertices.estaVacia()){

		this->rutaMinima->agregar(pilaDeVertices.desapilar());

	}

}

Lista<Vertice * > * Dijkstra::obtenerRutaMinima(){


	return this->rutaMinima;

}



bool Dijkstra::quedanVerticesSinChequear(){


	bool verticesSinChequear = false;

	this->listaDeCandidatos->iniciarCursor();
	while(this->listaDeCandidatos->avanzarCursor()){

		NodoDeCandidatos * candidato = this->listaDeCandidatos->obtenerCursor();
		if(!candidato->yaHaSidoVisitado()){

			verticesSinChequear = true;

		}

	}
	return verticesSinChequear;
}

void Dijkstra::chequearCandidato(NodoDeCandidatos * candidato){

	candidato->cambiarSiYaHaSidoVistado();

}

NodoDeCandidatos * Dijkstra::obtenerMejorCandidato(){


	double pesoMenor = PESO_INFINITO;
	NodoDeCandidatos * mejorCandidato = NULL;

	this->listaDeCandidatos->iniciarCursor();
	while(this->listaDeCandidatos->avanzarCursor()){

		NodoDeCandidatos * candidato = this->listaDeCandidatos->obtenerCursor();
		double pesoCandidato = candidato->obtenerPeso();

		if(!candidato->yaHaSidoVisitado() && this->esUnPesoMenor(pesoMenor, pesoCandidato)){

			mejorCandidato = candidato;

		}

	}
	return mejorCandidato;
}

bool Dijkstra::esUnPesoMenor(double unPeso,double otroPeso){


	if(otroPeso == PESO_INFINITO){

		return false;

	}else if(unPeso == PESO_INFINITO){

		return true;

	}else{

		return (unPeso > otroPeso);

	}
}


NodoDeCandidatos * Dijkstra::buscarEnListaDeCandidatos(Vertice * unVertice){


	NodoDeCandidatos * nodoDelVertice = NULL;
	NodoDeCandidatos * nodoDeAlgunVertice = NULL;

	this->listaDeCandidatos->iniciarCursor();
	while(this->listaDeCandidatos->avanzarCursor()){

		nodoDeAlgunVertice = this->listaDeCandidatos->obtenerCursor();

		if(nodoDeAlgunVertice->obtenerVertice() == unVertice){

			nodoDelVertice = nodoDeAlgunVertice;
		}

	}
	return nodoDelVertice;

}



bool Dijkstra::esUnMejorCamino(double pesoDeUnVerticeDesdeElOrigen,
							   double pesoDeOtroVerticeDesdeElOrigen,
							   double pesoDeUnVerticeDesdeOtroVertice){


	if(this->esUnPesoMenor(pesoDeUnVerticeDesdeElOrigen, pesoDeOtroVerticeDesdeElOrigen)){

		double pesoDelDesvio = pesoDeOtroVerticeDesdeElOrigen + pesoDeUnVerticeDesdeOtroVertice;

		return (this->esUnPesoMenor(pesoDeUnVerticeDesdeElOrigen, pesoDelDesvio));

	}

	return false;
}

void Dijkstra::mejorarCamino(NodoDeCandidatos * adyacenteAlCandidato, double pesoMenor, Vertice * nuevoPredecesor){

	adyacenteAlCandidato->cambiarPeso(pesoMenor);
	adyacenteAlCandidato->cambiarPredecesor(nuevoPredecesor);

}




void Dijkstra::inicializarListasDeCandidatos(Vertice * origen){


	Lista<NodoDeAdyacencia *> * listaDeAdyacencia = this->grafo->obtenerListaDeAdyacencia();

	listaDeAdyacencia->iniciarCursor();
	while(listaDeAdyacencia->avanzarCursor()){

		NodoDeAdyacencia * nodoDeAdyacencia = listaDeAdyacencia->obtenerCursor();
		Vertice * vertice = nodoDeAdyacencia->obtenerVertice();

		if(vertice != origen){

			NodoDeCandidatos * nuevoCandidato = new NodoDeCandidatos(vertice, PESO_INFINITO, NULL);
			this->listaDeCandidatos->agregar(nuevoCandidato);

		}
	}

	this->inicializarCosteDeVerticesAdyacentesAl(origen);

}

void Dijkstra::inicializarCosteDeVerticesAdyacentesAl(Vertice * origen){



	Lista<NodoArista* > * adyacentes = this->grafo->obtenerAdyacentes(origen);

	this->listaDeCandidatos->iniciarCursor();
	while(this->listaDeCandidatos->avanzarCursor()){

		NodoDeCandidatos * candidato = this->listaDeCandidatos->obtenerCursor();
		Vertice * vertice = candidato->obtenerVertice();

		adyacentes->iniciarCursor();
		while(adyacentes->avanzarCursor()){

			NodoArista* arista = adyacentes->obtenerCursor();

			Vertice * verticeAdyacente = arista->obtenerVertice();

			if(vertice == verticeAdyacente){

				candidato->cambiarPeso(arista->obtenerPeso());
				candidato->cambiarPredecesor(origen);

			}

		}
	}
}

Dijkstra::~Dijkstra() {


	delete this->rutaMinima;
	this->listaDeCandidatos->iniciarCursor();
	while(this->listaDeCandidatos->avanzarCursor()){

		delete this->listaDeCandidatos->obtenerCursor();
	}
	delete this->listaDeCandidatos;

}

