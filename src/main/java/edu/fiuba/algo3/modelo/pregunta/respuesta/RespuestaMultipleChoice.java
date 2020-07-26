package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;

public class RespuestaMultipleChoice implements Respuesta{

    private ArrayList<Opcion> opcionesCorrectas;
    private ArrayList<Opcion> opcionesIncorrectas;

    public RespuestaMultipleChoice(){

        opcionesCorrectas = new ArrayList<>();
        opcionesIncorrectas = new ArrayList<>();
    }

    @Override
    public EstadisticasRespuestas compararCon(Respuesta otraRespuesta) {

        EstadisticasRespuestas estadisticas = new EstadisticasRespuestas();
        RespuestaMultipleChoice respuestaMC = (RespuestaMultipleChoice) otraRespuesta;
        return estadisticas;

    }

    @Override
    public void rellenar(EnunciadosOpciones opcionesParaAgregar) {

        for(Integer i=0; i<(opcionesParaAgregar.opcionesCorrectas()).size();i++) {
            opcionesCorrectas.add(new Opcion(opcionesParaAgregar.opcionesCorrectas().get(i)));
        }
        for(Integer i=0; i<(opcionesParaAgregar.opcionesIncorrectas()).size();i++) {
            opcionesIncorrectas.add(new Opcion(opcionesParaAgregar.opcionesIncorrectas().get(i)));
        }
    }
}
