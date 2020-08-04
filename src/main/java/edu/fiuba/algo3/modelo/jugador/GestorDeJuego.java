package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.pregunta.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.pregunta.InformacionPregunta;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;

import java.util.ArrayList;

public class GestorDeJuego {

    private ArrayList<Jugador> jugadores;
    private int rondaActual;
    private GeneradorDePreguntas generadorDePreguntas;
    private Pregunta preguntaActual;

    public GestorDeJuego(ArrayList<InformacionPregunta> informacionPreguntas, ArrayList<Jugador> jugadoresIngresados) {

        jugadores = jugadoresIngresados;
        rondaActual = 0;
        generadorDePreguntas = new GeneradorDePreguntas(informacionPreguntas);
    }

    public void ComenzarNuevaRonda() {

        preguntaActual = generadorDePreguntas.obtenerNuevaPregunta();
        rondaActual++;
    }
}
