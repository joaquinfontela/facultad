package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RespuestaDeJugador {

    private Jugador duenio;
    private Respuesta respuesta;
    private EstadisticasRespuesta estadisticas;

    public RespuestaDeJugador(Jugador jugadorIngresado, Respuesta respuestaIngresada) {

        duenio = jugadorIngresado;
        respuesta = respuestaIngresada;
    }

    public void generarEstadisticasRespuesta(Respuesta respuestaCorrecta) {

        estadisticas = respuestaCorrecta.compararCon(respuesta);
    }

    public EstadisticasRespuesta obtenerEstadisticasRespuesta() {
        return estadisticas;
    }

    public Jugador obtenerDuenio() {
        return duenio;
    }
}