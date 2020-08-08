package edu.fiuba.algo3.modelo.pregunta.respuesta;

public class Opcion {

    private String enunciado;

    public Opcion(String enunciadoIngresado){
        enunciado = enunciadoIngresado;
    }

    boolean equals(Opcion otraOpcion) {
        return enunciado.equals(otraOpcion.enunciado);
    }

    boolean esLaMismaQue(Opcion opcion) {
        return (enunciado.equals(opcion.enunciado));
    }
}