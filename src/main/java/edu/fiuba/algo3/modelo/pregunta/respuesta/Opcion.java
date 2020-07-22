package edu.fiuba.algo3.modelo.pregunta.respuesta;

public abstract class Opcion {

    private static Integer proximoId = 1;

    private Integer id;
    private String enunciado;

    public Opcion(String enunciado){

        this.id = this.proximoId;
        this.proximoId++;

        this.enunciado = enunciado;
    }

    abstract Boolean esIgualA(Opcion opcion);
}
