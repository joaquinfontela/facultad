package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public abstract class Modalidad {

    protected ArrayList<Bonificacion> bonificacionesAplicadas = new ArrayList<>();

    public void establecerPuntajes(ArrayList<RespuestaDeJugador> respuestasJugadores) {

        for (RespuestaDeJugador respuesta : respuestasJugadores){
            respuesta.calcularPuntosBase(this);
        }
        this.aplicarBonificaciones(respuestasJugadores);
        for (RespuestaDeJugador respuesta : respuestasJugadores){
            respuesta.guardarPuntaje();
        }
    }

    public void recibirBonificacion(Bonificacion bonificacion) {

        try {
            this.verificarCorrectaBonificacion(bonificacion);
            bonificacionesAplicadas.add(bonificacion);
        } catch(BonificacionMalColocadaException exception) {
            System.out.println("Se colocó mal la Bonificación");
        }
    }

    public void aplicarBonificaciones(ArrayList<RespuestaDeJugador> respuestasJugadores) {

        for (Bonificacion bonificacion : bonificacionesAplicadas) {
            bonificacion.aplicar(respuestasJugadores);
        }
    }

    public abstract int calcularPuntos(EstadisticasRespuesta estadisticas);

    public abstract void verificarCorrectaBonificacion(Bonificacion bonificacion) throws BonificacionMalColocadaException;
}