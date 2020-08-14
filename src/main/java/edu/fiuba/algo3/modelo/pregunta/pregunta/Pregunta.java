package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class Pregunta {

    private String enunciado;
    private Respuesta respuestaCorrecta;
    private Modalidad modalidad;

    public Pregunta(Modalidad modalidadIngresada, String enunciadoIngresado, Respuesta respuestaIngresada) {

        modalidad = modalidadIngresada;
        enunciado = enunciadoIngresado;
        respuestaCorrecta = respuestaIngresada;
    }

    public void mostrarEnunciado() { }

    public void mostrarOpciones() { }

    public Respuesta obtenerRespuestaCorrecta() {

        return respuestaCorrecta;
    }

    public void evaluarRespuestas(ArrayList<RespuestaDeJugador> respuestasJugadores) {

        for (RespuestaDeJugador respuesta : respuestasJugadores) {
            respuesta.generarEstadisticasRespuesta(respuestaCorrecta);
        }
        modalidad.establecerPuntajes(respuestasJugadores);
    }

    public void recibirBonificacion(Bonificacion bonificacion) throws Exception {

        modalidad.recibirBonificacion(bonificacion);
    }

    public String obtenerEnunciado() {
        return enunciado;
    }

    public ArrayList<String> obtenerEnunciadosOpciones() {
        return respuestaCorrecta.obtenerEnunciadosOpciones();
    }
}