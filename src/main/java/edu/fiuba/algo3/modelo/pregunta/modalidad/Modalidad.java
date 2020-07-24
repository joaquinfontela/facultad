package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Modalidad {

    ArrayList<Bonificacion> bonificacionesAplicadas = new ArrayList<Bonificacion>();

    public HashMap<Integer, Integer> obtenerPuntajesPorJugador(HashMap<Integer, EstadisticasRespuestas> diccionarioEstadisticas){
        HashMap<Integer, Integer> puntajes = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, EstadisticasRespuestas> entrada : diccionarioEstadisticas.entrySet()) {
            EstadisticasRespuestas estadisticasActual = entrada.getValue();
            puntajes.put(entrada.getKey(), this.calcularPuntos(estadisticasActual));
        }
        this.aplicarBonificaciones(puntajes);
        return puntajes;
    }

    public void recibirBonificacion(Bonificacion bonificacion) {
        bonificacionesAplicadas.add(bonificacion);
    }

    public void aplicarBonificaciones(HashMap<Integer, Integer> puntajes) {
        for(Bonificacion bonificacion : bonificacionesAplicadas){
            bonificacion.aplicar(puntajes);
        }
    }

    public abstract int calcularPuntos(EstadisticasRespuestas estadisticas);
}

