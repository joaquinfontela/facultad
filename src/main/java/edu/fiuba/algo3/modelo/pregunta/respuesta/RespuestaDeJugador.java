package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;

public class RespuestaDeJugador {

    private Jugador duenio;
    private Respuesta respuesta;
    private EstadisticasRespuesta estadisticas;
    private int puntos;

    RespuestaDeJugador(Jugador jugadorIngresado, Respuesta respuestaIngresada) {

        duenio = jugadorIngresado;
        respuesta = respuestaIngresada;
    }

    public void generarEstadisticasRespuesta(Respuesta respuestaCorrecta) {

        estadisticas = respuestaCorrecta.compararCon(respuesta);
    }

    public void calcularPuntosBase(Modalidad modalidad) {
        puntos = modalidad.calcularPuntos(estadisticas);
    }

    public void multiplicarPuntos(int id, int factor){
        if (duenio.esElMismo(id)) puntos *= factor;
    }

    public boolean haPuntuado() {
        return (puntos > 0);
    }

    public int obtenerIdJugador() {
        return duenio.obtenerId();
    }

    public void guardarPuntaje() { duenio.sumarPuntos(puntos); }
}