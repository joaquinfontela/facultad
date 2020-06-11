#include "ManejadorDeDatos.h"

using namespace std;


ManejadorDeDatos::ManejadorDeDatos(string rutaArchivoTrenes, string rutaArchivoSubtes,
		 	 	 	 	 	 	   string rutaArchivoColectivos, string rutaArchivoGarajes){

	this->puntosDeTrasbordo = NULL;
	this->lectorDeArchivos = new LectorDeArchivos(rutaArchivoTrenes, rutaArchivoSubtes, rutaArchivoColectivos, rutaArchivoGarajes);
	this->cargarDatos();

}


PuntosDeTrasbordo * ManejadorDeDatos::obtenerPuntosDeTrasbordo() const{

	return this->puntosDeTrasbordo;

}


void ManejadorDeDatos::cargarDatos(){

	this->lectorDeArchivos->leerArchivoTrenes();
	this->lectorDeArchivos->leerArchivoSubtes();
	this->lectorDeArchivos->leerArchivoColectivos();
	this->lectorDeArchivos->leerArchivoGarajes();

	this->puntosDeTrasbordo = new PuntosDeTrasbordo(this->lectorDeArchivos->obtenerDatosLeidos());


}


ManejadorDeDatos::~ManejadorDeDatos(){

	this->borrarDatos();
	delete this->puntosDeTrasbordo;
	delete this->lectorDeArchivos;
}

void ManejadorDeDatos::borrarDatos(){


	this->borrarEstacionesDeTren();
	this->borrarBocasDeSubtes();
	this->borrarParadasDeColectivo();
	this->borrarGarajes();

}


void ManejadorDeDatos::borrarEstacionesDeTren(){

	Lista<EstacionDeTren*> * estacionesABorrar = this->puntosDeTrasbordo->obtenerEstacionesDeTrenes();
	estacionesABorrar->iniciarCursor();
	while(estacionesABorrar->avanzarCursor()){

		delete estacionesABorrar->obtenerCursor();

	}


}

void ManejadorDeDatos::borrarBocasDeSubtes(){

	Lista<BocaDeSubte*> * subtesABorrar = this->puntosDeTrasbordo->obtenerBocasDeSubtes();
	subtesABorrar->iniciarCursor();
	while(subtesABorrar->avanzarCursor()){

		delete subtesABorrar->obtenerCursor();

	}

}


void ManejadorDeDatos::borrarParadasDeColectivo(){

	Lista<ParadaDeColectivo*> * colectivosABorrar = this->puntosDeTrasbordo->obtenerParadasDeColectivos();
	colectivosABorrar->iniciarCursor();
	while(colectivosABorrar->avanzarCursor()){

		delete colectivosABorrar->obtenerCursor();

	}

}

void ManejadorDeDatos::borrarGarajes(){

	Lista<Garaje*> * garajesABorrar = this->puntosDeTrasbordo->obtenerGarajes();
	garajesABorrar->iniciarCursor();
	while(garajesABorrar->avanzarCursor()){

		delete garajesABorrar->obtenerCursor();

	}

}

