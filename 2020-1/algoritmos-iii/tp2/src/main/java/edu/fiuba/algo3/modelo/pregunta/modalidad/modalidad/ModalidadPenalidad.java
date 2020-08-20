package edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;

public class ModalidadPenalidad extends Modalidad {

    @Override
    public int calcularPuntos(EstadisticasRespuesta estadisticas) {

        return estadisticas.calcularPuntajePenalidadBase();
    }

    @Override
    public boolean sePuedeUsarExclusividad() {
        return false;
    }

    @Override
    protected void verificarCorrectaBonificacion(Bonificacion bonificacion) throws Exception {

        if (bonificacion.esExclusividad()) throw new Exception("No se puede aplicar una exclusividad de puntaje en " +
                "esta pregunta");
    }

    @Override
    public String obtenerNombre() {
        return "Penalidad";
    }
}