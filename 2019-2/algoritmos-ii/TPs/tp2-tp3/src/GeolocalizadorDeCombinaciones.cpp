#include "GeolocalizadorDeCombinaciones.h"




GeolocalizadorDeCombinaciones::GeolocalizadorDeCombinaciones(PuntosDeTrasbordo* puntosDeTrasbordo,
															 double xFinal, double yFinal,
															 double xInicial, double yInicial, double radioCuadrado){

	this-> xFinal = xFinal;
	this-> yFinal = yFinal;
	this-> xInicial = xInicial;
	this-> yInicial = yInicial;
	this-> radioCuadrado = radioCuadrado;
	this-> todosLosTransportes = filtrarPuntosDeTrasbordoEnUnaRegionDelMapa(puntosDeTrasbordo, xInicial, yInicial, xFinal, yFinal);
	this-> transportesEnElOrigen = filtrarTransportesEnElOrigen();
	this-> transportesEnElDestino = filtrarTransportesEnElDestino();
	this-> calculador = new CalculadorDePeso(TARIFA_DE_SUBTE, TARIFA_DE_TREN, TARIFA_DE_COLECTIVO);

	Vertice * origen = new Vertice(xInicial, yInicial);
	Vertice * destino = new Vertice(xFinal, yFinal);
	this-> grafo = new GrafoDeRutas(origen, destino);

	agregarRutasDirectas();
	agregarCombinaciones();
}




PuntosDeTrasbordo* GeolocalizadorDeCombinaciones::filtrarPuntosDeTrasbordoEnUnaRegionDelMapa(PuntosDeTrasbordo* puntosDeTrasbordo,
																							 double xInicial, double yInicial,
																							 double xFinal, double yFinal){

	double menorLongitud = obtenerMenor(xInicial, xFinal);
	double mayorLongitud = obtenerMayor(xInicial, xFinal);

	double menorLatitud = obtenerMenor(yInicial, yFinal);
	double mayorLatitud = obtenerMayor(yInicial, yFinal);

	//Le doy un rango de movimiento al usuario por fuera de la region.
	menorLongitud -= this -> radioCuadrado;
	menorLatitud -= this -> radioCuadrado;
	mayorLongitud += this -> radioCuadrado;
	mayorLatitud += this -> radioCuadrado;

	Lista<BocaDeSubte*>* bocasDeSubte = puntosDeTrasbordo -> obtenerBocasDeSubtes();
	Lista<EstacionDeTren*>* estacionesDeTren = puntosDeTrasbordo -> obtenerEstacionesDeTrenes();
	Lista<ParadaDeColectivo*>* paradasDeColectivo = puntosDeTrasbordo -> obtenerParadasDeColectivos();

	PuntosDeTrasbordo* puntosDeTrasbordoFiltrados = new PuntosDeTrasbordo;

	filtrarBocasDeSubteEnUnaRegionDelMapa(bocasDeSubte, puntosDeTrasbordoFiltrados, menorLongitud, mayorLongitud, menorLatitud, mayorLatitud);
	filtrarEstacionesDeTrenEnUnaRegionDelMapa(estacionesDeTren, puntosDeTrasbordoFiltrados, menorLongitud, mayorLongitud, menorLatitud, mayorLatitud);
	filtrarParadasDeColectivoEnUnaRegionDelMapa(paradasDeColectivo, puntosDeTrasbordoFiltrados, menorLongitud, mayorLongitud, menorLatitud, mayorLatitud);

	return puntosDeTrasbordoFiltrados;

}



double GeolocalizadorDeCombinaciones::obtenerMenor(double primerElemento, double segundoElemento){

	if (primerElemento < segundoElemento){

		return primerElemento;

	}

	return segundoElemento;

}


double GeolocalizadorDeCombinaciones::obtenerMayor(double primerElemento, double segundoElemento){

	if (primerElemento >= segundoElemento){

		return primerElemento;

	}

	return segundoElemento;

}




void GeolocalizadorDeCombinaciones::filtrarBocasDeSubteEnUnaRegionDelMapa(Lista<BocaDeSubte*>* bocasDeSubte,
																		  PuntosDeTrasbordo* puntosDeTrasbordo,
																		  double menorLongitud, double mayorLongitud,
																		  double menorLatitud, double mayorLatitud){

	bocasDeSubte -> iniciarCursor();

	while (bocasDeSubte -> avanzarCursor()){

		BocaDeSubte* bocaDeSubte = bocasDeSubte -> obtenerCursor();

		if (estaEnLaRegionDelMapa(bocaDeSubte, menorLongitud, mayorLongitud, menorLatitud, mayorLatitud)){

			puntosDeTrasbordo -> agregarBocaDeSubte(bocaDeSubte);

		}

	}

}


void GeolocalizadorDeCombinaciones::filtrarEstacionesDeTrenEnUnaRegionDelMapa(Lista<EstacionDeTren*>* estacionesDeTren,
																			  PuntosDeTrasbordo* puntosDeTrasbordo,
																			  double menorLongitud, double mayorLongitud,
																			  double menorLatitud, double mayorLatitud){

	estacionesDeTren -> iniciarCursor();

	while (estacionesDeTren -> avanzarCursor()){

		EstacionDeTren* estacionDeTren = estacionesDeTren -> obtenerCursor();

		if (estaEnLaRegionDelMapa(estacionDeTren, menorLongitud, mayorLongitud, menorLatitud, mayorLatitud)){

			puntosDeTrasbordo -> agregarEstacionDeTren(estacionDeTren);

		}

	}

}



void GeolocalizadorDeCombinaciones::filtrarParadasDeColectivoEnUnaRegionDelMapa(Lista<ParadaDeColectivo*>* paradasDeColectivo,
																				PuntosDeTrasbordo* puntosDeTrasbordo,
																				double menorLongitud, double mayorLongitud,
																				double menorLatitud, double mayorLatitud){

	paradasDeColectivo -> iniciarCursor();

	while (paradasDeColectivo -> avanzarCursor()){

		ParadaDeColectivo* paradaDeColectivo = paradasDeColectivo -> obtenerCursor();

		if (estaEnLaRegionDelMapa(paradaDeColectivo, menorLongitud, mayorLongitud, menorLatitud, mayorLatitud)){

			puntosDeTrasbordo -> agregarParadaDeColectivo(paradaDeColectivo);

		}

	}

}




PuntosDeTrasbordo* GeolocalizadorDeCombinaciones::filtrarTransportesEnElOrigen(){

	PuntosDeTrasbordo* transportesEnElOrigen = new PuntosDeTrasbordo;

	filtrarSubtesEnElOrigen(transportesEnElOrigen);
	filtrarTrenesEnElOrigen(transportesEnElOrigen);
	filtrarColectivosEnElOrigen(transportesEnElOrigen);
	return transportesEnElOrigen;

}


void GeolocalizadorDeCombinaciones::filtrarSubtesEnElOrigen(PuntosDeTrasbordo* transportesEnElOrigen){


	Lista<BocaDeSubte*>* subtesTotal;
	BocaDeSubte* subteTotal;
	subtesTotal = this->todosLosTransportes->obtenerBocasDeSubtes();

	subtesTotal->iniciarCursor();
	while(subtesTotal->avanzarCursor()){

		subteTotal = subtesTotal->obtenerCursor();

		if((estaEnElRangoDeLongitud(subteTotal->obtenerLongitud(), xInicial)) &&
		   (estaEnElRangoDeLatitud(subteTotal->obtenerLatitud(), yInicial))){

			transportesEnElOrigen->agregarBocaDeSubte(subteTotal);
		}
	}
}

