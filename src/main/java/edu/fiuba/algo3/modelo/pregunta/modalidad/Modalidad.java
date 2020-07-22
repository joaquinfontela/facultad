package edu.fiuba.algo3.modelo.pregunta.modalidad;

import java.util.ArrayList;
import java.util.HashMap;

public interface Modalidad {

    HashMap<Integer, Integer> obtenerPuntajesPorJugador(HashMap<Integer, ArrayList<Integer>>);
}
