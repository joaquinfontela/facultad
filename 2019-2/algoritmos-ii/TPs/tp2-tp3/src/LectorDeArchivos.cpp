#include "LectorDeArchivos.h"


using namespace std;

LectorDeArchivos::LectorDeArchivos(string rutaArchivoTrenes, string rutaArchivoSubtes,
		 	 	 	 	 	 	   string rutaArchivoColectivos, string rutaArchivoGarajes){


	this->rutaArchivoTrenes = rutaArchivoTrenes;
	this->rutaArchivoSubtes = rutaArchivoSubtes;
	this->rutaArchivoColectivos = rutaArchivoColectivos;
	this->rutaArchivoGarajes = rutaArchivoGarajes;
	this->lector = new LectorCSV;
	this->datosLeidos = new PuntosDeTrasbordo;

}


void LectorDeArchivos::leerArchivoTrenes(){


	ifstream archivoTrenes;
	archivoTrenes.open(rutaArchivoTrenes.c_str());

	Cola<string> * lineaParseada;
	unsigned int campos = this->lector->contarCampos(archivoTrenes, DELIMITADOR);


	while(! archivoTrenes.eof()){
		this->lector->leerLinea(archivoTrenes, campos, DELIMITADOR);
		lineaParseada = this->lector->obtenerLineaParseada();
		this->guardarDatosTrenes(lineaParseada);
	}

}


void LectorDeArchivos::leerArchivoSubtes(){


	ifstream archivoSubtes;
	archivoSubtes.open(rutaArchivoSubtes.c_str());

	Cola<string> * lineaParseada;
	unsigned int campos = this->lector->contarCampos(archivoSubtes, DELIMITADOR);


	while(! archivoSubtes.eof()){
		this->lector->leerLinea(archivoSubtes, campos, DELIMITADOR);
		lineaParseada = this->lector->obtenerLineaParseada();
		this->guardarDatosSubtes(lineaParseada);
	}

}


void LectorDeArchivos::leerArchivoColectivos(){


	ifstream archivoColectivos;
	archivoColectivos.open(rutaArchivoColectivos.c_str());

	Cola<string> * lineaParseada;
	unsigned int campos = this->lector->contarCampos(archivoColectivos, DELIMITADOR);


	while(! archivoColectivos.eof()){
		this->lector->leerLinea(archivoColectivos, campos, DELIMITADOR);
		lineaParseada = this->lector->obtenerLineaParseada();
		this->guardarDatosColectivos(lineaParseada);
	}


}


void LectorDeArchivos::leerArchivoGarajes(){


	ifstream archivoGarajes;
	archivoGarajes.open(rutaArchivoGarajes.c_str());

	Cola<string> * lineaParseada;
	unsigned int campos = this->lector->contarCampos(archivoGarajes, DELIMITADOR);


	while(! archivoGarajes.eof()){
		this->lector->leerLinea(archivoGarajes, campos, DELIMITADOR);
		lineaParseada = this->lector->obtenerLineaParseada();
		this->guardarDatosGarajes(lineaParseada);
	}


}


PuntosDeTrasbordo * LectorDeArchivos::obtenerDatosLeidos(){


	return this->datosLeidos;

}


LectorDeArchivos::~LectorDeArchivos(){

	delete this->lector;
	delete this->datosLeidos;

}


void LectorDeArchivos::guardarDatosTrenes(Cola<string> * lineaParseada){


	double nuevaLongitud = this->lector->convertirStringADouble(lineaParseada->desacolar());
	double nuevaLatitud = this->lector->convertirStringADouble(lineaParseada->desacolar());
	unsigned int nuevaId = this->lector->convertirStringAInt(lineaParseada->desacolar());
	string nuevoNombre = lineaParseada->desacolar();
	string nuevaLinea = lineaParseada->desacolar();
	lineaParseada->desacolar();
	string nuevoRamal = lineaParseada->desacolar();

	lineaParseada->vaciarCola();

	EstacionDeTren * nuevaEstacionDeTren = new EstacionDeTren(nuevaLongitud, nuevaLatitud,
															  nuevaId, nuevoNombre, nuevaLinea, nuevoRamal);

	this->datosLeidos->agregarEstacionDeTren(nuevaEstacionDeTren);


}


void LectorDeArchivos::guardarDatosSubtes(Cola<string> * lineaParseada){


	double nuevaLongitud = this->lector->convertirStringADouble(lineaParseada->desacolar());
	double nuevaLatitud = this->lector->convertirStringADouble(lineaParseada->desacolar());
	unsigned int nuevaId = this->lector->convertirStringAInt(lineaParseada->desacolar());
	string nuevaLinea = lineaParseada->desacolar();
	string nuevoNombreDeEstacion = lineaParseada->desacolar();

	lineaParseada->vaciarCola();

	BocaDeSubte * nuevaBocaDeSubte = new BocaDeSubte(nuevaLongitud, nuevaLatitud,
													 nuevaId, nuevaLinea, nuevoNombreDeEstacion);

	this->datosLeidos->agregarBocaDeSubte(nuevaBocaDeSubte);


}


void LectorDeArchivos::guardarDatosColectivos(Cola<string> * lineaParseada){


	lineaParseada->desacolar();
	lineaParseada->desacolar();
	string nuevoNombreDeLaCalle = lineaParseada->desacolar();
	double nuevaLatitud = this->lector->convertirStringADouble(lineaParseada->desacolar());
	double nuevaLongitud = this->lector->convertirStringADouble(lineaParseada->desacolar());
	lineaParseada->desacolar();
	lineaParseada->desacolar();
	lineaParseada->desacolar();
	string nuevaLineaDeColectivo = lineaParseada->desacolar();

	lineaParseada->vaciarCola();

	ParadaDeColectivo * nuevaParadaDeColectivo = new ParadaDeColectivo(nuevaLongitud, nuevaLatitud,
																	   nuevoNombreDeLaCalle, nuevaLineaDeColectivo);

	this->datosLeidos->agregarParadaDeColectivo(nuevaParadaDeColectivo);


}



void LectorDeArchivos::guardarDatosGarajes(Cola<string> * lineaParseada){


	double nuevaLongitud = this->lector->convertirStringADouble(lineaParseada->desacolar());
	double nuevaLatitud = this->lector->convertirStringADouble(lineaParseada->desacolar());
	lineaParseada->desacolar();
	string nuevoNombreDeLaCalle = lineaParseada->desacolar();
	unsigned int nuevaAlturaDeLaCalle = this->lector->convertirStringAInt(lineaParseada->desacolar());

	lineaParseada->vaciarCola();

	Garaje * nuevoGaraje = new Garaje(nuevaLongitud, nuevaLatitud, nuevoNombreDeLaCalle, nuevaAlturaDeLaCalle);

	this->datosLeidos->agregarGaraje(nuevoGaraje);


}








