void GeolocalizadorDeCombinaciones::filtrarColectivosEnElOrigen(PuntosDeTrasbordo* transportesEnElOrigen){


	Lista<ParadaDeColectivo*>* colectivosTotal;
	ParadaDeColectivo* colectivoTotal;
	colectivosTotal = this->todosLosTransportes->obtenerParadasDeColectivos();

	colectivosTotal->iniciarCursor();
	while(colectivosTotal->avanzarCursor()){

		colectivoTotal = colectivosTotal->obtenerCursor();

		if((estaEnElRangoDeLongitud(colectivoTotal->obtenerLongitud(), xInicial)) &&
		   (estaEnElRangoDeLatitud(colectivoTotal->obtenerLatitud(), yInicial))){

			transportesEnElOrigen->agregarParadaDeColectivo(colectivoTotal);
		}
	}
}


void GeolocalizadorDeCombinaciones::filtrarTrenesEnElOrigen(PuntosDeTrasbordo* transportesEnElOrigen){


	Lista<EstacionDeTren*>* trenesTotal;
	EstacionDeTren* trenTotal;
	trenesTotal = this->todosLosTransportes->obtenerEstacionesDeTrenes();

	trenesTotal->iniciarCursor();
	while(trenesTotal->avanzarCursor()){

		trenTotal = trenesTotal->obtenerCursor();

		if((estaEnElRangoDeLongitud(trenTotal->obtenerLongitud(), xInicial)) &&
		   (estaEnElRangoDeLatitud(trenTotal->obtenerLatitud(), yInicial))){

			transportesEnElOrigen->agregarEstacionDeTren(trenTotal);
		}
	}
}



PuntosDeTrasbordo* GeolocalizadorDeCombinaciones::filtrarTransportesEnElDestino(){

	PuntosDeTrasbordo* transportesEnElFinal = new PuntosDeTrasbordo;

	filtrarSubtesEnElFinal(transportesEnElFinal);
	filtrarTrenesEnElFinal(transportesEnElFinal);
	filtrarColectivosEnElFinal(transportesEnElFinal);
	return transportesEnElFinal;
}



void GeolocalizadorDeCombinaciones::filtrarColectivosEnElFinal(PuntosDeTrasbordo* transportesEnElFinal){


	Lista<ParadaDeColectivo*>* colectivosTotal;
	ParadaDeColectivo* colectivoTotal;
	colectivosTotal = this->todosLosTransportes->obtenerParadasDeColectivos();

	colectivosTotal->iniciarCursor();
	while(colectivosTotal->avanzarCursor()){

		colectivoTotal = colectivosTotal->obtenerCursor();

		if((estaEnElRangoDeLongitud(colectivoTotal->obtenerLongitud(), xFinal)) &&
		   (estaEnElRangoDeLatitud(colectivoTotal->obtenerLatitud(), yFinal))){

			transportesEnElFinal->agregarParadaDeColectivo(colectivoTotal);
		}
	}
}


void GeolocalizadorDeCombinaciones::filtrarSubtesEnElFinal(PuntosDeTrasbordo* transportesEnElFinal){


	Lista<BocaDeSubte*>* subtesTotal;
	BocaDeSubte* subteTotal;
	subtesTotal = this->todosLosTransportes->obtenerBocasDeSubtes();

	subtesTotal->iniciarCursor();
	while(subtesTotal->avanzarCursor()){

		subteTotal = subtesTotal->obtenerCursor();

		if((estaEnElRangoDeLongitud(subteTotal->obtenerLongitud(), xFinal)) &&
		   (estaEnElRangoDeLatitud(subteTotal->obtenerLatitud(), yFinal))){

			transportesEnElFinal->agregarBocaDeSubte(subteTotal);
		}
	}
}



void GeolocalizadorDeCombinaciones::filtrarTrenesEnElFinal(PuntosDeTrasbordo* transportesEnElFinal){


	Lista<EstacionDeTren*>* trenesTotal;
	EstacionDeTren* trenTotal;
	trenesTotal = this->todosLosTransportes->obtenerEstacionesDeTrenes();

	trenesTotal->iniciarCursor();
	while(trenesTotal->avanzarCursor()){

		trenTotal = trenesTotal->obtenerCursor();

		if((estaEnElRangoDeLongitud(trenTotal->obtenerLongitud(), xFinal)) &&
		   (estaEnElRangoDeLatitud(trenTotal->obtenerLatitud(), yFinal))){

			transportesEnElFinal->agregarEstacionDeTren(trenTotal);
		}
	}
}


void GeolocalizadorDeCombinaciones::agregarCombinaciones(){

	actualizarCombinacionesDeSubtesConSubtes();
	actualizarCombinacionesDeSubtesConColectivos();
	actualizarCombinacionesDeSubtesConTrenes();
	actualizarCombinacionesDeColectivosConTrenes();
	actualizarCombinacionesDeColectivosConSubtes();
	actualizarCombinacionesDeColectivosConColectivos();
	actualizarCombinacionesDeTrenesConTrenes();
	actualizarCombinacionesDeTrenesConSubtes();
	actualizarCombinacionesDeTrenesConColectivos();


}



void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeTrenesConTrenes(){


	Lista<EstacionDeTren*>* trenesEnElDestino = transportesEnElDestino->obtenerEstacionesDeTrenes();
	Lista<EstacionDeTren*>* estacionesDeTren = todosLosTransportes->obtenerEstacionesDeTrenes();
	Lista<EstacionDeTren*>* trenesEnElOrigen = transportesEnElOrigen->obtenerEstacionesDeTrenes();

	Lista<EstacionDeTren*> trenesDeLaMismaLineaAlDelOrigen;

	EstacionDeTren* trenCercanoAlDestino;
	EstacionDeTren* estacionDeTrenAleatoria;
	EstacionDeTren* trenCercanoAlOrigen;
	EstacionDeTren* trenDeLaMismaLinea;

	trenesEnElOrigen -> iniciarCursor();

	while (trenesEnElOrigen -> avanzarCursor()){

		trenCercanoAlOrigen = trenesEnElOrigen -> obtenerCursor();

		trenesDeLaMismaLineaAlDelOrigen.vaciar();

		filtrarPuntosDeTrasbordoDeLaMismaLineaALaCercanaAlOrigen(trenCercanoAlOrigen, estacionesDeTren, trenesDeLaMismaLineaAlDelOrigen);

		trenesDeLaMismaLineaAlDelOrigen.iniciarCursor();

		while (trenesDeLaMismaLineaAlDelOrigen.avanzarCursor()){

			trenDeLaMismaLinea = trenesDeLaMismaLineaAlDelOrigen.obtenerCursor();

			estacionesDeTren -> iniciarCursor();

			while (estacionesDeTren -> avanzarCursor()){

				estacionDeTrenAleatoria = estacionesDeTren -> obtenerCursor();

				if ((estaEnElRangoDeLongitud(trenDeLaMismaLinea -> obtenerLongitud(), estacionDeTrenAleatoria -> obtenerLongitud())) &&
					(estaEnElRangoDeLatitud(trenDeLaMismaLinea -> obtenerLatitud(), estacionDeTrenAleatoria -> obtenerLatitud()))){

					EstacionDeTren* posibleCombinacion = estacionDeTrenAleatoria;

					trenesEnElDestino -> iniciarCursor();

					while (trenesEnElDestino -> avanzarCursor()){

						trenCercanoAlDestino = trenesEnElDestino -> obtenerCursor();

						if (sonPuntosDeTrasbordoDeLaMismaLinea(posibleCombinacion, trenCercanoAlDestino) &&
							trenCercanoAlOrigen !=  trenDeLaMismaLinea &&  trenDeLaMismaLinea != posibleCombinacion && posibleCombinacion != trenCercanoAlDestino){


							this->agregarViajeEnTrenAlGrafo(trenCercanoAlOrigen, trenDeLaMismaLinea);
							this->agregarViajeEnTrenAlGrafo(posibleCombinacion, trenCercanoAlDestino);

							Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(trenCercanoAlOrigen->obtenerLongitud(), trenCercanoAlOrigen->obtenerLatitud());
							Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(trenDeLaMismaLinea->obtenerLongitud(), trenDeLaMismaLinea->obtenerLatitud());
							Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
							Vertice * paradaEnElDestino = this->grafo->obtenerVertice(trenCercanoAlDestino->obtenerLongitud(), trenCercanoAlDestino->obtenerLatitud());

							this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
							this->agregarAristaConElOrigen(paradaEnElOrigen);
							this->agregarAristaConElDestino(paradaEnElDestino);

						}
					}
				}
			}
		}
	}
}


