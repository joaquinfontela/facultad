package edu.fiuba.algo3.modelo.pregunta.respuesta;

public class Opcion {

    public String enunciado;

    public Opcion(String enunciado){
        this.enunciado = enunciado;
    }

    Boolean esLaMismaQue(Opcion opcion) {
        return (enunciado.equals(opcion.enunciado));
    }
}