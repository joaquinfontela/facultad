package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Respuesta {

    protected ArrayList<Opcion> opciones;

    public abstract EstadisticasRespuestas compararCon(Respuesta otraRespuesta);

    public abstract void rellenar(EnunciadosOpciones opcionesAagregar);
}