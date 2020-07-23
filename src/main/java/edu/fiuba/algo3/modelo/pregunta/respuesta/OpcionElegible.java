package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;
import java.util.List;

public class OpcionElegible extends Opcion {

    Boolean elegida;

    public OpcionElegible(Integer id, String enunciado){

        super(id, enunciado);
        this.elegida = false;
    }

    public void elegir(){
        this.elegida = true;
    }

    @Override
    public EstadisticasRespuestas compararCon(Opcion otraOpcion) {

        /* Devuelve el resultado de la comparacion en una instancia de EstadisticasRespuestas
        de una Opcion base tomada como correcta (this) y otra recibida por parametro.
        */

        OpcionElegible otraOpcionElegible = (OpcionElegible) otraOpcion;

        EstadisticasRespuestas estadisticas = new EstadisticasRespuestas();

        if ( this.elegida && otraOpcionElegible.elegida ){ estadisticas.sumarCorrectaElegida(); }
        if ( ! ( this.elegida ) && otraOpcionElegible.elegida ){ estadisticas.sumarIncorrectaElegida(); }
        if ( this.elegida && ! ( otraOpcionElegible.elegida ) ){ estadisticas.sumarCorrectaNoElegida(); }

        return estadisticas;
    }
}
