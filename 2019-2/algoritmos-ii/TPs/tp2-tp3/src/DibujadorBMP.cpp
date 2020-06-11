#include "DibujadorBMP.h"

using namespace std;

DibujadorBMP::DibujadorBMP(int anchoDeLaImagen, int largoDeLaImagen, int grosor) {

	this->imagen = new BMP;
	this->imagen->SetBitDepth(8);
	this->imagen->SetSize(anchoDeLaImagen, largoDeLaImagen);
	this->anchoDeLaImagen = anchoDeLaImagen;
	this->largoDeLaImagen = largoDeLaImagen;
	this->grosor = grosor;

}

void DibujadorBMP::dibujarPunto(int x, int y, int radio, string color){

	for (int i = x - radio; i <= x + radio; i++){
		for (int j = y - radio; j <= y + radio; j++){
			if (i >= 0 && j >= 0 && i<= this->anchoDeLaImagen - 1 && j <= this->largoDeLaImagen &&
			   ((i-x)*(i-x) + (j-y)*(j-y) <= radio*radio)){

				this->establecerColor(i, j, color);
			}
		}
	}

}


void DibujadorBMP::dibujarLinea(int xInicial, int yInicial, int xFinal, int yFinal, string color){


	this->dibujarLineaHorizontal(yInicial, xInicial,xFinal, color);
	this->dibujarLineaVertical(xFinal, yInicial, yFinal, color);

}

void DibujadorBMP::escrbirBMP(std::string ruta){


	this->imagen->WriteToFile(ruta.c_str());

}


DibujadorBMP::~DibujadorBMP() {

	delete this->imagen;
}


void DibujadorBMP::establecerColor(int x, int y, string color){


	int rojo, azul, verde;
	int alfa = 0;

	if(color.compare("Rojo") == 0){

		rojo = INTENSIDAD_COLOR;
		azul = 0;
		verde = 0;

	}else if(color.compare("Azul") == 0){

		rojo = 0;
		azul = INTENSIDAD_COLOR;
		verde = 0;

	}else{

		rojo = 0;
		azul = 0;
		verde = INTENSIDAD_COLOR;

	}

	(*(this->imagen))(x, y)->Red = rojo;
	(*(this->imagen))(x, y)->Blue = azul;
	(*(this->imagen))(x, y)->Green = verde;
	(*(this->imagen))(x, y)->Alpha = alfa;

}


void DibujadorBMP::dibujarLineaVertical(int x, int yInicial, int yFinal, std::string color){

	int inicio, fin;

	if(yInicial > yFinal){

		inicio = yFinal;
		fin = yInicial;

	}else{

		inicio = yInicial;
		fin = yFinal;

	}

	for(int i = inicio; i <= fin; i++){
		for(int j = x ; j <= (x + this->grosor); j++){
			if (i >= 0 && j >= 0 && i<= this->anchoDeLaImagen - 1 && j <= this->largoDeLaImagen - 1 ){

				this->establecerColor(j, i, color);

			}

		}

	}

}


void DibujadorBMP::dibujarLineaHorizontal(int y, int xInicial, int xFinal, string color){

	int inicio, fin;

	if(xInicial > xFinal){

		inicio = xFinal;
		fin = xInicial;

	}else{

		inicio = xInicial;
		fin = xFinal;

	}

	for(int i = inicio; i <= fin; i++){
			for(int j = y ; j <= (y + this->grosor); j++){
				if (i >= 0 && j >= 0 && i<= this->anchoDeLaImagen - 1 && j <= this->largoDeLaImagen - 1){

					this->establecerColor(i, j, color);

				}

			}

		}
}





















