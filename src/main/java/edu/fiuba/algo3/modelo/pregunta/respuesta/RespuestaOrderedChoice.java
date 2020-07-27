package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

public class RespuestaOrderedChoice implements Respuesta {

    @Override
    public EstadisticasRespuesta compararCon(Respuesta otraRespuesta){
        return new EstadisticasRespuesta();
    }

    @Override
    public void rellenar(EnunciadosOpciones enunciadosOpciones){}
}
