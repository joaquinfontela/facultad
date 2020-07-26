package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

public class RespuestaVerdaderoFalso implements Respuesta {

    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;

    @Override
    public EstadisticasRespuesta compararCon(Respuesta otraRespuesta) {

        EstadisticasRespuesta estadisticas = new EstadisticasRespuesta();

        RespuestaVerdaderoFalso otraRespuestaVerdaderoFalso = (RespuestaVerdaderoFalso) otraRespuesta;

        if (opcionCorrecta.esLaMismaQue(otraRespuestaVerdaderoFalso.opcionCorrecta)) {
            estadisticas.sumarCorrectaElegida();

        } else if (opcionIncorrecta.esLaMismaQue(otraRespuestaVerdaderoFalso.opcionCorrecta)) {
            estadisticas.sumarIncorrectaElegida();

        } else {
            estadisticas.sumarCorrectaNoElegida();
        }

        return estadisticas;
    }

    @Override
    public void rellenar(EnunciadosOpciones opcionesParaAgregar) {

        opcionCorrecta = new Opcion(opcionesParaAgregar.opcionesCorrectas().get(0));
        opcionIncorrecta = new Opcion(opcionesParaAgregar.opcionesIncorrectas().get(0));
    }
}