void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeTrenesConSubtes(){

	Lista<EstacionDeTren*>* trenesEnElOrigen = transportesEnElOrigen->obtenerEstacionesDeTrenes();
	Lista<EstacionDeTren*>* estacionesDeTren = todosLosTransportes->obtenerEstacionesDeTrenes();
	Lista<BocaDeSubte*>* bocasDeSubte = todosLosTransportes->obtenerBocasDeSubtes();
	Lista<BocaDeSubte*>* subtesEnElDestino = transportesEnElDestino->obtenerBocasDeSubtes();

	EstacionDeTren* trenCercanoAlOrigen;
	EstacionDeTren* estacionDeTrenAleatoria;
	BocaDeSubte* bocaDeSubteAleatoria;
	BocaDeSubte* subteCercanoAlDestino;

	trenesEnElOrigen -> iniciarCursor();

	while (trenesEnElOrigen -> avanzarCursor()){

		trenCercanoAlOrigen = trenesEnElOrigen -> obtenerCursor();

		estacionesDeTren -> iniciarCursor();

		while (estacionesDeTren -> avanzarCursor()){

			estacionDeTrenAleatoria = estacionesDeTren -> obtenerCursor();

			if (sonPuntosDeTrasbordoDeLaMismaLinea(trenCercanoAlOrigen, estacionDeTrenAleatoria)){

				bocasDeSubte -> iniciarCursor();

				while (bocasDeSubte -> avanzarCursor()){

					bocaDeSubteAleatoria = bocasDeSubte -> obtenerCursor();

					if ((estaEnElRangoDeLongitud(estacionDeTrenAleatoria -> obtenerLongitud(), bocaDeSubteAleatoria -> obtenerLongitud())) &&
						(estaEnElRangoDeLatitud(estacionDeTrenAleatoria -> obtenerLatitud(), bocaDeSubteAleatoria -> obtenerLatitud()))){

						BocaDeSubte* posibleCombinacion = bocaDeSubteAleatoria;

						subtesEnElDestino -> iniciarCursor();

						while (subtesEnElDestino -> avanzarCursor()){

							subteCercanoAlDestino = subtesEnElDestino -> obtenerCursor();

							if (sonPuntosDeTrasbordoDeLaMismaLinea(subteCercanoAlDestino, posibleCombinacion) &&
								trenCercanoAlOrigen !=  estacionDeTrenAleatoria && posibleCombinacion != subteCercanoAlDestino){


								this->agregarViajeEnTrenAlGrafo(trenCercanoAlOrigen, estacionDeTrenAleatoria);
								this->agregarViajeEnSubteAlGrafo(posibleCombinacion, subteCercanoAlDestino);

								Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(trenCercanoAlOrigen->obtenerLongitud(), trenCercanoAlOrigen->obtenerLatitud());
								Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(estacionDeTrenAleatoria->obtenerLongitud(), estacionDeTrenAleatoria->obtenerLatitud());
								Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
								Vertice * paradaEnElDestino = this->grafo->obtenerVertice(subteCercanoAlDestino->obtenerLongitud(), subteCercanoAlDestino->obtenerLatitud());

								this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
								this->agregarAristaConElOrigen(paradaEnElOrigen);
								this->agregarAristaConElDestino(paradaEnElDestino);


							}
						}
					}
				}
			}
		}
	}
}


void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeTrenesConColectivos(){


	Lista<EstacionDeTren*>* trenesEnElOrigen = transportesEnElOrigen->obtenerEstacionesDeTrenes();
	Lista<EstacionDeTren*>* estacionesDeTren = todosLosTransportes->obtenerEstacionesDeTrenes();
	Lista<ParadaDeColectivo*>* paradasDeColectivo = todosLosTransportes->obtenerParadasDeColectivos();
	Lista<ParadaDeColectivo*>* colectivosEnElDestino = transportesEnElDestino->obtenerParadasDeColectivos();

	EstacionDeTren* trenCercanoAlOrigen;
	EstacionDeTren* estacionDeTrenAleatoria;
	ParadaDeColectivo* paradaDeColectivoAleatoria;
	ParadaDeColectivo* colectivoCercanoAlDestino;

	trenesEnElOrigen -> iniciarCursor();

	while (trenesEnElOrigen -> avanzarCursor()){

		trenCercanoAlOrigen = trenesEnElOrigen -> obtenerCursor();

		estacionesDeTren -> iniciarCursor();

		while (estacionesDeTren -> avanzarCursor()){

			estacionDeTrenAleatoria = estacionesDeTren -> obtenerCursor();

			if (sonPuntosDeTrasbordoDeLaMismaLinea(trenCercanoAlOrigen, estacionDeTrenAleatoria)){

				paradasDeColectivo -> iniciarCursor();

				while (paradasDeColectivo -> avanzarCursor()){

					paradaDeColectivoAleatoria = paradasDeColectivo -> obtenerCursor();

					if ((estaEnElRangoDeLongitud(estacionDeTrenAleatoria -> obtenerLongitud(), paradaDeColectivoAleatoria -> obtenerLongitud())) &&
						(estaEnElRangoDeLatitud(estacionDeTrenAleatoria -> obtenerLatitud(), paradaDeColectivoAleatoria -> obtenerLatitud())) &&
						trenCercanoAlOrigen != estacionDeTrenAleatoria){

						ParadaDeColectivo* posibleCombinacion = paradaDeColectivoAleatoria;

						colectivosEnElDestino -> iniciarCursor();

						while (colectivosEnElDestino -> avanzarCursor()){

							colectivoCercanoAlDestino = colectivosEnElDestino -> obtenerCursor();

							if (sonParadasDeColectivoDeLaMismaLinea(colectivoCercanoAlDestino, posibleCombinacion) &&
							    trenCercanoAlOrigen !=  estacionDeTrenAleatoria && posibleCombinacion != colectivoCercanoAlDestino){



								this->agregarViajeEnTrenAlGrafo(trenCercanoAlOrigen, estacionDeTrenAleatoria);
								this->agregarViajeEnColectivoAlGrafo(posibleCombinacion, colectivoCercanoAlDestino);

								Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(trenCercanoAlOrigen->obtenerLongitud(), trenCercanoAlOrigen->obtenerLatitud());
								Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(estacionDeTrenAleatoria->obtenerLongitud(), estacionDeTrenAleatoria->obtenerLatitud());
								Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
								Vertice * paradaEnElDestino = this->grafo->obtenerVertice(colectivoCercanoAlDestino->obtenerLongitud(), colectivoCercanoAlDestino->obtenerLatitud());

								this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
								this->agregarAristaConElOrigen(paradaEnElOrigen);
								this->agregarAristaConElDestino(paradaEnElDestino);


							}
						}
					}
				}
			}
		}
	}
}




