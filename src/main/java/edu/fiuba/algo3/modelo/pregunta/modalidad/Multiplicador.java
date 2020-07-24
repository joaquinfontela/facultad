package edu.fiuba.algo3.modelo.pregunta.modalidad;

import java.util.HashMap;

public class Multiplicador implements Bonificacion{

    int factor;
    int idDuenio;

    public void Multiplicador(int factorIngresado, int idDuenioIngresado){
        factor = factorIngresado;
        idDuenio = idDuenioIngresado;
    }

    @Override
    public void aplicar(HashMap<Integer, Integer> puntajes) {
        puntajes.put(idDuenio, puntajes.get(idDuenio)*factor);
    }
}
