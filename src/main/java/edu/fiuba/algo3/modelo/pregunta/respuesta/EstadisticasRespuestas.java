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

    void sumarCorrectaElegida(){
        this.opcionesCorrectasElegidas++;
    }

    void sumarCorrectaNoElegida(){
        this.opcionesCorrectasNoElegidas++;
    }

    void sumarInorrectaElegida(){
        this.opcionesIncorrectasElegidas++;
    }
}
