package edu.fiuba.algo3.modelo.pregunta.respuesta;

public class EstadisticasRespuestas {

    Integer opcionesCorrectasElegidas;
    Integer opcionesIncorrectasElegidas;
    Integer opcionesCorrectasNoElegidas;

    public EstadisticasRespuestas(){
        this.opcionesCorrectasElegidas = 0;
        this.opcionesCorrectasNoElegidas = 0;
        this.opcionesIncorrectasElegidas = 0;
    }

    public void sumar(EstadisticasRespuestas otrasEstadisticas){

        this.opcionesCorrectasElegidas += otrasEstadisticas.obtenerOpcionesCorrectasElegidas();
        this.opcionesIncorrectasElegidas += otrasEstadisticas.opcionesIncorrectasElegidas;
        this.opcionesCorrectasNoElegidas += otrasEstadisticas.opcionesCorrectasNoElegidas;
    }

    public Integer obtenerOpcionesCorrectasElegidas(){
        return this.opcionesCorrectasElegidas;
    }

    public Boolean hayOpcionesIncorrectas(){
        return (this.opcionesIncorrectasElegidas > 0);
    }

    public Boolean hayOpcionesCorrectasNoElegidas(){
        return (this.opcionesCorrectasNoElegidas > 0);
    }

    public Integer calcularPuntajePenalidadBase(){
        return (this.opcionesCorrectasElegidas - this.opcionesIncorrectasElegidas);
    }

    public void sumarCorrectaElegida(){
        this.opcionesCorrectasElegidas++;
    }

    public void sumarCorrectaNoElegida(){
        this.opcionesCorrectasNoElegidas++;
    }

    public void sumarIncorrectaElegida(){
        this.opcionesIncorrectasElegidas++;
    }
}
