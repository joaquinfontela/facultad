package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

public class RespuestaVerdaderoFalso extends Respuesta {

    String OpcionCorrecta;
    String OpcionIncorrecta;

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

    @Override
    public void rellenar(EnunciadosOpciones opcionesAagregar) {


    }
}
