#include "CalculadorDePeso.h"

using namespace std;


CalculadorDePeso::CalculadorDePeso(double tarifaDeSubte, double tarifaDeTren, double tarifaDeColectivo){

	this-> PrecioPorKilometroDeSubte = tarifaDeSubte;
	this-> PrecioPorKilometroDeColectivo = tarifaDeColectivo;
	this-> PrecioPorKilometroDeTren = tarifaDeTren;


}

double CalculadorDePeso::calcularPeso(double longitudInicial, double latitudInicial, double longitudFinal, double latitudFinal, string transporte){

	double distancia;
	double peso;

	distancia = ((longitudFinal-longitudInicial)*(longitudFinal-longitudInicial)) + ((latitudFinal-latitudInicial)*(latitudFinal-latitudInicial));
	distancia = sqrt(distancia) * CONVERSION_A_KILOMETRO;

	if(transporte == PARADA_DE_COLECTIVO){
		peso = distancia * PrecioPorKilometroDeColectivo;
	}
	else if(transporte == ESTACION_DE_TREN){
		peso = distancia * PrecioPorKilometroDeTren;
	}
	else if(transporte == BOCA_DE_SUBTE){
		peso = distancia * PrecioPorKilometroDeSubte;
	}

	return peso;
}

CalculadorDePeso::~CalculadorDePeso(){


}
