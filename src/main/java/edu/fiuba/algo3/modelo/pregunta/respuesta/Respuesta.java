package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;

public abstract class Respuesta {

    ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    Respuesta(){
        this.opciones = new ArrayList<Opcion>();
    }

    public abstract EstadisticasRespuestas compararCon(Respuesta otraRespuesta);

    public void agregarOpcion(Opcion opcion){
        this.opciones.add(opcion);
    }
}
