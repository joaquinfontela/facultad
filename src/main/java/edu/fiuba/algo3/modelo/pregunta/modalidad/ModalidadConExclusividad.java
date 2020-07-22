package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ModalidadConExclusividad implements Modalidad {

    private ExclusividadDePuntaje exclusividad;

    protected Boolean seAplicaLaExclusividad(HashMap<Integer, EstadisticasRespuestas> idsJugadores_estadisticasRespuestas){
        return false;
    }
}
