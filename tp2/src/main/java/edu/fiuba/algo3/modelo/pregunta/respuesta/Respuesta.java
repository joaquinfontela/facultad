package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;

public abstract class Respuesta {

    public abstract EstadisticasRespuesta compararCon(Respuesta otraRespuesta);

    public abstract void rellenar(EnunciadosOpciones opcionesParaAgregar);

    public abstract ArrayList<String> obtenerEnunciadosOpciones();

    public abstract Respuesta crearRespuestaComparable();

    public boolean esTipoDeRespuestaComparable(Class clase) {
        return clase == this.getClass();
    }
}