package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;

public class RespuestaMultipleChoice implements Respuesta{

    private ArrayList<Opcion> opcionesCorrectas;
    private ArrayList<Opcion> opcionesIncorrectas;

    public RespuestaMultipleChoice(){

        opcionesCorrectas = new ArrayList<>();
        opcionesIncorrectas = new ArrayList<>();
    }

    @Override
    public EstadisticasRespuestas compararCon (Respuesta otraRespuesta){

        RespuestaMultipleChoice otraRespuestaMultipleChoice = (RespuestaMultipleChoice) otraRespuesta;
        EstadisticasRespuestas estadisticasRespuestas = new EstadisticasRespuestas();

        estadisticasRespuestas.sumar( compararRespuestasCorrectas( otraRespuestaMultipleChoice ));
        estadisticasRespuestas.sumar( compararRespuestasIncorrectas( otraRespuestaMultipleChoice ));

        return estadisticasRespuestas;
    }


    private EstadisticasRespuestas compararRespuestasCorrectas( RespuestaMultipleChoice otraRespuestaMultipleChoice ) {

        EstadisticasRespuestas estadisticasRespuestas = new EstadisticasRespuestas();

        for (Opcion opcionCorrectaPropia : this.opcionesCorrectas) {

            EstadisticasRespuestas estadisticasRespuestasDeEstaOpcion = new EstadisticasRespuestas();

            if ( laOpcionFueSeleccionadaComoCorrectaEnLaRespuestaRecibida( opcionCorrectaPropia, otraRespuestaMultipleChoice )) {
                estadisticasRespuestas.sumarCorrectaElegida();
            } else {
                estadisticasRespuestas.sumarCorrectaNoElegida();
            }

            estadisticasRespuestas.sumar(estadisticasRespuestasDeEstaOpcion);
        }

        return estadisticasRespuestas;
    }


    private EstadisticasRespuestas compararRespuestasIncorrectas( RespuestaMultipleChoice otraRespuestaMultipleChoice ) {

        EstadisticasRespuestas estadisticasRespuestas = new EstadisticasRespuestas();

        for (Opcion opcionIncorrectaPropia : this.opcionesIncorrectas) {

            EstadisticasRespuestas estadisticasRespuestasDeEstaOpcion = new EstadisticasRespuestas();

            if ( laOpcionFueSeleccionadaComoCorrectaEnLaRespuestaRecibida( opcionIncorrectaPropia, otraRespuestaMultipleChoice )) {
                estadisticasRespuestas.sumarIncorrectaElegida();
            }

            estadisticasRespuestas.sumar(estadisticasRespuestasDeEstaOpcion);
        }

        return estadisticasRespuestas;
    }

    private Boolean laOpcionFueSeleccionadaComoCorrectaEnLaRespuestaRecibida(Opcion opcionPropia,
                                                                             RespuestaMultipleChoice otraRespuestaMultipleChoice){

        return ( otraRespuestaMultipleChoice.opcionesCorrectas.stream()
                 .anyMatch( opcionOtraRespuesta -> opcionOtraRespuesta.esLaMismaQue( opcionPropia )));
                /* esto devuelve si hay una opcion en la lista de opciones correctas de la respuesta recibida,
                 que tenga el mismo enunciado que la opcion recibida.
                 */
    }

    @Override
    public void rellenar(EnunciadosOpciones opcionesParaAgregar) {

        for(Integer i=0; i<(opcionesParaAgregar.opcionesCorrectas()).size();i++) {
            opcionesCorrectas.add(new Opcion(opcionesParaAgregar.opcionesCorrectas().get(i)));
        }
        for(Integer i=0; i<(opcionesParaAgregar.opcionesIncorrectas()).size();i++) {
            opcionesIncorrectas.add(new Opcion(opcionesParaAgregar.opcionesIncorrectas().get(i)));
        }
    }
}
