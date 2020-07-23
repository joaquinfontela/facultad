package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class RespuestaVerdaderoFalso extends Respuesta {

    @Override
    public EstadisticasRespuestas compararCon(Respuesta otraRespuesta) {
        for (Opcion opcion : otraRespuesta.opciones ){

            Boolean esElMismoId = (Opcion opcionPropia -> {
                return opcionPropia.id == opcion.id;
            });

            ArrayList<Opcion> opcionBuscada = this.opciones.stream().anyMatch(

            );
        }
    }
}
