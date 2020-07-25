package edu.fiuba.algo3.modelo.pregunta.respuesta;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Respuesta {

    protected ArrayList<Opcion> opciones;

    public abstract EstadisticasRespuestas compararCon(Respuesta otraRespuesta);

    public void agregarOpcion(Opcion opcion){
        this.opciones.add(opcion);
    }

    public void rellenar(HashMap<String,Integer> opcionesAagregar){}
}
