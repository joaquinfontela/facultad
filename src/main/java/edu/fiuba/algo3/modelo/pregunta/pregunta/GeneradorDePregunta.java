package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.*;

import java.util.ArrayList;

public class GeneradorDePregunta {  //el codigo comentado es para generar las preguntas aleatoriamente

    private ArrayList<Pregunta> preguntas;
    private int indicePreguntaActual; // se va

    public GeneradorDePregunta(ArrayList<InformacionPregunta> informacionPreguntas) {
        preguntas = new ArrayList<>();
        indicePreguntaActual = 0; // se va
        generarTodasLasPreguntas(informacionPreguntas);
    }

    public Pregunta obtenerPreguntaNueva(){
        // Random randomizador = new Random();
        // int indiceRandom = randomizador.nextInt(preguntas.size())
        Pregunta preguntaNueva = preguntas.get(indicePreguntaActual);// preguntas.get(indiceRandom);
        indicePreguntaActual++;// se va
        // preguntas.remove(indiceRandom);
        return preguntaNueva;
    }

    void generarTodasLasPreguntas(ArrayList<InformacionPregunta> informacionPreguntas){

        for (InformacionPregunta informacion : informacionPreguntas){
            Modalidad modalidad = informacion.obtenerModalidad();
            Respuesta respuestaCorrecta = informacion.obtenerRespuestaCorrecta();
            String enunciado = informacion.obtenerEnunciado();
            Pregunta preguntaNueva = new Pregunta(modalidad, enunciado, respuestaCorrecta);
            preguntas.add(preguntaNueva);
        }
    }
}