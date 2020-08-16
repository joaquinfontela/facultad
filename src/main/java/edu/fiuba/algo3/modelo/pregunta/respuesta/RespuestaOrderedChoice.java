package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;

public class RespuestaOrderedChoice extends Respuesta {

    ArrayList<Opcion> opcionesOrdenadas;

    public RespuestaOrderedChoice(){
        opcionesOrdenadas = new ArrayList<>();
    }

    @Override
    public EstadisticasRespuesta compararCon(Respuesta otraRespuesta){

        EstadisticasRespuesta estadistica = new EstadisticasRespuesta();
        for (int i = 0; i < opcionesOrdenadas.size(); i++) {
            Opcion opcionPropia = opcionesOrdenadas.get(i);
            Opcion opcionAComparar = ((RespuestaOrderedChoice)otraRespuesta).opcionesOrdenadas.get(i);
            if (!(opcionPropia.esLaMismaQue(opcionAComparar))) {
                estadistica.sumarIncorrectaElegida();
                return estadistica;
            }
        }
        estadistica.sumarCorrectaElegida();
        return estadistica;
    }

    @Override
    public void rellenar(EnunciadosOpciones enunciadosOpciones) {

        for (String enunciado : enunciadosOpciones.enunciadosOrdenados()){
            opcionesOrdenadas.add(new Opcion(enunciado));
        }
    }

    @Override
    public ArrayList<String> obtenerEnunciadosOpciones() {

        ArrayList<String> enunciadosOpciones = new ArrayList<>();
        for(Opcion opcion : opcionesOrdenadas) {
            enunciadosOpciones.add(opcion.obtenerEnunciado());
        }
        return enunciadosOpciones;
    }

    @Override
    public Respuesta crearRespuestaComparable() {
        return new RespuestaOrderedChoice();
    }
}