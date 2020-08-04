package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Puntaje;

import java.util.ArrayList;

public class Multiplicador implements Bonificacion {

    private int factor;
    private Jugador duenio;

    public Multiplicador(int factorIngresado, Jugador DuenioIngresado) {

        factor = factorIngresado;
        duenio = DuenioIngresado;
    }

    @Override
    public void aplicar(ArrayList<Puntaje> puntajes) {

        for (Puntaje puntaje : puntajes) {
            puntaje.multiplicar(duenio, factor);
        }
    }

    @Override
    public boolean esExclusividad() {
        return false;
    }

    @Override
    public boolean tieneMismoDuenio(Bonificacion otraBonificacion) {

        Multiplicador otroMultiplicador = (Multiplicador) otraBonificacion;
        return (this.duenio == otroMultiplicador.duenio);
    }
}