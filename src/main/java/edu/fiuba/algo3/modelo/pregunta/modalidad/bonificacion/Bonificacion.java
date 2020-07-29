package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public interface Bonificacion {

    void aplicar(ArrayList<RespuestaDeJugador> respuestasJugadores);

    boolean esExclusividad();
}