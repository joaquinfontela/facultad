package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Puntaje {

    private Jugador duenio;
    private int puntosParaAplicar;

    public Puntaje(Jugador jugador, int puntosIngresados) {

        duenio = jugador;
        puntosParaAplicar = puntosIngresados;
    }

    public void multiplicar(Jugador jugador, int factor) {

        if (duenio == jugador) this.multiplicar(factor);
    }

    public void multiplicar(int factor) {
        puntosParaAplicar *= factor;
    }

    public boolean consigioPuntos() {
        return (puntosParaAplicar > 0);
    }

    public void guardarPuntaje() {
        duenio.sumarPuntos(puntosParaAplicar);
    }
}
