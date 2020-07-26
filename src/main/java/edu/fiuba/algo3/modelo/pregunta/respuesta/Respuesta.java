package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

public interface Respuesta {

    EstadisticasRespuesta compararCon(Respuesta otraRespuesta);

    void rellenar(EnunciadosOpciones opcionesAagregar);
}