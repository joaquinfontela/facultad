#include <string>
#include "lectura_y_guardado.h"
#include "LineaArchivo.h"
#include "salida.h"


using namespace std;


int main () {

		std::string archivo = "estaciones-de-metrobus.csv";

		struct LineaArchivo lineas [230];

		leerArchivoYGuardarInformacion(archivo, lineas);

		ejecucionDelArchivo(lineas);

		return 0;
}
