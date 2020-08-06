package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;

public class ModalidadPenalidad extends Modalidad {

    @Override
    public int calcularPuntos(EstadisticasRespuesta estadisticas) {

        return estadisticas.calcularPuntajePenalidadBase();
    }

    @Override
    public void verificarCorrectaBonificacion(Bonificacion bonificacion) throws BonificacionMalColocadaException {

        if (bonificacion.esExclusividad()) throw new BonificacionMalColocadaException();
    }
}