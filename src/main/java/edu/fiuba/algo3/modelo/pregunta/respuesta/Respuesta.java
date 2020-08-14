package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;

public interface Respuesta {

    EstadisticasRespuesta compararCon(Respuesta otraRespuesta);

    void rellenar(EnunciadosOpciones opcionesParaAgregar);

    ArrayList<String> obtenerEnunciadosOpciones();
}