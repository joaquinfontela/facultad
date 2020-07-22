package edu.fiuba.algo3.modelo.pregunta.respuesta;

public class OpcionElegible extends Opcion {

    public OpcionElegible(String enunciado){

        super(enunciado);
    }

    Boolean esIgualA(Opcion opcion){
        return true;
    }
}
