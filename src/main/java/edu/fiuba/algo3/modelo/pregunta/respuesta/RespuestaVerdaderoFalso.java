package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

public class RespuestaVerdaderoFalso extends Respuesta {

    public RespuestaVerdaderoFalso(){
        this.opciones = new ArrayList<>();
    }

    @Override
    public EstadisticasRespuestas compararCon(Respuesta otraRespuesta) {

        EstadisticasRespuestas estadisticasRespuestas = new EstadisticasRespuestas();

        for (Opcion opcion : otraRespuesta.opciones) {

            OpcionElegible opcionElegible = (OpcionElegible) opcion;

            /*OpcionElegible opcionRespuestaCorrecta = this.opciones.stream()
                    .filter(opcionPropia -> opcionPropia.tieneElMismoIdQue(opcion))
                    .findAny()
                    .orElse(null);
            */
            Opcion opcionRespuestaCorrecta = this.obtenerOpcionRespuestaCorrectaConElMismoIdQue(opcion);

            EstadisticasRespuestas estadisticasUltimaComparacion = opcionRespuestaCorrecta.compararCon(opcionElegible);

            estadisticasRespuestas.sumar(estadisticasUltimaComparacion);

        }

        return estadisticasRespuestas;
    }

    private Opcion obtenerOpcionRespuestaCorrectaConElMismoIdQue(Opcion otraOpcion){

        for (Opcion opcionPropia : this.opciones) {

            if (opcionPropia.tieneElMismoIdQue(otraOpcion)){

                return opcionPropia;
            }

        }

        return null;
    }
}
