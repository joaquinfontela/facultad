package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class Multiplicador implements Bonificacion {

    private int factor;
    private int idDuenio;

    public Multiplicador(int factorIngresado, int idDuenioIngresado) {

        factor = factorIngresado;
        idDuenio = idDuenioIngresado;
    }

    @Override
    public void aplicar(ArrayList<RespuestaDeJugador> respuestasJugadores) {
        for (RespuestaDeJugador respuesta : respuestasJugadores) {
            respuesta.multiplicarPuntos(idDuenio, factor);
        }
    }

    @Override
    public boolean esExclusividad() {
        return false;
    }
}