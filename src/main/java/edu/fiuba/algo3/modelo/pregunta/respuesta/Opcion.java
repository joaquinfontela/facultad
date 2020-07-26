package edu.fiuba.algo3.modelo.pregunta.respuesta;

public class Opcion {

    private String enunciado;

    public Opcion(String enunciado){
        this.enunciado = enunciado;
    }

    Boolean esLaMismaQue(Opcion opcion) {
        return (this.enunciado.equals(opcion.enunciado));
    }
}