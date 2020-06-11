#ifndef GEOLOCALIZADORDECOMBINACIONES_H_
#define GEOLOCALIZADORDECOMBINACIONES_H_

#include "PuntosDeTrasbordo.h"
#include "Coordenada.h"
#include "Lista.h"
#include "GrafoDeRutas.h"
#include "CalculadorDePeso.h"



/*
 * Constantes
 */
const double TARIFA_DE_SUBTE = 19.00;
const double TARIFA_DE_TREN = 12.25;
const double TARIFA_DE_COLECTIVO = 18.00;
const double TARIFA_POR_CAMINAR = 0.00;
const double TARIFA_POR_COMBINACION = 20.00;



/*
 * Verifica si algun transporte desde el final del
 * Recorrido coincide con las paradas de los transportes
 * Verifcados en GeoDeTrans, en caso de no haber combinacion
 * se verificaran garajes
 */

class GeolocalizadorDeCombinaciones{


	private:

		double xInicial;
		double yInicial;
		double xFinal;
		double yFinal;
		double radioCuadrado;
		PuntosDeTrasbordo* todosLosTransportes;
		PuntosDeTrasbordo* transportesEnElOrigen;
		PuntosDeTrasbordo* transportesEnElDestino;
		GrafoDeRutas * grafo;
		CalculadorDePeso * calculador;

	public:


		/*
		 * Pre: recibe los transportes posibles en el origen,
		 *  coordenadas de jugador y final y la lista de todos los transportes
		 * Post: constructor de geolocalizador de transportes
		 */
		GeolocalizadorDeCombinaciones(PuntosDeTrasbordo* todosLosTransportes,
									  double xFinal, double yFinal,
									  double xInicial, double yInicial, double radioCuadrado);

		/*
		 * Pre:
		 * Post: Devuelve los transportes en el origen
		 */
		PuntosDeTrasbordo* obtenerTransportesEnElOrigen();

		/*
		 * Pre:
		 * Post:filtra los transportes en el final
		 */
		PuntosDeTrasbordo* filtrarTransportesEnElDestino();

		/*
		 * Pre:
		 * Post: filtra los transportes en el origen
		 */
		PuntosDeTrasbordo* filtrarTransportesEnElOrigen();

		/*
		 * Pre:
		 * Post: verifica intersecciones con transportes y genera una lista con las intersecciones
		 */
		void agregarCombinaciones();


		/*
		 * Pre:
		 * Post: Genera una lista de rutas directas
		 */
		void agregarRutasDirectas();

		/*
		 * Pre:
		 * Post: Devuelve el grafo
		 */
		GrafoDeRutas * obtenerGrafo();

		/*
		 * Pre:
		 * Post: libera los recursos utilizados
		 */
		~GeolocalizadorDeCombinaciones();


	private:

		/*
		 * Pre:
		 * Post: Agrega dos vertices que tienen la subidaDelColectivo y
		 * el descensoDelColectivo y las conecta con una arista
		 * del peso correspondiente
		 */
		void agregarViajeEnColectivoAlGrafo(ParadaDeColectivo * subidaDelColectivo,
											ParadaDeColectivo * descensoDelColectivo);
		/*
		 * Pre:
		 * Post: Agrega dos vertices que tienen el ingresoAlSubte y
		 * la salidaDelSubte y las conecta con una arista
		 * del peso correspondiente
		 */
		void agregarViajeEnSubteAlGrafo(BocaDeSubte * ingresoAlSubte,
										BocaDeSubte * salidaDelSubte);


		/*
		 * Pre:
		 * Post: Agrega dos vertices que tienen el ingresoAlAnden y
		 * la salidaDelAnden y las conecta con una arista
		 * del peso correspondiente
		 */
		void agregarViajeEnTrenAlGrafo(EstacionDeTren * ingresoAlAnden,
									   EstacionDeTren * salidaDelAnden);


		/*
		 * Pre:
		 * Post: Agrega la ParadaDeColectivo al grafo creando o no un Vertice
		 */
		void agregarParadaDeColectivoAlGrafo(ParadaDeColectivo * aAgregar);

		/*
		 * Pre:
		 * Post: Agrega la BocaDeSubte al grafo creando o no un Vertice
		 */
		void agregarBocaDeSubteAlGrafo(BocaDeSubte * aAgregar);

		/*
		 * Pre:
		 * Post: Agrega la EstacionDeTren al grafo creando o no un Vertice
		 */
		void agregarEstacionDeTrenAlGrafo(EstacionDeTren * aAgregar);

		/*
		 * Pre:
		 * Post: Conecta al Origen con unVertice a TARIFA_POR_CAMINAR
		 */
		void agregarAristaConElOrigen(Vertice * unVertice);

