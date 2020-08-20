package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Puntaje;

import java.util.ArrayList;

public interface Bonificacion {

    void aplicar(ArrayList<Puntaje> puntajes);

    boolean esExclusividad();

    boolean tieneMismoDuenio(Bonificacion otraBonificacion);
}