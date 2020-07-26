package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;
import java.util.HashMap;

public interface Respuesta {

    public EstadisticasRespuestas compararCon(Respuesta otraRespuesta);

    public void rellenar(EnunciadosOpciones opcionesAagregar);
}