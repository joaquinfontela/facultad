#include "Interfaz.h"

Interfaz::Interfaz(){

	latitudInicial = 0.0;
	latitudFinal = 0.0;
	longitudInicial = 0.0;
	longitudFinal = 0.0;
}

void Interfaz::pideLongitudFinal(){

	std::string numero;
	bool esValido = false;

	while(! esValido){
		try{
			std::cout<<"Ingrese longitud final: "<<std::endl;
			getline(std::cin,numero);
			esValido = tipoDeDatoValido(numero);

			if(! esValido)
				throw numero;
		}
		catch(std::string &e){
			std::cout<<"\n\nEl dato "<< e <<" no es valido"<<std::endl;
		}
	}

	longitudFinal = atof(numero.c_str());
}


void Interfaz::pideLongitudInicial(){

	std::string numero;
	bool esValido = false;

	while(! esValido){
		try{
			std::cout<<"Ingrese longitud inicial: "<<std::endl;
			getline(std::cin,numero);
			esValido = tipoDeDatoValido(numero);

			if(! esValido)
				throw numero;
		}
		catch(std::string &e){
			std::cout<<"\n\nEl dato "<< e <<" no es valido"<<std::endl;
		}
	}

	longitudInicial = atof(numero.c_str());
}

void Interfaz::pideLatitudFinal(){

	std::string numero;
	bool esValido = false;

	while(! esValido){
		try{
			std::cout<<"Ingrese latitud final: "<<std::endl;
			getline(std::cin,numero);
			esValido = tipoDeDatoValido(numero);

			if(! esValido)
				throw numero;
		}
		catch(std::string &e){
			std::cout<<"\n\nEl dato "<< e <<" no es valido"<<std::endl;
		}
	}

	latitudFinal = atof(numero.c_str());
}

void Interfaz::pideLatitudInicial(){

	std::string numero;
	bool esValido = false;

	while(! esValido){
		try{
			std::cout<<"Ingrese latitud inicial: "<<std::endl;
			getline(std::cin,numero);
			esValido = tipoDeDatoValido(numero);

			if(! esValido)
				throw numero;
		}
		catch(std::string &e){
			std::cout<<"\n\nEl dato "<< e <<" no es valido"<<std::endl;
		}
	}

	latitudInicial = atof(numero.c_str());
}

double Interfaz::obtenerLatitudInicial(){

	return latitudInicial;
}

double Interfaz::obtenerLatitudFinal(){

	return latitudFinal;
}

double Interfaz::obtenerLongitudFinal(){

	return longitudFinal;
}

double Interfaz::obtenerLongitudInicial(){

	return longitudInicial;
}

bool Interfaz::esPositivo(std::string const& numero){

	if(atof(numero.c_str()) > 0){
		return true;
	}
	else{
		return false;
	}
}

bool Interfaz::tipoDeDatoValido(std::string const& numero){

	bool toReturn = false;
	int inicio = 0;

	if(numero[0] == '-'){
		inicio = 1;
	}

	for(int i = inicio; i < int(numero.length()); i++){
		if(numero[i] == '.'){
			i++;
		}

		else if(! isdigit(numero[i])){
			return toReturn;
		}
	}

	toReturn = esPositivo(numero);

	if(! toReturn){

		toReturn = true;
	}
	else{
		toReturn = false;
	}

	return toReturn;
}

void Interfaz::mostrarEstacionesDeTrenes(Lista<EstacionDeTren*>* estacionesDeTrenes){


	estacionesDeTrenes->iniciarCursor();
	while(estacionesDeTrenes->avanzarCursor()){

		EstacionDeTren* estacionAImprimir =estacionesDeTrenes->obtenerCursor();
		std::cout<< "" <<std::endl;
		std::cout<<"Nombre de la estacion: " << estacionAImprimir->obtenerNombreDeEstacion()<<std::endl;
		std::cout<<"Ramal de tren: " << estacionAImprimir->obtenerRamal() << std::endl;
		std::cout<<"Linea de tren: " << estacionAImprimir->obtenerLinea() << std::endl;

	}
}


void Interfaz::mostrarParadasDeColectivos(Lista<ParadaDeColectivo*>* paradasDeColectivos){


	paradasDeColectivos->iniciarCursor();
	while(paradasDeColectivos->avanzarCursor()){

		ParadaDeColectivo* paradasAImprimir = paradasDeColectivos->obtenerCursor();
		std::cout<< "" <<std::endl;
		std::cout<<"Calle de la parada de colectivo: " << paradasAImprimir->obtenerCalleDeLaParada() << std::endl;
		std::cout<<"Linea de colectivo: "<< paradasAImprimir->obtenerLineaDeColectivo() << std::endl;
	}
}


void Interfaz::mostrarBocaDeSubte(Lista<BocaDeSubte*>* bocasDeSubtes){



	bocasDeSubtes->iniciarCursor();
	while(bocasDeSubtes->avanzarCursor()){

		BocaDeSubte* bocasDeSubteAImprimir = bocasDeSubtes->obtenerCursor();
		std::cout<< "" <<std::endl;
		std::cout<< "Nombre de la estacion de subte: " <<bocasDeSubteAImprimir->obtenerNombreDeEstacion() << std::endl;
		std::cout<< "Linea de subte: " << bocasDeSubteAImprimir->obtenerLinea() << std::endl;

	}

}


