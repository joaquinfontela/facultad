#ifndef MAPA_H_
#define MAPA_H_

#include <string>
#include "DibujadorDeRuta.h"
#include "ManejadorDeDatos.h"
#include "Interfaz.h"
#include "Ruta.h"


/*
 * Constantes
 */
const std::string RUTA_ARCHIVO_SUBTES = "./src/CSV/bocas-de-subte.csv";
const std::string RUTA_ARCHIVO_COLECTIVOS = "./src/CSV/paradas-de-colectivo.csv";
const std::string RUTA_ARCHIVO_GARAJES = "./src/CSV/garajes-comerciales.csv";
const std::string RUTA_ARCHIVO_TRENES = "./src/CSV/estaciones-de-ferrocarril.csv";
const int ANCHO_DE_LA_IMAGEN = 300;
const int LARGO_DE_LA_IMAGEN = 300;
const std::string RUTA_DEL_ARCHIVO_A_DIBUJAR = "Ruta_Dibujada.bmp";


/*
 * Un Mapa se encarga de el funcionamiento
 * del mapa virtual permitiendo encontrar
 * una ruta dado un origen y und destino
 * mostrando dicha ruta en el mapa
 *
 */
class Mapa{

public:

	/*
	 * Post: Inicia el mapa
	 */
	Mapa();

	/*
	 * Post: Ejecuta la logica del programa
	 */
	void iniciarMapa();

	/*
	 * Post: Libera recursos
	 */
	~Mapa();
};






#endif /* MAPA_H_ */
