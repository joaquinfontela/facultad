package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

public interface Respuesta {

    public EstadisticasRespuesta compararCon(Respuesta otraRespuesta);

    public void rellenar(EnunciadosOpciones opcionesAagregar);
}