		/*
		 * Pre:
		 * Post: Conecta al Destino con unVertice a TARIFA_POR_CAMINAR
		 */
		void agregarAristaConElDestino(Vertice* unVertice);


		/*
		 * Pre: Recibe una instancia de PuntosDeTrasbordo, dos latitudes y dos longitudes.
		 * Post: devuelve otra instancia de PuntosDeTrasbordo, con aquellos puntos del primero
		 * que estan dentro de la region limitada por las latitudes y longitudes recibidas.
		 * (Reduce el tiempo de ejecucion del programa enormemente).
		 */
		PuntosDeTrasbordo* filtrarPuntosDeTrasbordoEnUnaRegionDelMapa(PuntosDeTrasbordo*, double, double, double, double);


		/*
		 * Post: Recibe dos double
		 * Post: devuelve el menor.
		 */
		double obtenerMenor(double, double);


		/*
		 * Post: Recibe dos double
		 * Post: devuelve el mayor.
		 */
		double obtenerMayor(double, double);


		/*
		 * Pre: recibe una lista de BocaDeSubte, una instancia de PuntosDeTrasbordo,
		 *  y cuatro double (dos longitudes y dos latitudes).
		 * Post: filtra aquellos elementos de la lista de BocaDeSubte
		 * que estan dentro de la region limitada por los puntos recibidos,
		 * y los agrega a la lista de BocaDeSubte de PuntosDeTrasbordo.
		 */
		void filtrarBocasDeSubteEnUnaRegionDelMapa(Lista<BocaDeSubte*>* bocasDeSubte,
												   PuntosDeTrasbordo* puntosDeTrasbordo,
												   double menorLongitud, double mayorLongitud,
												   double menorLatitud, double mayorLatitud);


		/*
		 * Pre: recibe una lista de EstacionDeTren, una instancia de PuntosDeTrasbordo,
		 *  y cuatro double (dos longitudes y dos latitudes).
		 * Post: filtra aquellos elementos de la lista de EstacionDeTren
		 *  que estan dentro de la region limitada por los puntos recibidos,
		 * y los agrega a la lista de EstacionDeTren de PuntosDeTrasbordo.
		 */
		void filtrarEstacionesDeTrenEnUnaRegionDelMapa(Lista<EstacionDeTren*>* estacionesDeTren,
													   PuntosDeTrasbordo* puntosDeTrasbordo,
													   double menorLongitud, double mayorLongitud,
													   double menorLatitud, double mayorLatitud);


		/*
		 * Pre: recibe una lista de ParadaDeColectivo, una instancia de PuntosDeTrasbordo,
		 *  y cuatro double (dos longitudes y dos latitudes).
		 * Post: filtra aquellos elementos de la lista de ParadaDeColectivo
		 * que estan dentro de la region limitada por los puntos recibidos,
		 * y los agrega a la lista de ParadaDeColectivo de PuntosDeTrasbordo.
		 */
		void filtrarParadasDeColectivoEnUnaRegionDelMapa(Lista<ParadaDeColectivo*>* paradasDeColectivo,
														 PuntosDeTrasbordo* puntosDeTrasbordo,
														 double menorLongitud, double mayorLongitud,
														 double menorLatitud, double mayorLatitud);


		/*
		 * Pre: recibe la longitud del transporte que deseo comparar y
		 *  la longitud del transporte con el que voy a comparar
		 * Post: verifica si esta dentro del rango
		 */
		bool estaEnElRangoDeLongitud(double longitudTransporte, double longitudAComparar);


		/*
		 * Pre: recibe la latitud del transporte que deseo comparar y
		 *  la latitud del transporte con el que voy a comparar
		 * Post: verifica si esta dentro del rango
		 */
		bool estaEnElRangoDeLatitud(double latitudTransporte, double latitudAComparar);

		/*
		 * Pre: recibe dos puntos de trasbordo de tipo ParadaDeColectivo.
		 * Post: devuelve true si la linea que pasa por ambos puntos de trasbordo es la misma.
		 */
		bool sonParadasDeColectivoDeLaMismaLinea(ParadaDeColectivo* paradaDeColectivoOrigen,
												 ParadaDeColectivo* paradaDeColectivoDestino);

		/*
		 * Pre:
		 * Post: Agrega al grafo las rutas directas indicadas
		 */
		void actualizarParadasDeColectivoEnRutasDirectas();

		/*
		 * Pre:
		 * Post: Agrega al grafo las rutas directas indicadas
		 */
		void actualizarEstacionesDeTrenEnRutasDirectas();

		/*
		 * Pre:
		 * Post: Agrega al grafo las rutas directas indicadas
		 */
		void actualizarBocasDeSubteEnRutasDirectas();

