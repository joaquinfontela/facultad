package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;

public interface Pregunta {

    String enunciado = null;
    Respuesta respuestaCorrecta;
    Modalidad modalidad;

    void mostrarEnunciado();

    void mostrarOpciones();

    HashMap<Integer, Integer> obtenerPuntajePorJugador(HashMap<Integer, Respuesta>);

    HashMap<Integer, ArrayList<Integer>> obtenerCantidadDeRespuestasCorrectasEIncorrectasPorJugador(HashMap<Integer, Respuesta>);

}
