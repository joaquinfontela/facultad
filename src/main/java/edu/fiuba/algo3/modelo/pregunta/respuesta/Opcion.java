package edu.fiuba.algo3.modelo.pregunta.respuesta;

public abstract class Opcion {

    protected Integer id;
    private String enunciado;

    public Opcion(Integer id, String enunciado){

        this.id = id;
        this.enunciado = enunciado;
    }

    Boolean tieneElMismoIdQue(Opcion opcion) {
        return (this.id == opcion.id);
    }

    public abstract EstadisticasRespuestas compararCon(Opcion otraOpcion);
}
