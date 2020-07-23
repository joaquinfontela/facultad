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

            Opcion opcionRespuestaCorrecta = this.opciones.stream()
                    .filter(opcionPropia -> opcionPropia.tieneElMismoIdQue(opcion))
                    .findAny()
                    .orElse(null);
            // obtiene la opcion de la rta correcta con el mismo id.

            EstadisticasRespuestas estadisticasUltimaComparacion = opcionRespuestaCorrecta.compararCon(opcion);

            estadisticasRespuestas.sumar(estadisticasUltimaComparacion);

        }

        return estadisticasRespuestas;
    }

}
