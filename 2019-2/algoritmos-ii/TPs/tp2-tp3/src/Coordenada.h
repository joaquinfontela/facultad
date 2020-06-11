#ifndef COORDENADA_H_
#define COORDENADA_H_


/*
 * Una coordenada se compone de una longitud y una latitud
 * representa un punto en un plano longitud-latitud
 *
 */
template <class T>
class Coordenada{

private:

	T longitud;

	T latitud;


public:

	/*
	 * Pre: Recibe dos valores correpondinetes a la longitud y la latitud
	 * Pos: inicializa una instancia de Coordenada con los respectivos valores de longitud y latitud.
	 */

	Coordenada(T longitud, T latitud);


	/*
	 * Pre: la instancia ha sido inicializada.
	 * Pos: devuelve el atributo longitud de Coordenada.
	 */

	T obtenerLongitud();


	/*
	 * Pre: la instancia ha sido inicializada.
	 * Pos: devuelve el atributo latitud de Coordenada.
	 */

	T obtenerLatitud();

};

template <class T>

Coordenada<T>::Coordenada(T longitud, T latitud){

	this -> longitud = longitud;

	this -> latitud = latitud;

}


template <class T>

T Coordenada<T>::obtenerLongitud(){

	return this -> longitud;

}


template <class T>

T Coordenada<T>::obtenerLatitud(){

	return this -> latitud;

}


#endif /* COORDENADA_H_ */
