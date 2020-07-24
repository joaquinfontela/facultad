package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import java.util.HashMap;
import java.util.Map;

public class ModalidadClasica extends ModalidadConExclusividad {

    public int calcularPuntos(EstadisticasRespuestas estadisticas){
        if(estadisticas.hayOpcionesIncorrectas() || estadisticas.hayOpcionesCorrectasNoElegidas()){
            return 0;
        }
        return 1;
    }
}
