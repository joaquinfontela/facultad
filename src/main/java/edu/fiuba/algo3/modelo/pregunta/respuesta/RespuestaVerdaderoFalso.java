package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;
import java.util.stream.Stream;

public class RespuestaVerdaderoFalso extends Respuesta {

    @Override
    public EstadisticasRespuestas compararCon(RespuestaVerdaderoFalso otraRespuesta) {

        EstadisticasRespuestas estadisticasRespuestas = new EstadisticasRespuestas();

        for (OpcionElegible opcion : otraRespuesta.opciones ){

            Opcion opcionRespuestaCorrecta = this.opciones.stream()
                    .filter(opcionPropia -> opcionPropia.equals(opcion))
                    .findAny()
                    .orElse(null);

            opcionRespuestaCorrecta.compararCon(opcion);
        }


    }
}
