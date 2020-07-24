package edu.fiuba.algo3.modelo.pregunta.modalidad;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ModalidadConExclusividad extends Modalidad {

    private ArrayList<Bonificacion> exclusividadesAplicadas = new ArrayList<Bonificacion>();

    public void aplicarBonificaciones(HashMap<Integer, Integer> puntajes){
        for(Bonificacion exclusividad : exclusividadesAplicadas){
            exclusividad.aplicar(puntajes);
        }
    }

    public void recibirBonificacion(int id, Bonificacion bonificacion){ //Aca la id es al pedo
        exclusividadesAplicadas.add(bonificacion);
    }
}
