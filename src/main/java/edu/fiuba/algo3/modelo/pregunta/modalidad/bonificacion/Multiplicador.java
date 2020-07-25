package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import java.util.HashMap;

public class Multiplicador implements Bonificacion {

    private int factor;
    private int idDuenio;

    public Multiplicador(int factorIngresado, int idDuenioIngresado){

        factor = factorIngresado;
        idDuenio = idDuenioIngresado;
    }

    @Override
    public void aplicar(HashMap<Integer, Integer> puntajes) {
        puntajes.put(idDuenio, puntajes.get(idDuenio)*factor);
    }

    @Override
    public boolean esExclusividad() {
        return false;
    }
}