package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class Multiplicador implements Bonificacion {

    private int factor;
    private Jugador Duenio;

    public Multiplicador(int factorIngresado, Jugador DuenioIngresado) {

        factor = factorIngresado;
        Duenio = DuenioIngresado;
    }

    @Override
    public void aplicar(ArrayList<RespuestaDeJugador> respuestasJugadores) {
        for (RespuestaDeJugador respuesta : respuestasJugadores) {
            respuesta.multiplicarPuntos(Duenio, factor);
        }
    }

    @Override
    public boolean esExclusividad() {
        return false;
    }
}