void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeColectivosConTrenes(){

	Lista<ParadaDeColectivo*>* colectivosEnElOrigen = transportesEnElOrigen->obtenerParadasDeColectivos();
	Lista<ParadaDeColectivo*>* paradasDeColectivo = todosLosTransportes->obtenerParadasDeColectivos();
	Lista<EstacionDeTren*>* estacionesDeTren = todosLosTransportes->obtenerEstacionesDeTrenes();
	Lista<EstacionDeTren*>* trenesEnElDestino = transportesEnElDestino->obtenerEstacionesDeTrenes();

	ParadaDeColectivo* colectivoCercanoAlOrigen;
	ParadaDeColectivo* paradaDeColectivoAleatoria;
	EstacionDeTren* estacionDeTrenAleatoria;
	EstacionDeTren* trenCercanoAlDestino;

	colectivosEnElOrigen -> iniciarCursor();

	while (colectivosEnElOrigen -> avanzarCursor()){

		colectivoCercanoAlOrigen = colectivosEnElOrigen -> obtenerCursor();

		paradasDeColectivo -> iniciarCursor();

		while (paradasDeColectivo -> avanzarCursor()){

			paradaDeColectivoAleatoria = paradasDeColectivo -> obtenerCursor();

			if (sonParadasDeColectivoDeLaMismaLinea(colectivoCercanoAlOrigen, paradaDeColectivoAleatoria)){

				estacionesDeTren -> iniciarCursor();

				while (estacionesDeTren -> avanzarCursor()){

					estacionDeTrenAleatoria = estacionesDeTren -> obtenerCursor();

					if ((estaEnElRangoDeLongitud(estacionDeTrenAleatoria -> obtenerLongitud(), paradaDeColectivoAleatoria -> obtenerLongitud())) &&
						(estaEnElRangoDeLatitud(estacionDeTrenAleatoria -> obtenerLatitud(), paradaDeColectivoAleatoria -> obtenerLatitud()))){

						EstacionDeTren* posibleCombinacion = estacionDeTrenAleatoria;

						trenesEnElDestino -> iniciarCursor();

						while (trenesEnElDestino -> avanzarCursor()){

							trenCercanoAlDestino = trenesEnElDestino -> obtenerCursor();

							if (sonPuntosDeTrasbordoDeLaMismaLinea(trenCercanoAlDestino, posibleCombinacion) &&
								colectivoCercanoAlOrigen !=  paradaDeColectivoAleatoria &&  estacionDeTrenAleatoria != posibleCombinacion && posibleCombinacion != trenCercanoAlDestino){


								this->agregarViajeEnColectivoAlGrafo(colectivoCercanoAlOrigen, paradaDeColectivoAleatoria);
								this->agregarViajeEnTrenAlGrafo(posibleCombinacion, trenCercanoAlDestino);

								Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(colectivoCercanoAlOrigen->obtenerLongitud(), colectivoCercanoAlOrigen->obtenerLatitud());
								Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(paradaDeColectivoAleatoria->obtenerLongitud(), paradaDeColectivoAleatoria->obtenerLatitud());
								Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
								Vertice * paradaEnElDestino = this->grafo->obtenerVertice(trenCercanoAlDestino->obtenerLongitud(), trenCercanoAlDestino->obtenerLatitud());

								this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
								this->agregarAristaConElOrigen(paradaEnElOrigen);
								this->agregarAristaConElDestino(paradaEnElDestino);


							}
						}
					}
				}
			}
		}
	}
}


void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeColectivosConColectivos(){

	Lista<ParadaDeColectivo*>* colectivosEnElDestino = transportesEnElDestino->obtenerParadasDeColectivos();
	Lista<ParadaDeColectivo*>* paradasDeColectivo = todosLosTransportes->obtenerParadasDeColectivos();
	Lista<ParadaDeColectivo*>* colectivosEnElOrigen = transportesEnElOrigen->obtenerParadasDeColectivos();

	Lista<ParadaDeColectivo*> colectivosDeLaMismaLineaAlDelOrigen;

	ParadaDeColectivo* colectivoCercanoAlDestino;
	ParadaDeColectivo* paradaDeColectivoAleatoria;
	ParadaDeColectivo* colectivoCercanoAlOrigen;
	ParadaDeColectivo* colectivoDeLaMismaLinea;

	colectivosEnElOrigen -> iniciarCursor();

	while (colectivosEnElOrigen -> avanzarCursor()){

		colectivoCercanoAlOrigen = colectivosEnElOrigen -> obtenerCursor();

		colectivosDeLaMismaLineaAlDelOrigen.vaciar();

		filtrarParadasDeColectivoDeLaMismaLineaALaCercanaAlOrigen(colectivoCercanoAlOrigen, paradasDeColectivo, colectivosDeLaMismaLineaAlDelOrigen);

		colectivosDeLaMismaLineaAlDelOrigen.iniciarCursor();

		while (colectivosDeLaMismaLineaAlDelOrigen.avanzarCursor()){

			colectivoDeLaMismaLinea = colectivosDeLaMismaLineaAlDelOrigen.obtenerCursor();

			paradasDeColectivo -> iniciarCursor();

			while (paradasDeColectivo -> avanzarCursor()){

				paradaDeColectivoAleatoria = paradasDeColectivo -> obtenerCursor();

				if ((estaEnElRangoDeLongitud(colectivoDeLaMismaLinea -> obtenerLongitud(), paradaDeColectivoAleatoria -> obtenerLongitud())) &&
					(estaEnElRangoDeLatitud(colectivoDeLaMismaLinea -> obtenerLatitud(), paradaDeColectivoAleatoria -> obtenerLatitud())) &&
					colectivoDeLaMismaLinea != paradaDeColectivoAleatoria){

					ParadaDeColectivo* posibleCombinacion = paradaDeColectivoAleatoria;

					colectivosEnElDestino -> iniciarCursor();

					while (colectivosEnElDestino -> avanzarCursor()){

						colectivoCercanoAlDestino = colectivosEnElDestino -> obtenerCursor();

						if (sonParadasDeColectivoDeLaMismaLinea(posibleCombinacion, colectivoCercanoAlDestino) &&
							colectivoCercanoAlOrigen !=  colectivoDeLaMismaLinea &&  colectivoDeLaMismaLinea != posibleCombinacion && posibleCombinacion != colectivoCercanoAlDestino){

							this->agregarViajeEnColectivoAlGrafo(colectivoCercanoAlOrigen, colectivoDeLaMismaLinea);
							this->agregarViajeEnColectivoAlGrafo(posibleCombinacion, colectivoCercanoAlDestino);

							Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(colectivoCercanoAlOrigen->obtenerLongitud(), colectivoCercanoAlOrigen->obtenerLatitud());
							Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(colectivoDeLaMismaLinea->obtenerLongitud(), colectivoDeLaMismaLinea->obtenerLatitud());
							Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
							Vertice * paradaEnElDestino = this->grafo->obtenerVertice(colectivoCercanoAlDestino->obtenerLongitud(), colectivoCercanoAlDestino->obtenerLatitud());

							this->agregarAristaConElOrigen(paradaEnElOrigen);
							this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
							this->agregarAristaConElDestino(paradaEnElDestino);

						}
					}
				}
			}
		}
	}
}


