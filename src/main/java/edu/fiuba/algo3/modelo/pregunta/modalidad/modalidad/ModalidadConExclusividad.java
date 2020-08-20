package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;

public abstract class ModalidadConExclusividad extends Modalidad {

    @Override
    protected void verificarCorrectaBonificacion(Bonificacion bonificacion) throws Exception {

        if (!bonificacion.esExclusividad()) throw new Exception("No se puede aplicar un multiplicador en esta pregunta");
    }

    @Override
    public boolean sePuedeUsarExclusividad() {
        return true;
    }

    public abstract int calcularPuntos(EstadisticasRespuesta estadisticas);

    public abstract String obtenerNombre();
}