package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

public class ModalidadClasica extends Modalidad {

    @Override
    public int calcularPuntos(EstadisticasRespuestas estadisticas){

        if(estadisticas.hayOpcionesIncorrectas() || estadisticas.hayOpcionesCorrectasNoElegidas()){
            return 0;
        }
        return 1;
    }
}