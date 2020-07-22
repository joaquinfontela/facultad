package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.HashMap;

public interface Pregunta {

    String enunciado = null;
    Respuesta respuestaCorrecta = null;
    Modalidad modalidad = null;

    void mostrarEnunciado();

    void mostrarOpciones();

    HashMap<Integer, Integer> obtenerPuntajePorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas);

    HashMap<Integer, ArrayList<Integer>> obtenerCantidadDeRespuestasCorrectasEIncorrectasPorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas);

}
