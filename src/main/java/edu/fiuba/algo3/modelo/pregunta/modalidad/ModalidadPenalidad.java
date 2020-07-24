package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

public class ModalidadPenalidad extends Modalidad {

    @Override
    public int calcularPuntos(EstadisticasRespuestas estadisticas) {
        return estadisticas.calcularPuntajePenalidadBase();
    }
}