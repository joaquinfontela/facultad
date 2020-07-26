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
    public EstadisticasRespuesta compararCon (Respuesta otraRespuesta){

        RespuestaMultipleChoice otraRespuestaMultipleChoice = (RespuestaMultipleChoice) otraRespuesta;
        EstadisticasRespuesta estadisticasRespuesta = new EstadisticasRespuesta();

        estadisticasRespuesta.sumar( compararRespuestasCorrectas( otraRespuestaMultipleChoice ));
        estadisticasRespuesta.sumar( compararRespuestasIncorrectas( otraRespuestaMultipleChoice ));

        return estadisticasRespuesta;
    }


    private EstadisticasRespuesta compararRespuestasCorrectas(RespuestaMultipleChoice otraRespuestaMultipleChoice ) {

        EstadisticasRespuesta estadisticasRespuesta = new EstadisticasRespuesta();

        for (Opcion opcionCorrectaPropia : this.opcionesCorrectas) {

            EstadisticasRespuesta estadisticasRespuestaDeEstaOpcion = new EstadisticasRespuesta();

            if ( laOpcionFueSeleccionadaComoCorrectaEnLaRespuestaRecibida( opcionCorrectaPropia, otraRespuestaMultipleChoice )) {
                estadisticasRespuesta.sumarCorrectaElegida();
            } else {
                estadisticasRespuesta.sumarCorrectaNoElegida();
            }

            estadisticasRespuesta.sumar(estadisticasRespuestaDeEstaOpcion);
        }

        return estadisticasRespuesta;
    }


    private EstadisticasRespuesta compararRespuestasIncorrectas(RespuestaMultipleChoice otraRespuestaMultipleChoice ) {

        EstadisticasRespuesta estadisticasRespuesta = new EstadisticasRespuesta();

        for (Opcion opcionIncorrectaPropia : this.opcionesIncorrectas) {

            EstadisticasRespuesta estadisticasRespuestaDeEstaOpcion = new EstadisticasRespuesta();

            if ( laOpcionFueSeleccionadaComoCorrectaEnLaRespuestaRecibida( opcionIncorrectaPropia, otraRespuestaMultipleChoice )) {
                estadisticasRespuesta.sumarIncorrectaElegida();
            }

            estadisticasRespuesta.sumar(estadisticasRespuestaDeEstaOpcion);
        }

        return estadisticasRespuesta;
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
