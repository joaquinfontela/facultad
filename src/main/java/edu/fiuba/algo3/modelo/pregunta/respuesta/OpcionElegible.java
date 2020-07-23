package edu.fiuba.algo3.modelo.pregunta.respuesta;

public class OpcionElegible extends Opcion {

    Boolean elegida;

    public OpcionElegible(Integer id, String enunciado){

        super(id, enunciado);
        this.elegida = false;
    }

    @Override
    Boolean esIgualA(Opcion opcion) {
        return (this.id == opcion.id);
    }

    public void elegir(){
        this.elegida = true;
    }
}
