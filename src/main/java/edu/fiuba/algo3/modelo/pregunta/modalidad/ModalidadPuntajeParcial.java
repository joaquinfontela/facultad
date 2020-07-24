package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

public class ModalidadPuntajeParcial extends ModalidadConExclusividad {

    @Override
    public int calcularPuntos(EstadisticasRespuestas estadisticas) {
        if(estadisticas.hayOpcionesIncorrectas()){
            return 0;
        }
        return estadisticas.obtenerOpcionesCorrectasElegidas();
    }
}
