#ifndef CALCULADORDEPESO_H_
#define CALCULADORDEPESO_H_

#include <string>
#include <cmath>

/*
 * Constantes
 */
const std::string PARADA_DE_COLECTIVO = "Colectivo";
const std::string ESTACION_DE_TREN = "Tren";
const std::string BOCA_DE_SUBTE = "Subte";
//Factor de conversion a kilometro surge de la regla de tres de 100 metros --- 0.0012  --> (100 / 0.0012) = 83.3333
const double CONVERSION_A_KILOMETRO = 83.3333;



class CalculadorDePeso {

private:

	double PrecioPorKilometroDeSubte;
	double PrecioPorKilometroDeColectivo;
	double PrecioPorKilometroDeTren;


public:

	/*
	 * Pre:
	 * Post: Se a creado un CalculadorDePeso con las tarifas correspondientes
	 */
	CalculadorDePeso(double tarifaDeSubte, double tarifaDeTren, double tarifaDeColectivo);


	/*
	 * Pre:
	 * Post: Devuelve el peso correspondiente para agregar en el GrafoDeRutas
	 */
	double calcularPeso(double longitudInicial, double latitudInicial,
						double longitudFinal, double latitudFinal,
						std::string transporte);

	/*
	 * Pre:
	 * Post: Libera recursos
	 */
	~CalculadorDePeso();
};

#endif /* CALCULADORDEPESO_H_ */
