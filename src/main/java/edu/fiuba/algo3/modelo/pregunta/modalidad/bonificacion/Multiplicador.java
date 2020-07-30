package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Puntaje;

import java.util.ArrayList;

public class Multiplicador implements Bonificacion {

    private int factor;
    private Jugador Duenio;

    public Multiplicador(int factorIngresado, Jugador DuenioIngresado) {

        factor = factorIngresado;
        Duenio = DuenioIngresado;
    }

    @Override
    public void aplicar(ArrayList<Puntaje> puntajes) {

        for (Puntaje puntaje : puntajes) {
            puntaje.multiplicarPuntos(Duenio, factor);
        }
    }

    @Override
    public boolean esExclusividad() {
        return false;
    }
}