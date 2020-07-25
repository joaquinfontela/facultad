package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

public class RespuestaVerdaderoFalso extends Respuesta {

    Opcion opcionCorrecta;
    Opcion opcionIncorrecta;

    @Override
    public EstadisticasRespuestas compararCon(Respuesta otraRespuesta) {

        EstadisticasRespuestas estadisticas = new EstadisticasRespuestas();

        RespuestaVerdaderoFalso otraRespuestaVerdaderoFalso = (RespuestaVerdaderoFalso) otraRespuesta;

        if ( this.opcionCorrecta == otraRespuestaVerdaderoFalso.opcionCorrecta ) {
            estadisticas.sumarCorrectaElegida();

        } else if ( this.opcionIncorrecta == otraRespuestaVerdaderoFalso.opcionCorrecta ) {
            estadisticas.sumarIncorrectaElegida();

        } else {
            estadisticas.sumarCorrectaNoElegida();
        }

        /*
        for (Opcion opcion : otraRespuesta.opciones) {

            Opcion opcionRespuestaCorrecta = this.opciones.stream()
                    .filter(opcionPropia -> opcionPropia.tieneElMismoIdQue(opcion))
                    .findAny()
                    .orElse(null);
            // obtiene la opcion de la rta correcta con el mismo id.

            EstadisticasRespuestas estadisticasUltimaComparacion = opcionRespuestaCorrecta.compararCon(opcion);

            estadisticasRespuestas.sumar(estadisticasUltimaComparacion);

        }
        */
        return estadisticas;
    }

    @Override
    public void rellenar(EnunciadosOpciones opcionesAagregar) {

        this.opcionCorrecta = new Opcion(opcionesAagregar.opcionesCorrectas().get(0));
        this.opcionIncorrecta = new Opcion(opcionesAagregar.opcionesIncorrectas().get(0));

    }
}