void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeColectivosConSubtes(){

	Lista<ParadaDeColectivo*>* colectivosEnElOrigen = transportesEnElOrigen->obtenerParadasDeColectivos();
	Lista<ParadaDeColectivo*>* paradasDeColectivo = todosLosTransportes->obtenerParadasDeColectivos();
	Lista<BocaDeSubte*>* bocasDeSubte = todosLosTransportes->obtenerBocasDeSubtes();
	Lista<BocaDeSubte*>* subtesEnElDestino = transportesEnElDestino->obtenerBocasDeSubtes();

	ParadaDeColectivo* colectivoCercanoAlOrigen;
	ParadaDeColectivo* paradaDeColectivoAleatoria;
	BocaDeSubte* bocaDeSubteAleatoria;
	BocaDeSubte* subteCercanoAlDestino;

	colectivosEnElOrigen -> iniciarCursor();

	while (colectivosEnElOrigen -> avanzarCursor()){

		colectivoCercanoAlOrigen = colectivosEnElOrigen -> obtenerCursor();

		paradasDeColectivo -> iniciarCursor();

		while (paradasDeColectivo -> avanzarCursor()){

			paradaDeColectivoAleatoria = paradasDeColectivo -> obtenerCursor();

			if (sonParadasDeColectivoDeLaMismaLinea(colectivoCercanoAlOrigen, paradaDeColectivoAleatoria)){

				bocasDeSubte -> iniciarCursor();

				while (bocasDeSubte -> avanzarCursor()){

					bocaDeSubteAleatoria = bocasDeSubte -> obtenerCursor();

					if ((estaEnElRangoDeLongitud(paradaDeColectivoAleatoria -> obtenerLongitud(), bocaDeSubteAleatoria -> obtenerLongitud())) &&
						(estaEnElRangoDeLatitud(paradaDeColectivoAleatoria -> obtenerLatitud(), bocaDeSubteAleatoria -> obtenerLatitud()))){

						BocaDeSubte* posibleCombinacion = bocaDeSubteAleatoria;

						subtesEnElDestino -> iniciarCursor();

						while (subtesEnElDestino -> avanzarCursor()){

							subteCercanoAlDestino = subtesEnElDestino -> obtenerCursor();

							if (sonPuntosDeTrasbordoDeLaMismaLinea(subteCercanoAlDestino, posibleCombinacion) &&
								colectivoCercanoAlOrigen !=  paradaDeColectivoAleatoria  && posibleCombinacion != subteCercanoAlDestino){

								this->agregarViajeEnColectivoAlGrafo(colectivoCercanoAlOrigen, paradaDeColectivoAleatoria);
								this->agregarViajeEnSubteAlGrafo(posibleCombinacion, subteCercanoAlDestino);

								Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(colectivoCercanoAlOrigen->obtenerLongitud(), colectivoCercanoAlOrigen->obtenerLatitud());
								Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(paradaDeColectivoAleatoria->obtenerLongitud(), paradaDeColectivoAleatoria->obtenerLatitud());
								Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
								Vertice * paradaEnElDestino = this->grafo->obtenerVertice(subteCercanoAlDestino->obtenerLongitud(), subteCercanoAlDestino->obtenerLatitud());

								this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
								this->agregarAristaConElOrigen(paradaEnElOrigen);
								this->agregarAristaConElDestino(paradaEnElDestino);


							}
						}
					}
				}
			}
		}
	}
}




void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeSubtesConColectivos(){

	Lista<BocaDeSubte*>* subtesEnElOrigen = transportesEnElOrigen->obtenerBocasDeSubtes();
	Lista<BocaDeSubte*>* bocasDeSubte = todosLosTransportes->obtenerBocasDeSubtes();
	Lista<ParadaDeColectivo*>* paradasDeColectivo = todosLosTransportes->obtenerParadasDeColectivos();
	Lista<ParadaDeColectivo*>* colectivosEnElDestino = transportesEnElDestino->obtenerParadasDeColectivos();

	BocaDeSubte* subteCercanoAlOrigen;
	BocaDeSubte* bocaDeSubteAleatoria;
	ParadaDeColectivo* paradaDeColectivoAleatoria;
	ParadaDeColectivo* colectivoCercanoAlDestino;

	subtesEnElOrigen -> iniciarCursor();

	while (subtesEnElOrigen -> avanzarCursor()){

		subteCercanoAlOrigen = subtesEnElOrigen -> obtenerCursor();

		bocasDeSubte -> iniciarCursor();

		while (bocasDeSubte -> avanzarCursor()){

			bocaDeSubteAleatoria = bocasDeSubte -> obtenerCursor();

			if (sonPuntosDeTrasbordoDeLaMismaLinea(subteCercanoAlOrigen, bocaDeSubteAleatoria)){

				paradasDeColectivo -> iniciarCursor();

				while (paradasDeColectivo -> avanzarCursor()){

					paradaDeColectivoAleatoria = paradasDeColectivo -> obtenerCursor();

					if ((estaEnElRangoDeLongitud(bocaDeSubteAleatoria -> obtenerLongitud(), paradaDeColectivoAleatoria -> obtenerLongitud())) &&
						(estaEnElRangoDeLatitud(bocaDeSubteAleatoria -> obtenerLatitud(), paradaDeColectivoAleatoria -> obtenerLatitud()))){

						ParadaDeColectivo* posibleCombinacion = paradaDeColectivoAleatoria;

						colectivosEnElDestino -> iniciarCursor();

						while (colectivosEnElDestino -> avanzarCursor()){

							colectivoCercanoAlDestino = colectivosEnElDestino -> obtenerCursor();

							if (sonParadasDeColectivoDeLaMismaLinea(colectivoCercanoAlDestino, posibleCombinacion) &&
								subteCercanoAlOrigen !=  bocaDeSubteAleatoria && posibleCombinacion != colectivoCercanoAlDestino){


								this->agregarViajeEnSubteAlGrafo(subteCercanoAlOrigen, bocaDeSubteAleatoria);
								this->agregarViajeEnColectivoAlGrafo(posibleCombinacion, colectivoCercanoAlDestino);

								Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(subteCercanoAlOrigen->obtenerLongitud(), subteCercanoAlOrigen->obtenerLatitud());
								Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(bocaDeSubteAleatoria->obtenerLongitud(), bocaDeSubteAleatoria->obtenerLatitud());
								Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
								Vertice * paradaEnElDestino = this->grafo->obtenerVertice(colectivoCercanoAlDestino->obtenerLongitud(), colectivoCercanoAlDestino->obtenerLatitud());

								this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
								this->agregarAristaConElOrigen(paradaEnElOrigen);
								this->agregarAristaConElDestino(paradaEnElDestino);


							}
						}
					}
				}
			}
		}
	}
}