void Interfaz::mostrarGarajes(Lista<Garaje*>* garajes){


	garajes->iniciarCursor();
	while(garajes->avanzarCursor()){

		Garaje* garajesAImprimir = garajes->obtenerCursor();
		std::cout<< "" <<std::endl;
		std::cout<<"Nombre de la calle: " << garajesAImprimir->obtenerNombreDeLaCalle() << std::endl;
		std::cout<<"Altura de la calle: " << garajesAImprimir->obtenerAlturaDeLaCalle() << std::endl;
	}
}

void Interfaz::finalizar(Lista<PuntosDeTrasbordo*>* mejorRuta, std::string rutaImagen){

	std::cout<< "" <<std::endl;

	if(mejorRuta != NULL && !mejorRuta->estaVacia()){

		std::cout<< " .::Se ha generado una ruta::.  " << std::endl;

		mejorRuta->iniciarCursor();
		while(mejorRuta->avanzarCursor()){
			PuntosDeTrasbordo * mejorRutaAMostrar = mejorRuta->obtenerCursor();
			mostrarGarajes(mejorRutaAMostrar->obtenerGarajes());
			mostrarBocaDeSubte(mejorRutaAMostrar->obtenerBocasDeSubtes());
			mostrarEstacionesDeTrenes(mejorRutaAMostrar->obtenerEstacionesDeTrenes());
			mostrarParadasDeColectivos(mejorRutaAMostrar->obtenerParadasDeColectivos());
		}
		std::cout<< "" <<std::endl;
		std::cout<< "Se ha dibujado la ruta en: " << rutaImagen <<std::endl;
		std::cout<< "" <<std::endl;
	}
	else{
		std::cout<< "No se encontraron rutas posibles para las coordenadas ingresadas" << std::endl;
	}

}



void Interfaz::iniciar(){

	std::cout<<"	                                                                            "<<std::endl;
	std::cout<<"		██████╗ ██╗███████╗███╗   ██╗██╗   ██╗███████╗███╗   ██╗██╗██████╗  ██████╗ "<<std::endl;
	std::cout<<"		██╔══██╗██║██╔════╝████╗  ██║██║   ██║██╔════╝████╗  ██║██║██╔══██╗██╔═══██╗"<<std::endl;
	std::cout<<"		██████╔╝██║█████╗  ██╔██╗ ██║██║   ██║█████╗  ██╔██╗ ██║██║██║  ██║██║   ██║"<<std::endl;
	std::cout<<"		██╔══██╗██║██╔══╝  ██║╚██╗██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║██║  ██║██║   ██║"<<std::endl;
	std::cout<<"		██████╔╝██║███████╗██║ ╚████║ ╚████╔╝ ███████╗██║ ╚████║██║██████╔╝╚██████╔╝"<<std::endl;
	std::cout<<"		╚═════╝ ╚═╝╚══════╝╚═╝  ╚═══╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝╚═╝╚═════╝  ╚═════╝ "<<std::endl;
	std::cout<<"	                                                                            "<<std::endl;

	std::cout<<"		                                                                            "<<std::endl;
	std::cout<<"						 █████╗ ██╗"<<std::endl;
	std::cout<<"						██╔══██╗██║"<<std::endl;
	std::cout<<"						███████║██║"<<std::endl;
	std::cout<<"						██╔══██║██║"<<std::endl;
	std::cout<<"						██║  ██║███████╗"<<std::endl;
	std::cout<<"						╚═╝  ╚═╝╚══════╝"<<std::endl;
	std::cout<<"	                                                                            "<<std::endl;


	std::cout<<"	                                                                            "<<std::endl;
	std::cout<<"	███╗   ███╗ █████╗ ██████╗  █████╗     ██╗   ██╗██╗██████╗ ████████╗██╗   ██╗ █████╗ ██╗     "<<std::endl;
	std::cout<<"	████╗ ████║██╔══██╗██╔══██╗██╔══██╗    ██║   ██║██║██╔══██╗╚══██╔══╝██║   ██║██╔══██╗██║     "<<std::endl;
	std::cout<<"	██╔████╔██║███████║██████╔╝███████║    ██║   ██║██║██████╔╝   ██║   ██║   ██║███████║██║     "<<std::endl;
	std::cout<<"	██║╚██╔╝██║██╔══██║██╔═══╝ ██╔══██║    ╚██╗ ██╔╝██║██╔══██╗   ██║   ██║   ██║██╔══██║██║     "<<std::endl;
	std::cout<<"	██║ ╚═╝ ██║██║  ██║██║     ██║  ██║     ╚████╔╝ ██║██║  ██║   ██║   ╚██████╔╝██║  ██║███████╗"<<std::endl;
	std::cout<<"	╚═╝     ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝  ╚═╝      ╚═══╝  ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝"<<std::endl;
	std::cout<<"	                                                                            "<<std::endl;
	std::cout<< "" <<std::endl;
	std::cout<< "" <<std::endl;

	this->pideLongitudInicial();
	this->pideLatitudInicial();
	this->pideLongitudFinal();
	this->pideLatitudFinal();


}


