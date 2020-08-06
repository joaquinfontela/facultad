package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;

public abstract class ModalidadConExclusividad extends Modalidad {

    @Override
    public void verificarCorrectaBonificacion(Bonificacion bonificacion) throws Exception {

        if (!bonificacion.esExclusividad()) throw new Exception();
    }

    public abstract int calcularPuntos(EstadisticasRespuesta estadisticas);
}