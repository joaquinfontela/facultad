#include "PuntosDeTrasbordo.h"



PuntosDeTrasbordo::PuntosDeTrasbordo(){

	this->estacionesDeTrenes = new Lista<EstacionDeTren*>;
	this->bocasDeSubtes = new Lista<BocaDeSubte*>;
	this->paradasDeColectivos = new Lista<ParadaDeColectivo*>;
	this->garajes = new Lista<Garaje*>;

}


PuntosDeTrasbordo::PuntosDeTrasbordo(PuntosDeTrasbordo * otrosMediosDeTransporte){


	this->estacionesDeTrenes = NULL;
	this->bocasDeSubtes = NULL;
	this->paradasDeColectivos = NULL;
	this->garajes = NULL;


	this->copiarEstacionesDeTrenes(*otrosMediosDeTransporte->estacionesDeTrenes);
	this->copiarBocasDeSubtes(*otrosMediosDeTransporte->bocasDeSubtes);
	this->copiarParadasDeColectivos(*otrosMediosDeTransporte->paradasDeColectivos);
	this->copiarGarajes(*otrosMediosDeTransporte->garajes);
}


Lista<EstacionDeTren*>* PuntosDeTrasbordo::obtenerEstacionesDeTrenes() const{

	return this->estacionesDeTrenes;

}


Lista<BocaDeSubte*>* PuntosDeTrasbordo::obtenerBocasDeSubtes() const{

	return this->bocasDeSubtes;

}


Lista<ParadaDeColectivo*>* PuntosDeTrasbordo::obtenerParadasDeColectivos() const{

	return this->paradasDeColectivos;

}


Lista<Garaje*>* PuntosDeTrasbordo::obtenerGarajes() const{

	return this->garajes;

}


void PuntosDeTrasbordo::agregarParadaDeColectivo(ParadaDeColectivo* nuevaParada){

	this->paradasDeColectivos->agregar(nuevaParada);

}


void PuntosDeTrasbordo::agregarBocaDeSubte(BocaDeSubte* nuevaBocaDeSubte){

	this->bocasDeSubtes->agregar(nuevaBocaDeSubte);

}



void PuntosDeTrasbordo::agregarEstacionDeTren(EstacionDeTren* nuevaEstacionDeTren){

	this->estacionesDeTrenes->agregar(nuevaEstacionDeTren);

}


void PuntosDeTrasbordo::agregarGaraje(Garaje* nuevoGaraje){

	this->garajes->agregar(nuevoGaraje);

}


bool PuntosDeTrasbordo::estaVacia(){


	return (this->estacionesDeTrenEstaVacia() &&
			this->bocasDeSubteEstaVacia() &&
			this->paradasDeColectivoEstaVacia() &&
			this->garajesEstaVacia());
}


bool PuntosDeTrasbordo::estacionesDeTrenEstaVacia(){


	return this->estacionesDeTrenes->estaVacia();

}


bool PuntosDeTrasbordo::bocasDeSubteEstaVacia(){


	return this->bocasDeSubtes->estaVacia();

}


bool PuntosDeTrasbordo::paradasDeColectivoEstaVacia(){


	return this->paradasDeColectivos->estaVacia();

}


bool PuntosDeTrasbordo::garajesEstaVacia(){


	return this->garajes->estaVacia();

}

PuntosDeTrasbordo::~PuntosDeTrasbordo(){

	delete this->bocasDeSubtes;
	delete this->estacionesDeTrenes;
	delete this->paradasDeColectivos;
	delete this->garajes;

}


void PuntosDeTrasbordo::copiarEstacionesDeTrenes(Lista<EstacionDeTren*>& otrasEstacionesDeTrenes){


	this->estacionesDeTrenes = new Lista<EstacionDeTren*>(otrasEstacionesDeTrenes);

}


void PuntosDeTrasbordo::copiarBocasDeSubtes(Lista<BocaDeSubte*>& otrasBocasDeSubte){


	this->bocasDeSubtes = new Lista<BocaDeSubte*>(otrasBocasDeSubte);

}


void PuntosDeTrasbordo::copiarParadasDeColectivos(Lista<ParadaDeColectivo*>& otrasParadasDeColectivo){


	this->paradasDeColectivos = new Lista<ParadaDeColectivo*>(otrasParadasDeColectivo);

}


void PuntosDeTrasbordo::copiarGarajes(Lista<Garaje*>& otrosGarajes){


	this->garajes = new Lista<Garaje*>(otrosGarajes);

}

