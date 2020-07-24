package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import java.util.HashMap;
import java.util.Map;

public class ModalidadPenalidad extends Modalidad {

    HashMap<Integer, Bonificacion> multiplicadoresAplicados = new HashMap<Integer, Bonificacion>();

    @Override
    public int calcularPuntos(EstadisticasRespuestas estadisticas) {
        return estadisticas.calcularPuntajePenalidadBase();
    }

    @Override
    public void recibirBonificacion(int id, Bonificacion bonificacion) {
        multiplicadoresAplicados.put(id, bonificacion);
    }

    @Override
    public void aplicarBonificaciones(HashMap<Integer, Integer> puntajes) {
        for (int clave : puntajes.keySet()) {
            Bonificacion bonificacion = multiplicadoresAplicados.get(clave);
            if(bonificacion != null) bonificacion.aplicar(puntajes);
        }
    }
}
