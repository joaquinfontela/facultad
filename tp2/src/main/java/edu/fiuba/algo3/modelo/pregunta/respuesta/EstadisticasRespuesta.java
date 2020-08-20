package edu.fiuba.algo3.modelo.pregunta.respuesta;

public class EstadisticasRespuesta {

    private int opcionesCorrectasElegidas;
    private int opcionesIncorrectasElegidas;
    private int opcionesCorrectasNoElegidas;

    public EstadisticasRespuesta() {

        opcionesCorrectasElegidas = 0;
        opcionesCorrectasNoElegidas = 0;
        opcionesIncorrectasElegidas = 0;
    }

    public void sumar(EstadisticasRespuesta otrasEstadisticas) {

        opcionesCorrectasElegidas += otrasEstadisticas.obtenerOpcionesCorrectasElegidas();
        opcionesIncorrectasElegidas += otrasEstadisticas.opcionesIncorrectasElegidas;
        opcionesCorrectasNoElegidas += otrasEstadisticas.opcionesCorrectasNoElegidas;
    }

    public int obtenerOpcionesCorrectasElegidas(){
        return opcionesCorrectasElegidas;
    }

    public boolean hayOpcionesIncorrectas(){
        return (opcionesIncorrectasElegidas > 0);
    }

    public boolean hayOpcionesCorrectasNoElegidas(){
        return (opcionesCorrectasNoElegidas > 0);
    }

    public int calcularPuntajePenalidadBase(){
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