package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Pregunta {

    private String enunciado;
    protected Respuesta respuestaCorrecta;
    protected Modalidad modalidad;

    Pregunta(Modalidad modalidad, String enunciado){
        this.modalidad = modalidad;
        this.enunciado = enunciado;
    }

    public abstract void mostrarEnunciado();

    public abstract void mostrarOpciones();

    public Respuesta obtenerRespuestaCorrecta(){
        return this.respuestaCorrecta;
    }

    public HashMap<Integer, Integer> obtenerPuntajePorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas){
        HashMap<Integer , EstadisticasRespuestas> idJugador_Estadistica = new HashMap<Integer, EstadisticasRespuestas>();
        for (Map.Entry<Integer, Respuesta> entrada : idsJugadores_respuestas.entrySet()) {
            Respuesta respuestaActual = entrada.getValue();
            if(respuestaActual==null){
                System.out.println("hola");
            }
            Integer idActual = entrada.getKey();
            EstadisticasRespuestas estadisticasRespuestasActual = this.respuestaCorrecta.compararCon(respuestaActual);
            idJugador_Estadistica.put(idActual, estadisticasRespuestasActual);
        }
        return (this.modalidad.obtenerPuntajesPorJugador(idJugador_Estadistica));
    }

}
