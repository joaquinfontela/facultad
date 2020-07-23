package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pregunta {

    private String enunciado;
    protected Respuesta respuestaCorrecta;
    private Modalidad modalidad;

    Pregunta(Modalidad modalidad, String enunciado){
        this.modalidad = modalidad;
        this.enunciado = enunciado;
    }

    public abstract void mostrarEnunciado();

    public abstract void mostrarOpciones();

    public Respuesta obtenerRespuestaCorrecta(){
        return this.respuestaCorrecta;
    }

    public abstract HashMap<Integer, Integer> obtenerPuntajePorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas);

    public abstract HashMap<Integer, ArrayList<Integer>> obtenerCantidadDeRespuestasCorrectasEIncorrectasPorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas);

}
