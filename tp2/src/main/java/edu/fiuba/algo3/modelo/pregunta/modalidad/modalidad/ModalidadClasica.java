package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;

public class ModalidadClasica extends ModalidadConExclusividad {

    @Override
    public int calcularPuntos(EstadisticasRespuesta estadisticas) {

        if (estadisticas.hayOpcionesIncorrectas() || estadisticas.hayOpcionesCorrectasNoElegidas()) {
            return 0;
        }
        return 1;
    }

    @Override
    public String obtenerNombre() {
        return "Clásico";
    }
}