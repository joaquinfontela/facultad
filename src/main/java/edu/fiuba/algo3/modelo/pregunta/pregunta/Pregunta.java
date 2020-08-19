package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    public boolean sePuedeUsarExclusividad() {
        return modalidad.sePuedeUsarExclusividad();
    }

    public String obtenerEnunciado() {
        return enunciado;
    }

    public ArrayList<String> obtenerEnunciadosOpciones() {

        ArrayList<String> enunciadosOpciones = respuestaCorrecta.obtenerEnunciadosOpciones();
        Collections.shuffle(enunciadosOpciones, new Random());
        return enunciadosOpciones;
    }

    public Respuesta crearRespuestaComparable() {
        return respuestaCorrecta.crearRespuestaComparable();
    }

    public boolean esTipoDeRespuestaComparable(Class clase) {

        return respuestaCorrecta.esTipoDeRespuestaComparable(clase);
    }

    public boolean tieneLaMismaModalidad(Class clase) {
        return modalidad.esDelMismoTipo(clase);
    }
}