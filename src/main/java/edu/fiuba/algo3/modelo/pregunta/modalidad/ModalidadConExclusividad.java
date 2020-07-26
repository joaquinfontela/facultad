package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;

public abstract class ModalidadConExclusividad extends Modalidad {

    @Override
    public void verificarCorrectaBonificacion(Bonificacion bonificacion) throws BonificacionMalColocadaException {
        if (!bonificacion.esExclusividad()) throw new BonificacionMalColocadaException();
    }

    public abstract int calcularPuntos(EstadisticasRespuesta estadisticas);
}