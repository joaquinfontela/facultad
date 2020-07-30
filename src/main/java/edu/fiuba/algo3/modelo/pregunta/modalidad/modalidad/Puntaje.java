package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Puntaje {

    private Jugador duenio;
    private int puntosParaAplicar;

    public Puntaje(Jugador jugador, int puntosIngresados) {

        duenio = jugador;
        puntosParaAplicar = puntosIngresados;
    }

    public void multiplicarPuntos(Jugador jugador, int factor) {

        if (duenio == jugador) this.aplicarMultiplicacion(factor);
    }

    public void aplicarMultiplicacion(int factor) {
        puntosParaAplicar *= factor;
    }

    public boolean consigioPuntos() {
        return (puntosParaAplicar > 0);
    }

    public void guardarPuntaje() {
        duenio.sumarPuntos(puntosParaAplicar);
    }
}
