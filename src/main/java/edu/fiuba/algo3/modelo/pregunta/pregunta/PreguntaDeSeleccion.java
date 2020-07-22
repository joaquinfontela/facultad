package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

public abstract class PreguntaDeSeleccion implements Pregunta {

    @Override
    public void mostrarEnunciado() {}

    @Override
    public void mostrarOpciones() {}

    @Override
    public HashMap<Integer, ArrayList<Integer>> obtenerCantidadDeRespuestasCorrectasEIncorrectasPorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas) {

    }
}
