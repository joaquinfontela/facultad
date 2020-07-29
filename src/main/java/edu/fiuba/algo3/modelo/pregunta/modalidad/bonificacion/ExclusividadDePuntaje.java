package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class ExclusividadDePuntaje implements Bonificacion {

    @Override
    //solo se aplica si uno no puntua y el otro si (aunque sea parcialmente)
    public void aplicar(ArrayList<RespuestaDeJugador> respuestasJugadores) {

        RespuestaDeJugador respuestaPosibleCandidato = null;
        int cantidadCandidatos = 0;
        for (RespuestaDeJugador respuesta : respuestasJugadores) {
            if (respuesta.haPuntuado()) {
                respuestaPosibleCandidato = respuesta;
                cantidadCandidatos++;
            }
        }
        if (cantidadCandidatos == 1) {
            respuestaPosibleCandidato.aplicarMultiplicacion(2);
        }
    }

    @Override
    public boolean esExclusividad() {
        return true;
    }
}