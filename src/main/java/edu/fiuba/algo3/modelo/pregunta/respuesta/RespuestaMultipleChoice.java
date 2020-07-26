package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;

public class RespuestaMultipleChoice implements Respuesta{

    private ArrayList<Opcion> opcionesCorrectas;
    private ArrayList<Opcion> opcionesIncorrectas;

    public RespuestaMultipleChoice(){
        this.opcionesCorrectas = new ArrayList<>();
        this.opcionesIncorrectas = new ArrayList<>();
    }
    @Override
    public EstadisticasRespuestas compararCon (Respuesta otraRespuesta ){

        EstadisticasRespuestas estadisticas = new EstadisticasRespuestas();
        RespuestaMultipleChoice respuestaMC = (RespuestaMultipleChoice) otraRespuesta;


    }
    @Override
    public void rellenar(EnunciadosOpciones opcionesAagregar){
        for(Integer i=0; i<(opcionesAagregar.opcionesCorrectas()).size();i++){
            this.opcionesCorrectas.add(new Opcion(opcionesAagregar.opcionesCorrectas().get(i)));
        }
        for(Integer i=0; i<(opcionesAagregar.opcionesIncorrectas()).size();i++) {
            this.opcionesIncorrectas.add(new Opcion(opcionesAagregar.opcionesIncorrectas().get(i)));
        }
    }
}