		/*
		 * Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeTrenesConTrenes();

		/*
		 * Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeTrenesConSubtes();

		/*
		 * Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeTrenesConColectivos();

		/*
		 * Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeColectivosConTrenes();

		/*
		 * Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeColectivosConColectivos();

		/*
		 * Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeColectivosConSubtes();

		/* Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeSubtesConColectivos();

		/* Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeSubtesConTrenes();

		/*
		 * Pre:
		 * Post: Agrega al grafo cominaciones indicadas
		 */
		void actualizarCombinacionesDeSubtesConSubtes();

		/*
		 * Pre:
		 * Post: Actualiza la lista de transportes con los transportes indicados
		 */
		void filtrarColectivosEnElFinal(PuntosDeTrasbordo* transportesEnElFinal);

		/*
		 * post: Actualiza la lista de transportes con los transportes indicados
		 */
		void filtrarSubtesEnElFinal(PuntosDeTrasbordo* transportesEnElFinal);


		/*
		 * Pre:
		 * Post: Actualiza la lista de transportes con los transportes indicados
		 */
		void filtrarTrenesEnElFinal(PuntosDeTrasbordo* transportesEnElFinal);

		/* Pre:
		 * Post: Actualiza la lista de transportes con los transportes indicados
		 */
		void filtrarSubtesEnElOrigen(PuntosDeTrasbordo* transportesEnElOrigen);

		/*
		 * Pre:
		 * Post: Actualiza la lista de transportes con los transportes indicados
		 */
		void filtrarColectivosEnElOrigen(PuntosDeTrasbordo* transportesEnElOrigen);

		/*
		 * Pre:
		 * Post: Actualiza la lista de transportes con los transportes indicados
		 */
		void filtrarTrenesEnElOrigen(PuntosDeTrasbordo* transportesEnElOrigen);



		/*
		 * Pre:
		 * Post: Filtra ParadasDeColectivo de la misma linea
		 * que se encuentren cerca a la del origen
		 */
		void filtrarParadasDeColectivoDeLaMismaLineaALaCercanaAlOrigen(ParadaDeColectivo* paradaDeColectivoCercanaAlOrigen,
																	   Lista<ParadaDeColectivo*>* paradasDeColectivo,
																	   Lista <ParadaDeColectivo*>& paradasDeColectivoDeLaMismaLineaALaCercanaAlOrigen);



		template <class T>

		/*
		 * Pre: Recibe un punto de trasbordo de tipo T y cuatro double
		 *  (dos longitudes y dos latitudes).
		 * Post: Devuelve True si el punto de trasbordo esta dentro de
		 *  la region delimitada por los cuatro puntos recibidos,
		 * o False en caso contrario.
		 */
		bool estaEnLaRegionDelMapa(T* puntoDeTrasbordo,
								   double menorLongitud, double mayorLongitud,
								   double menorLatitud, double mayorLatitud){

			double longitud = puntoDeTrasbordo -> obtenerLongitud();

			double latitud = puntoDeTrasbordo -> obtenerLatitud();

			return ((menorLongitud <= longitud) && (mayorLongitud >= longitud) && (menorLatitud <= latitud) && (mayorLatitud >= latitud));

		}


		template <class T>

		/*
		 * Pre: recibe dos puntos de trasbordo T
		 * (de tipo EstacionDetren o BocaDeSubte).
		 * Post: devuelve true si la linea que pasa
		 *  por ambos puntos de trasbordo es la misma.
		 */
		bool sonPuntosDeTrasbordoDeLaMismaLinea(T* puntoDeTrasbordoOrigen, T* puntoDeTrasbordoDestino){

			return (puntoDeTrasbordoOrigen -> obtenerLinea() == puntoDeTrasbordoDestino -> obtenerLinea()) && (
					puntoDeTrasbordoOrigen != puntoDeTrasbordoDestino);

		}



		template <class T>

		/*
		 * Pre:
		 * Post: Filtra puntosDeTrasbordo de la misma linea
		 * que se encuentren cerca a la del origen
		 */
		void filtrarPuntosDeTrasbordoDeLaMismaLineaALaCercanaAlOrigen(T* puntoDeTrasbordoCercanoAlOrigen,
																	  Lista<T*>* puntosDeTrasbordo,
																	  Lista <T*>& puntosDeTrasbordoDeLaMismaLineaALaCercanaAlOrigen){

			puntosDeTrasbordo -> iniciarCursor();

			while (puntosDeTrasbordo -> avanzarCursor()){

				T* puntoDeTrasbordoAleatorio = puntosDeTrasbordo -> obtenerCursor();

				if (sonPuntosDeTrasbordoDeLaMismaLinea(puntoDeTrasbordoCercanoAlOrigen, puntoDeTrasbordoAleatorio)){

					puntosDeTrasbordoDeLaMismaLineaALaCercanaAlOrigen.agregar(puntoDeTrasbordoAleatorio);

				}

			}

		}
};

#endif /* GEOLOCALIZADORDECOMBINACIONES_H_ */
