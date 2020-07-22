package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class PreguntaDeSeleccion implements Pregunta {

    @Override
    public void mostrarEnunciado() {}

    @Override
    public void mostrarOpciones() {}

    @Override
    public HashMap<Integer, ArrayList<Integer>> obtenerCantidadDeRespuestasCorrectasEIncorrectasPorJugador(HashMap<Integer, Respuesta>) {

    }
}
