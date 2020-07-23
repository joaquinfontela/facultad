package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;
import java.util.List;

public class OpcionElegible extends Opcion {

    Boolean elegida;

    public OpcionElegible(Integer id, String enunciado){

        super(id, enunciado);
        this.elegida = false;
    }

    @Override
    Boolean equals(Opcion opcion) {
        return (this.id == opcion.id);
    }

    public void elegir(){
        this.elegida = true;
    }

    public EstadisticasRespuestas compararCon(OpcionElegible otraOpcion) {

        /* Devuelve el resultado de la comparacion en una instancia de EstadisticasRespuestas
        de una Opcion base tomada como correcta (this) y otra recibida por parametro.
        */

        EstadisticasRespuestas estadisticas = new EstadisticasRespuestas();

        if ( this.elegida && otraOpcion.elegida ){ estadisticas.sumarCorrectaElegida(); }
        if ( ! ( this.elegida ) && otraOpcion.elegida ){ estadisticas.sumarIncorrectaElegida(); }
        if ( this.elegida && ! ( otraOpcion.elegida ) ){ estadisticas.sumarCorrectaNoElegida(); }

        return estadisticas;
    }
}
