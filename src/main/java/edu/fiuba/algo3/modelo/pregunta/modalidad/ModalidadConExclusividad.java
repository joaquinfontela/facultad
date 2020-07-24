package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ModalidadConExclusividad extends Modalidad {

    private ArrayList<Bonificacion> exclusividadesAplicadas = new ArrayList<Bonificacion>();

    public void aplicarBonificaciones(HashMap<Integer, Integer> puntajes){
        for(Bonificacion exclusividad : exclusividadesAplicadas){
            exclusividad.aplicar(puntajes);
        }
    }

    public void recibirBonificacion(int id, Bonificacion bonificacion){
        exclusividadesAplicadas.add(bonificacion);
    }
}
