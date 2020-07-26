package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

public class RespuestaVerdaderoFalso implements Respuesta {

    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;

    @Override
    public EstadisticasRespuestas compararCon(Respuesta otraRespuesta) {

        EstadisticasRespuestas estadisticas = new EstadisticasRespuestas();

        RespuestaVerdaderoFalso otraRespuestaVerdaderoFalso = (RespuestaVerdaderoFalso) otraRespuesta;

        if ( this.opcionCorrecta.esLaMismaQue(otraRespuestaVerdaderoFalso.opcionCorrecta) ) {
            estadisticas.sumarCorrectaElegida();

        } else if ( this.opcionIncorrecta.esLaMismaQue(otraRespuestaVerdaderoFalso.opcionCorrecta) ) {
            estadisticas.sumarIncorrectaElegida();

        } else {
            estadisticas.sumarCorrectaNoElegida();
        }

        return estadisticas;
    }

    @Override
    public void rellenar(EnunciadosOpciones opcionesAAgregar) {

        this.opcionCorrecta = new Opcion(opcionesAAgregar.opcionesCorrectas().get(0));
        this.opcionIncorrecta = new Opcion(opcionesAAgregar.opcionesIncorrectas().get(0));

    }
}