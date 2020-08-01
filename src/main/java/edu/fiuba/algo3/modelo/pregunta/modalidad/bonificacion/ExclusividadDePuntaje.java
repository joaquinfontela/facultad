package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Puntaje;

import java.util.ArrayList;

public class ExclusividadDePuntaje implements Bonificacion {

    @Override
    //solo se aplica si uno no puntua y el otro si (aunque sea parcialmente)
    public void aplicar(ArrayList<Puntaje> puntajes) {

        Puntaje puntajePosibleCandidato = null;
        int cantidadCandidatos = 0;
        for (Puntaje puntaje : puntajes) {
            if (puntaje.consigioPuntos()) {
                puntajePosibleCandidato = puntaje;
                cantidadCandidatos++;
            }
        }
        if (cantidadCandidatos == 1) {
            puntajePosibleCandidato.multiplicar(2);
        }
    }

    @Override
    public boolean esExclusividad() {
        return true;
    }
}