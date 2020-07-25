package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

import java.util.HashMap;
import java.util.Map;

public class Pregunta {

    private String enunciado;
    protected Respuesta respuestaCorrecta;
    protected Modalidad modalidad;

    public Pregunta(Modalidad modalidadIngresada, String enunciadoIngresado, Respuesta respuestaIngresada) {

        modalidad = modalidadIngresada;
        enunciado = enunciadoIngresado;
        respuestaCorrecta = respuestaIngresada;
    }

    public void mostrarEnunciado(){}

    public void mostrarOpciones(){}

    public Respuesta obtenerRespuestaCorrecta() {

        return respuestaCorrecta;
    }

    public HashMap<Integer, Integer> obtenerPuntajePorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas) {

        HashMap<Integer, EstadisticasRespuestas> idJugador_Estadistica = new HashMap<Integer, EstadisticasRespuestas>();
        for (Map.Entry<Integer, Respuesta> entrada : idsJugadores_respuestas.entrySet()) {
            Respuesta respuestaActual = entrada.getValue();
            Integer idActual = entrada.getKey();
            EstadisticasRespuestas estadisticasRespuestasActual = respuestaCorrecta.compararCon(respuestaActual);
            idJugador_Estadistica.put(idActual, estadisticasRespuestasActual);
        }
        return (modalidad.obtenerPuntajesPorJugador(idJugador_Estadistica));
    }

}
