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

    public void recibirBonificacion(Bonificacion bonificacion) throws Exception {

        this.verificarCorrectaBonificacion(bonificacion);
        this.verificarBonificacionConDistintoDuenio(bonificacion);
        bonificacionesAplicadas.add(bonificacion);
    }

    public void aplicarBonificaciones(ArrayList<Puntaje> puntajes) {

        for (Bonificacion bonificacion : bonificacionesAplicadas) {
            bonificacion.aplicar(puntajes);
        }
    }

    private void verificarBonificacionConDistintoDuenio(Bonificacion nuevaBonificacion) throws Exception {

        for (Bonificacion bonificacion : bonificacionesAplicadas) {
            if (bonificacion.tieneMismoDuenio(nuevaBonificacion)) {
                throw new Exception("El jugador ya aplicó una bonificación en esta pregunta");
            }
        }
    }

    public void guardarPuntajes(ArrayList<Puntaje> puntajes){
        for (Puntaje puntaje : puntajes) puntaje.guardar();
    }

    public abstract int calcularPuntos(EstadisticasRespuesta estadisticas);

    protected abstract void verificarCorrectaBonificacion(Bonificacion bonificacion) throws Exception;

    public abstract boolean sePuedeUsarExclusividad();
}