package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.ModalidadPuntajeParcial;
import edu.fiuba.algo3.modelo.pregunta.respuesta.*;

import java.util.HashMap;

public class InformacionPregunta {
    private Modalidad modalidad;
    private Respuesta respuestaCorrecta;
    private String enunciado;

    private HashMap<Integer, Respuesta> id_TipoDeRespuesta;
    private HashMap<Integer, Modalidad> id_Modalidad;

    public InformacionPregunta(int tipoModalidad, int tipoPregunta, String enunciadoAasignar, EnunciadosOpciones opciones) {

        id_TipoDeRespuesta = new HashMap<>();
        id_TipoDeRespuesta.put(1, new RespuestaVerdaderoFalso());
        id_TipoDeRespuesta.put(2, new RespuestaMultipleChoice());
        id_TipoDeRespuesta.put(3, new RespuestaGroupChoice());
        id_TipoDeRespuesta.put(4, new RespuestaOrderedChoice());

        id_Modalidad = new HashMap<>();
        id_Modalidad.put(1, new ModalidadClasica());
        id_Modalidad.put(2, new ModalidadPenalidad());
        id_Modalidad.put(3, new ModalidadPuntajeParcial());

        respuestaCorrecta = id_TipoDeRespuesta.get(tipoPregunta);
        respuestaCorrecta.rellenar(opciones);

        modalidad = id_Modalidad.get(tipoModalidad);
        enunciado = enunciadoAasignar;
    }

    Modalidad obtenerModalidad() {
        return modalidad;
    }
    Respuesta obtenerRespuestaCorrecta(){
        return respuestaCorrecta;
    }
    String obtenerEnunciado(){
        return enunciado;
    }
}
