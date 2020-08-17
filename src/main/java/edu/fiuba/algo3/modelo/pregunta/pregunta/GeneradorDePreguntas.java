package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.Random;

public class GeneradorDePreguntas {

    private ArrayList<Pregunta> preguntas;
    private Random randomizador;

    public GeneradorDePreguntas(ArrayList<InformacionPregunta> informacionPreguntas) {

        preguntas = new ArrayList<>();
        randomizador = new Random();
        generarTodasLasPreguntas(informacionPreguntas);
    }

    private void generarTodasLasPreguntas(ArrayList<InformacionPregunta> informacionPreguntas) {

        for (InformacionPregunta informacion : informacionPreguntas){
            Modalidad modalidad = informacion.obtenerModalidad();
            Respuesta respuestaCorrecta = informacion.obtenerRespuestaCorrecta();
            String enunciado = informacion.obtenerEnunciado();
            Pregunta preguntaNueva = new Pregunta(modalidad, enunciado, respuestaCorrecta);
            preguntas.add(preguntaNueva);
        }
    }

    public Pregunta obtenerNuevaPregunta(){

        int indiceRandom = randomizador.nextInt(preguntas.size());
        Pregunta preguntaNueva = preguntas.get(indiceRandom);
        preguntas.remove(indiceRandom);
        return preguntaNueva;
    }
}