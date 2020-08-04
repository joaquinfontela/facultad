package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Bonificacion;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.BonificacionMalColocadaException;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.MismoDuenioEnDosBonificacionesException;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class Pregunta {

    private String enunciado;
    private Respuesta respuestaCorrecta;
    private Modalidad modalidad;

    public Pregunta(Modalidad modalidadIngresada, String enunciadoIngresado, Respuesta respuestaIngresada) {

        modalidad = modalidadIngresada;
        enunciado = enunciadoIngresado;
        respuestaCorrecta = respuestaIngresada;
    }

    public void mostrarEnunciado() { }

    public void mostrarOpciones() { }

    public Respuesta obtenerRespuestaCorrecta() {

        return respuestaCorrecta;
    }

    public void evaluarRespuestas(ArrayList<RespuestaDeJugador> respuestasJugadores){

        for (RespuestaDeJugador respuesta : respuestasJugadores) {
            respuesta.generarEstadisticasRespuesta(respuestaCorrecta);
        }
        modalidad.establecerPuntajes(respuestasJugadores);
    }

    public void recibirBonificacion(Bonificacion bonificacion){

        try {
            modalidad.verificarCorrectaBonificacion(bonificacion);
            modalidad.verificarBonificacionConDistintoDuenio(bonificacion);
            modalidad.recibirBonificacion(bonificacion);
        } catch (BonificacionMalColocadaException exception) {
            System.out.println("Se colocó mal la Bonificación");
        } catch (MismoDuenioEnDosBonificacionesException exception) {
            System.out.println("No se pueden recibir 2 bonificaciones del mismo duenio");
        }
    }
}