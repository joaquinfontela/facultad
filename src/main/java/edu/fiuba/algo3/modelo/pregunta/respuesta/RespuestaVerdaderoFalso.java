package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;

public class RespuestaVerdaderoFalso extends Respuesta {

    ArrayList<OpcionElegible> opciones;

    public RespuestaVerdaderoFalso(){
        this.opciones = new ArrayList<OpcionElegible>();
    }

    @Override
    public EstadisticasRespuestas compararCon(Respuesta otraRespuesta) {

        EstadisticasRespuestas estadisticasRespuestas = new EstadisticasRespuestas();

        for (Opcion opcion : otraRespuesta.opciones) {

            OpcionElegible opcionRespuestaCorrecta = this.opciones.stream()
                    .filter(opcionPropia -> opcionPropia.tieneElMismoIdQue(opcion))
                    .findAny()
                    .orElse(new OpcionElegible(2, "A"));

            opcionRespuestaCorrecta.compararCon(opcion);

        }

        return estadisticasRespuestas;
    }
}
