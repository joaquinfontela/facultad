package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import java.util.HashMap;

public interface Bonificacion {

    void aplicar(HashMap<Integer, Integer> puntajes);

    boolean esExclusividad();
}