#include "LectorCSV.h"


using namespace std;


LectorCSV::LectorCSV(){


	this->lineaParseada = new Cola<string>;

}


void LectorCSV::leerLinea(ifstream& archivo, unsigned int campos, char delimitador){


	string elemento;
	for (unsigned int i = 0; i < campos - 1; i++){
		getline(archivo, elemento, delimitador);
		lineaParseada->acolar(elemento);
	}
	getline(archivo, elemento);
	lineaParseada->acolar(elemento);
}

unsigned int LectorCSV::contarCampos(std::ifstream& archivo, char delimitador){

	std::string linea;
	getline(archivo, linea);
	unsigned int campos = 0;
	for(int letra = 0; linea[letra] != '\0'; letra++){
		if (linea[letra] == delimitador){
			campos++;
		}
	}
	return campos + 1;
}

void LectorCSV::saltearLinea(ifstream& archivo){

	string linea;
	getline(archivo, linea);

}



Cola<std::string> * LectorCSV::obtenerLineaParseada() const{

	return this->lineaParseada;

}


int LectorCSV::convertirStringAInt(string valor){
    
    int numero = 0;
	int i = 1;
	for(int j = (valor.length() - 1); j >= 0; j--){
		numero += (valor[j] - '0') * i;
		i *= 10;
	}
	return numero;

}


double LectorCSV::convertirStringADouble(string valor){


	return atof(valor.c_str());
}



LectorCSV::~LectorCSV(){

	delete this->lineaParseada;

}