void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeSubtesConTrenes(){

	Lista<BocaDeSubte*>* subtesEnElOrigen = transportesEnElOrigen->obtenerBocasDeSubtes();
	Lista<BocaDeSubte*>* bocasDeSubte = todosLosTransportes->obtenerBocasDeSubtes();
	Lista<EstacionDeTren*>* estacionesDeTren = todosLosTransportes->obtenerEstacionesDeTrenes();
	Lista<EstacionDeTren*>* trenesEnElDestino = transportesEnElDestino->obtenerEstacionesDeTrenes();

	BocaDeSubte* subteCercanoAlOrigen;
	BocaDeSubte* bocaDeSubteAleatoria;
	EstacionDeTren* estacionDeTrenAleatoria;
	EstacionDeTren* trenCercanoAlDestino;

	subtesEnElOrigen -> iniciarCursor();

	while (subtesEnElOrigen -> avanzarCursor()){

		subteCercanoAlOrigen = subtesEnElOrigen -> obtenerCursor();

		bocasDeSubte -> iniciarCursor();

		while (bocasDeSubte -> avanzarCursor()){

			bocaDeSubteAleatoria = bocasDeSubte -> obtenerCursor();

			if (sonPuntosDeTrasbordoDeLaMismaLinea(subteCercanoAlOrigen, bocaDeSubteAleatoria)){

				estacionesDeTren -> iniciarCursor();

				while (estacionesDeTren -> avanzarCursor()){

					estacionDeTrenAleatoria = estacionesDeTren -> obtenerCursor();

					if ((estaEnElRangoDeLongitud(estacionDeTrenAleatoria -> obtenerLongitud(), bocaDeSubteAleatoria -> obtenerLongitud())) &&
						(estaEnElRangoDeLatitud(estacionDeTrenAleatoria -> obtenerLatitud(), bocaDeSubteAleatoria -> obtenerLatitud()))){

						EstacionDeTren* posibleCombinacion = estacionDeTrenAleatoria;

						trenesEnElDestino -> iniciarCursor();

						while (trenesEnElDestino -> avanzarCursor()){

							trenCercanoAlDestino = trenesEnElDestino -> obtenerCursor();

							if (sonPuntosDeTrasbordoDeLaMismaLinea(trenCercanoAlDestino, posibleCombinacion) &&
								subteCercanoAlOrigen !=  bocaDeSubteAleatoria && posibleCombinacion != trenCercanoAlDestino){


								this->agregarViajeEnSubteAlGrafo(subteCercanoAlOrigen, bocaDeSubteAleatoria);
								this->agregarViajeEnTrenAlGrafo(posibleCombinacion, trenCercanoAlDestino);

								Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(subteCercanoAlOrigen->obtenerLongitud(), subteCercanoAlOrigen->obtenerLatitud());
								Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(bocaDeSubteAleatoria->obtenerLongitud(), bocaDeSubteAleatoria->obtenerLatitud());
								Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
								Vertice * paradaEnElDestino = this->grafo->obtenerVertice(trenCercanoAlDestino->obtenerLongitud(), trenCercanoAlDestino->obtenerLatitud());

								this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
								this->agregarAristaConElOrigen(paradaEnElOrigen);
								this->agregarAristaConElDestino(paradaEnElDestino);


							}
						}
					}
				}
			}
		}
	}
}


void GeolocalizadorDeCombinaciones::actualizarCombinacionesDeSubtesConSubtes(){

	Lista<BocaDeSubte*>* subtesEnElDestino = transportesEnElDestino->obtenerBocasDeSubtes();
	Lista<BocaDeSubte*>* bocasDeSubte = todosLosTransportes->obtenerBocasDeSubtes();
	Lista<BocaDeSubte*>* SubtesEnElOrigen = transportesEnElOrigen->obtenerBocasDeSubtes();

	Lista<BocaDeSubte*> subtesDeLaMismaLineaDelOrigen;

	BocaDeSubte* subteCercanoAlDestino;
	BocaDeSubte* bocaDeSubteAleatoria;
	BocaDeSubte* subteCercanoAlOrigen;
	BocaDeSubte* subteDeLaMismaLinea;

	SubtesEnElOrigen -> iniciarCursor();

	while (SubtesEnElOrigen -> avanzarCursor()){

		subteCercanoAlOrigen = SubtesEnElOrigen -> obtenerCursor();

		subtesDeLaMismaLineaDelOrigen.vaciar();

		filtrarPuntosDeTrasbordoDeLaMismaLineaALaCercanaAlOrigen(subteCercanoAlOrigen, bocasDeSubte, subtesDeLaMismaLineaDelOrigen);

		subtesDeLaMismaLineaDelOrigen.iniciarCursor();

		while (subtesDeLaMismaLineaDelOrigen.avanzarCursor()){

			subteDeLaMismaLinea = subtesDeLaMismaLineaDelOrigen.obtenerCursor();

			bocasDeSubte -> iniciarCursor();

			while (bocasDeSubte -> avanzarCursor()){

				bocaDeSubteAleatoria = bocasDeSubte -> obtenerCursor();

				if ((estaEnElRangoDeLongitud(subteDeLaMismaLinea -> obtenerLongitud(), bocaDeSubteAleatoria -> obtenerLongitud())) &&
					(estaEnElRangoDeLatitud(subteDeLaMismaLinea -> obtenerLatitud(), bocaDeSubteAleatoria -> obtenerLatitud())) &&
					subteDeLaMismaLinea != bocaDeSubteAleatoria){

					BocaDeSubte* posibleCombinacion = bocaDeSubteAleatoria;

					subtesEnElDestino -> iniciarCursor();

					while (subtesEnElDestino -> avanzarCursor()){

						subteCercanoAlDestino = subtesEnElDestino -> obtenerCursor();

						if (sonPuntosDeTrasbordoDeLaMismaLinea(posibleCombinacion, subteCercanoAlDestino) &&
								subteCercanoAlOrigen !=  subteDeLaMismaLinea &&  subteCercanoAlDestino != posibleCombinacion && posibleCombinacion != subteCercanoAlDestino){



							this->agregarViajeEnSubteAlGrafo(subteCercanoAlOrigen, subteDeLaMismaLinea);
							this->agregarViajeEnSubteAlGrafo(posibleCombinacion, subteCercanoAlDestino);

							Vertice * paradaEnElOrigen = this->grafo->obtenerVertice(subteCercanoAlOrigen->obtenerLongitud(), subteCercanoAlOrigen->obtenerLatitud());
							Vertice * paradaIntermediaInicial = this->grafo->obtenerVertice(subteDeLaMismaLinea->obtenerLongitud(), subteDeLaMismaLinea->obtenerLatitud());
							Vertice * paradaIntermediaFinal = this->grafo->obtenerVertice(posibleCombinacion->obtenerLongitud(), posibleCombinacion->obtenerLatitud());
							Vertice * paradaEnElDestino = this->grafo->obtenerVertice(subteCercanoAlDestino->obtenerLongitud(), subteCercanoAlDestino->obtenerLatitud());

							this->grafo->agregarArista(paradaIntermediaInicial,paradaIntermediaFinal, TARIFA_POR_COMBINACION);
							this->agregarAristaConElOrigen(paradaEnElOrigen);
							this->agregarAristaConElDestino(paradaEnElDestino);

						}
					}
				}
			}
		}
	}
}




