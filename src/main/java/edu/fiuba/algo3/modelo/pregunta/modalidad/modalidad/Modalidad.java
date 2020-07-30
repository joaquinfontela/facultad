package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public abstract class Modalidad {

    protected ArrayList<Bonificacion> bonificacionesAplicadas;

    public Modalidad(){
        bonificacionesAplicadas = new ArrayList<>();
    }

    public void establecerPuntajes(ArrayList<RespuestaDeJugador> respuestasJugadores) {

        ArrayList<Puntaje> puntajes = new ArrayList<>();
        for (RespuestaDeJugador respuesta : respuestasJugadores){
            int puntos = this.calcularPuntos(respuesta.obtenerEstadisticasRespuesta());
            puntajes.add(new Puntaje(respuesta.obtenerDuenio(), puntos));
        }
        this.aplicarBonificaciones(puntajes);
        this.guardarPuntajes(puntajes);
    }

    public void recibirBonificacion(Bonificacion bonificacion) {

        try {
            this.verificarCorrectaBonificacion(bonificacion);
            bonificacionesAplicadas.add(bonificacion);
        } catch(BonificacionMalColocadaException exception) {
            System.out.println("Se colocó mal la Bonificación");
        }
    }

    public void aplicarBonificaciones(ArrayList<Puntaje> puntajes) {

        for (Bonificacion bonificacion : bonificacionesAplicadas) {
            bonificacion.aplicar(puntajes);
        }
        bonificacionesAplicadas.clear();
    }

    public void guardarPuntajes(ArrayList<Puntaje> puntajes){

        for (Puntaje puntaje : puntajes){
            puntaje.guardarPuntaje();
        }
    }

    public abstract int calcularPuntos(EstadisticasRespuesta estadisticas);

    public abstract void verificarCorrectaBonificacion(Bonificacion bonificacion) throws BonificacionMalColocadaException;
}