package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Modalidad {

    protected ArrayList<Bonificacion> bonificacionesAplicadas = new ArrayList<Bonificacion>();

    public HashMap<Integer, Integer> obtenerPuntajesPorJugador(HashMap<Integer, EstadisticasRespuesta> diccionarioIdEstadisticas) {

        HashMap<Integer, Integer> puntajes = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, EstadisticasRespuesta> entrada : diccionarioIdEstadisticas.entrySet()) {
            puntajes.put(entrada.getKey(), this.calcularPuntos(entrada.getValue()));
        }
        this.aplicarBonificaciones(puntajes);
        return puntajes;
    }

    public void recibirBonificacion(Bonificacion bonificacion) {

        try {
            this.verificarCorrectaBonificacion(bonificacion);
            bonificacionesAplicadas.add(bonificacion);
        } catch(BonificacionMalColocadaException exception) {
            System.out.println("Se colocó mal la Bonificación");
        }
    }

    public void aplicarBonificaciones(HashMap<Integer, Integer> puntajes) {

        for (Bonificacion bonificacion : bonificacionesAplicadas) {
            bonificacion.aplicar(puntajes);
        }
    }

    public abstract int calcularPuntos(EstadisticasRespuesta estadisticas);

    public abstract void verificarCorrectaBonificacion(Bonificacion bonificacion) throws BonificacionMalColocadaException;
}