void GeolocalizadorDeCombinaciones::agregarRutasDirectas(){


	actualizarParadasDeColectivoEnRutasDirectas();

	actualizarBocasDeSubteEnRutasDirectas();

	actualizarEstacionesDeTrenEnRutasDirectas();


}



void GeolocalizadorDeCombinaciones::actualizarParadasDeColectivoEnRutasDirectas(){


	Lista<ParadaDeColectivo*> * colectivosCercanosAlOrigen = this->transportesEnElOrigen->obtenerParadasDeColectivos();
	Lista<ParadaDeColectivo*> * colectivosCercanosAlDestino = this->transportesEnElDestino->obtenerParadasDeColectivos();


	colectivosCercanosAlOrigen->iniciarCursor();
	while (colectivosCercanosAlOrigen->avanzarCursor()){

		ParadaDeColectivo* colectivoEnElOrigen = colectivosCercanosAlOrigen->obtenerCursor();

		colectivosCercanosAlDestino->iniciarCursor();
		while (colectivosCercanosAlDestino->avanzarCursor()){

			ParadaDeColectivo* colectivoEnElDestino = colectivosCercanosAlDestino->obtenerCursor();

			if (sonParadasDeColectivoDeLaMismaLinea(colectivoEnElOrigen, colectivoEnElDestino) &&
					colectivoEnElOrigen != 	colectivoEnElDestino){

				this->agregarViajeEnColectivoAlGrafo(colectivoEnElOrigen, colectivoEnElDestino);

				Vertice * subidaDelColectivo = this->grafo->obtenerVertice(colectivoEnElOrigen->obtenerLongitud(), colectivoEnElOrigen->obtenerLatitud());
				Vertice * descensoDelColectivo = this->grafo->obtenerVertice(colectivoEnElDestino->obtenerLongitud(), colectivoEnElDestino->obtenerLatitud());

				this->agregarAristaConElOrigen(subidaDelColectivo);
				this->agregarAristaConElDestino(descensoDelColectivo);
			}
		}
	}
}

void GeolocalizadorDeCombinaciones::actualizarBocasDeSubteEnRutasDirectas(){


	Lista<BocaDeSubte * > * subtesCercanosAlOrigen = this->transportesEnElOrigen->obtenerBocasDeSubtes();
	Lista<BocaDeSubte * > * subtesCercanosAlDestino = this->transportesEnElDestino->obtenerBocasDeSubtes();


	subtesCercanosAlOrigen->iniciarCursor();
	while (subtesCercanosAlOrigen->avanzarCursor()){

		BocaDeSubte* subteEnElOrigen = subtesCercanosAlOrigen->obtenerCursor();

		subtesCercanosAlDestino->iniciarCursor();
		while (subtesCercanosAlDestino->avanzarCursor()){

			BocaDeSubte* subteEnElDestino = subtesCercanosAlDestino->obtenerCursor();

			if (sonPuntosDeTrasbordoDeLaMismaLinea(subteEnElOrigen, subteEnElDestino)){


				this->agregarViajeEnSubteAlGrafo(subteEnElOrigen, subteEnElDestino);


				Vertice * ingresoAlsubte = this->grafo->obtenerVertice(subteEnElOrigen->obtenerLongitud(), subteEnElOrigen->obtenerLatitud());
				Vertice * salidaDelSubte = this->grafo->obtenerVertice(subteEnElDestino->obtenerLongitud(), subteEnElDestino->obtenerLatitud());

				this->agregarAristaConElOrigen(ingresoAlsubte);
				this->agregarAristaConElDestino(salidaDelSubte);

			}
		}
	}
}



void GeolocalizadorDeCombinaciones::actualizarEstacionesDeTrenEnRutasDirectas(){



	Lista<EstacionDeTren*> * trenesCercanosAlOrigen = this->transportesEnElOrigen->obtenerEstacionesDeTrenes();
	Lista<EstacionDeTren*> * trenesCercanosAlDestino = this->transportesEnElDestino->obtenerEstacionesDeTrenes();


	trenesCercanosAlOrigen->iniciarCursor();
	while (trenesCercanosAlOrigen->avanzarCursor()){


		EstacionDeTren* trenEnElOrigen = trenesCercanosAlOrigen->obtenerCursor();

		trenesCercanosAlDestino->iniciarCursor();
		while (trenesCercanosAlDestino->avanzarCursor()){

			EstacionDeTren* trenEnElDestino = trenesCercanosAlDestino->obtenerCursor();

			if (sonPuntosDeTrasbordoDeLaMismaLinea(trenEnElOrigen, trenEnElDestino)){


				this->agregarViajeEnTrenAlGrafo(trenEnElOrigen, trenEnElDestino);

				Vertice * ingresoAlAnden = this->grafo->obtenerVertice(trenEnElOrigen->obtenerLongitud(), trenEnElOrigen->obtenerLatitud());
				Vertice * salidaDelAnden = this->grafo->obtenerVertice(trenEnElDestino->obtenerLongitud(), trenEnElDestino->obtenerLatitud());

				this->agregarAristaConElOrigen(ingresoAlAnden);
				this->agregarAristaConElDestino(salidaDelAnden);


			}
		}
	}
}


void GeolocalizadorDeCombinaciones::agregarViajeEnColectivoAlGrafo(ParadaDeColectivo * subidaDelColectivo,
																   ParadaDeColectivo * descensoDelColectivo){


	this->agregarParadaDeColectivoAlGrafo(subidaDelColectivo);
	this->agregarParadaDeColectivoAlGrafo(descensoDelColectivo);

	double peso = this->calculador->calcularPeso(subidaDelColectivo->obtenerLongitud(), subidaDelColectivo->obtenerLatitud(),
												 descensoDelColectivo->obtenerLongitud(),descensoDelColectivo->obtenerLatitud(),
												 PARADA_DE_COLECTIVO);

	Vertice * verticeInicial = this->grafo->obtenerVertice(subidaDelColectivo->obtenerLongitud(), subidaDelColectivo->obtenerLatitud());
	Vertice * verticeFinal = this->grafo->obtenerVertice(descensoDelColectivo->obtenerLongitud(), descensoDelColectivo->obtenerLatitud());

	this->grafo->agregarArista(verticeInicial, verticeFinal, peso);
}

