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

    public Integer obtenerOpcionesCorrectasElegidas(){
        return this.opcionesCorrectasElegidas;
    }

    public Boolean hayOpcionesIncorrectas(){
        return (this.opcionesIncorrectasElegidas > 0);
    }

    public Boolean hayOpcionesCorrectasNoElegidas(){
        return (this.opcionesCorrectasNoElegidas > 0)
    }

    public Integer calcularPuntajePenalidadBase(){
        return (this.opcionesCorrectasElegidas - this.opcionesIncorrectasElegidas);
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
