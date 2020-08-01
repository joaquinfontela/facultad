package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;

public class RespuestaOrderedChoice implements Respuesta {

    ArrayList<Opcion> opcionesOrdenadas;

    public RespuestaOrderedChoice (){
        opcionesOrdenadas = new ArrayList<Opcion>();
    }

    @Override
    public EstadisticasRespuesta compararCon(Respuesta otraRespuesta){
        EstadisticasRespuesta estadistica = new EstadisticasRespuesta();
        for(int i=0; i< opcionesOrdenadas.size(); i++){
            Opcion opcionPropia = opcionesOrdenadas.get(i);
            Opcion opcionAComparar = ((RespuestaOrderedChoice)otraRespuesta).opcionesOrdenadas.get(i);
            if(!(opcionPropia.esLaMismaQue(opcionAComparar))){
                estadistica.sumarIncorrectaElegida();
                return estadistica;
            }
        }
        estadistica.sumarCorrectaElegida();
        return estadistica;
    }

    @Override
    public void rellenar(EnunciadosOpciones enunciadosOpciones) {
        for( String enunciado : enunciadosOpciones.opcionesOrdenadas()){
            opcionesOrdenadas.add(new Opcion(enunciado));
        }
    }
}