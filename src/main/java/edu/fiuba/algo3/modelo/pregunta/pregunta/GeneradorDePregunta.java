package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GeneradorDePregunta {

    private ArrayList<Pregunta> Preguntas;
    private HashMap<Integer, Respuesta> id_TipoDePregunta;

    public GeneradorDePregunta() {
        id_TipoDePregunta= new HashMap<>() ;
        id_TipoDePregunta.put(1, new RespuestaVerdaderoFalso());
        id_TipoDePregunta.put(2, new RespuestaMultipleChoice());
        id_TipoDePregunta.put(3, new RespuestaGroupChoice());
        id_TipoDePregunta.put(4, new RespuestaOrderedChoice());

    }

    ArrayList<Opcion> formatearOpciones() { return new ArrayList<>(); }

    Pregunta generarPregunta(Modalidad modalidad, int tipoDePregunta, String enunciado, EnunciadosOpciones opciones) {

        Respuesta respuestaCorrecta = id_TipoDePregunta.get(tipoDePregunta);
        respuestaCorrecta.rellenar(opciones);

        Pregunta nuevaPregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);
        return nuevaPregunta;
    }
}