void GeolocalizadorDeCombinaciones::agregarViajeEnSubteAlGrafo(BocaDeSubte * ingresoAlSubte,
															   BocaDeSubte * salidaDelSubte){


	this->agregarBocaDeSubteAlGrafo(ingresoAlSubte);
	this->agregarBocaDeSubteAlGrafo(salidaDelSubte);

	double peso = this->calculador->calcularPeso(ingresoAlSubte->obtenerLongitud(), ingresoAlSubte->obtenerLatitud(),
												 salidaDelSubte->obtenerLongitud(), salidaDelSubte->obtenerLatitud(),
												 BOCA_DE_SUBTE);

	Vertice * verticeInicial = this->grafo->obtenerVertice(ingresoAlSubte->obtenerLongitud(), ingresoAlSubte->obtenerLatitud());
	Vertice * verticeFinal = this->grafo->obtenerVertice(salidaDelSubte->obtenerLongitud(), salidaDelSubte->obtenerLatitud());

	this->grafo->agregarArista(verticeInicial, verticeFinal, peso);

}

void GeolocalizadorDeCombinaciones::agregarViajeEnTrenAlGrafo(EstacionDeTren * ingresoAlAnden,
															  EstacionDeTren *salidaDelAnden){


	this->agregarEstacionDeTrenAlGrafo(ingresoAlAnden);
	this->agregarEstacionDeTrenAlGrafo(salidaDelAnden);

	double peso = this->calculador->calcularPeso(ingresoAlAnden->obtenerLongitud(), ingresoAlAnden->obtenerLatitud(),
												 salidaDelAnden->obtenerLongitud(), salidaDelAnden->obtenerLatitud(),
												 ESTACION_DE_TREN);

	Vertice * verticeInicial = this->grafo->obtenerVertice(ingresoAlAnden->obtenerLongitud(), ingresoAlAnden->obtenerLatitud());
	Vertice * verticeFinal = this->grafo->obtenerVertice(salidaDelAnden->obtenerLongitud(), salidaDelAnden->obtenerLatitud());

	this->grafo->agregarArista(verticeInicial, verticeFinal, peso);


}


void GeolocalizadorDeCombinaciones::agregarParadaDeColectivoAlGrafo(ParadaDeColectivo * aAgregar){

	double longitud = aAgregar->obtenerLongitud();
	double latitud = aAgregar->obtenerLatitud();

	if(this->grafo->estaElVertice(longitud, latitud)){

		Vertice * vertice = this->grafo->obtenerVertice(longitud, latitud);
		vertice->agregarParadaDeColectivo(aAgregar);

	}else{

		Vertice * verticeParaAgregar = new Vertice(longitud, latitud);
		verticeParaAgregar->agregarParadaDeColectivo(aAgregar);
		this->grafo->agregarVertice(verticeParaAgregar);

	}


}


void GeolocalizadorDeCombinaciones::agregarBocaDeSubteAlGrafo(BocaDeSubte * aAgregar){

	double longitud = aAgregar->obtenerLongitud();
	double latitud = aAgregar->obtenerLatitud();


	if(this->grafo->estaElVertice(longitud, latitud)){

		Vertice * vertice = this->grafo->obtenerVertice(longitud, latitud);
		vertice->agregarBocaDeSubte(aAgregar);


	}else{

		Vertice * verticeParaAgregar = new Vertice(longitud, latitud);
		verticeParaAgregar->agregarBocaDeSubte(aAgregar);
		this->grafo->agregarVertice(verticeParaAgregar);

	}



}


void GeolocalizadorDeCombinaciones::agregarEstacionDeTrenAlGrafo(EstacionDeTren * aAgregar){


	double longitud = aAgregar->obtenerLongitud();
	double latitud = aAgregar->obtenerLatitud();

	if(this->grafo->estaElVertice(longitud, latitud)){

		Vertice * vertice = this->grafo->obtenerVertice(longitud, latitud);
		vertice->agregarEstacionDeTren(aAgregar);

	}else{

		Vertice * verticeParaAgregar = new Vertice(longitud, latitud);
		verticeParaAgregar->agregarEstacionDeTren(aAgregar);
		this->grafo->agregarVertice(verticeParaAgregar);

	}


}

void GeolocalizadorDeCombinaciones::agregarAristaConElOrigen(Vertice * unVertice){

	Vertice * origen = this->grafo->obtenerVertice(this->xInicial, this->yInicial);

	this->grafo->agregarArista(origen, unVertice, TARIFA_POR_CAMINAR);

}


void GeolocalizadorDeCombinaciones::agregarAristaConElDestino(Vertice* unVertice){

	Vertice * destino = this->grafo->obtenerVertice(this->xFinal, this->yFinal);


	this->grafo->agregarArista(unVertice,destino, TARIFA_POR_CAMINAR);


}

bool GeolocalizadorDeCombinaciones::sonParadasDeColectivoDeLaMismaLinea(ParadaDeColectivo* paradaDeColectivoOrigen,
																	  ParadaDeColectivo* paradaDeColectivoDestino){

	return (paradaDeColectivoOrigen -> obtenerLineaDeColectivo() == paradaDeColectivoDestino -> obtenerLineaDeColectivo()) &&
		   (paradaDeColectivoOrigen != paradaDeColectivoDestino);

}


bool GeolocalizadorDeCombinaciones::estaEnElRangoDeLongitud(double longitudTransporte, double longitudAComparar){

	return ((longitudAComparar - this->radioCuadrado <= longitudTransporte) &&
			(longitudAComparar + radioCuadrado >= longitudTransporte));

}


bool GeolocalizadorDeCombinaciones::estaEnElRangoDeLatitud(double latitudransporte, double latitudAComparar){

	return ((latitudAComparar - this->radioCuadrado <= latitudransporte) &&
			(latitudAComparar + radioCuadrado >= latitudransporte));

}

void GeolocalizadorDeCombinaciones::filtrarParadasDeColectivoDeLaMismaLineaALaCercanaAlOrigen(ParadaDeColectivo* paradaDeColectivoCercanaAlOrigen,
																							  Lista<ParadaDeColectivo*>* paradasDeColectivo,
																							  Lista <ParadaDeColectivo*>& paradasDeColectivoDeLaMismaLineaALaCercanaAlOrigen){

	paradasDeColectivo -> iniciarCursor();

	while (paradasDeColectivo -> avanzarCursor()){

		ParadaDeColectivo* paradaDeColectivoAleatoria = paradasDeColectivo -> obtenerCursor();

		if (sonParadasDeColectivoDeLaMismaLinea(paradaDeColectivoCercanaAlOrigen, paradaDeColectivoAleatoria)){

			paradasDeColectivoDeLaMismaLineaALaCercanaAlOrigen.agregar(paradaDeColectivoAleatoria);

		}

	}

}



PuntosDeTrasbordo* GeolocalizadorDeCombinaciones::obtenerTransportesEnElOrigen(){

	return this->transportesEnElOrigen;

}

GrafoDeRutas * GeolocalizadorDeCombinaciones::obtenerGrafo(){


	return this->grafo;

}

GeolocalizadorDeCombinaciones::~GeolocalizadorDeCombinaciones(){


	delete this->todosLosTransportes;
	delete this->transportesEnElOrigen;
	delete this->transportesEnElDestino;
	delete this->calculador;

	Lista<NodoDeAdyacencia * > * listaDeAdyacencia = this->grafo->obtenerListaDeAdyacencia();
	listaDeAdyacencia->iniciarCursor();
	while(listaDeAdyacencia->avanzarCursor()){

		NodoDeAdyacencia * nodo = listaDeAdyacencia->obtenerCursor();
		delete nodo->obtenerVertice();

	}

	delete this->grafo;


}

