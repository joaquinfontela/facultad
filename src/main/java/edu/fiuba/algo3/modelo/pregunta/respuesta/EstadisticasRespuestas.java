package edu.fiuba.algo3.modelo.pregunta.respuesta;

public class EstadisticasRespuestas {

    Integer opcionesCorrectasElegidas;
    Integer opcionesIncorrectasElegidas;
    Integer opcionesCorrectasNoElegidas;

    public EstadisticasRespuestas(){

        opcionesCorrectasElegidas = 0;
        opcionesCorrectasNoElegidas = 0;
        opcionesIncorrectasElegidas = 0;
    }

    public void sumar(EstadisticasRespuestas otrasEstadisticas){

        opcionesCorrectasElegidas += otrasEstadisticas.obtenerOpcionesCorrectasElegidas();
        opcionesIncorrectasElegidas += otrasEstadisticas.opcionesIncorrectasElegidas;
        opcionesCorrectasNoElegidas += otrasEstadisticas.opcionesCorrectasNoElegidas;
    }

    public Integer obtenerOpcionesCorrectasElegidas(){
        return opcionesCorrectasElegidas;
    }

    public Boolean hayOpcionesIncorrectas(){
        return (opcionesIncorrectasElegidas > 0);
    }

    public Boolean hayOpcionesCorrectasNoElegidas(){
        return (opcionesCorrectasNoElegidas > 0);
    }

    public Integer calcularPuntajePenalidadBase(){
        return (opcionesCorrectasElegidas - opcionesIncorrectasElegidas);
    }

    public void sumarCorrectaElegida(){
        opcionesCorrectasElegidas++;
    }

    public void sumarCorrectaNoElegida(){
        opcionesCorrectasNoElegidas++;
    }

    public void sumarIncorrectaElegida(){
        opcionesIncorrectasElegidas++;
    }
}