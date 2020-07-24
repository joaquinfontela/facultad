package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ModalidadConExclusividad extends Modalidad {

    private ArrayList<ExclusividadDePuntaje> exclusividadesAplicadas = new ArrayList<ExclusividadDePuntaje>();

    public void aplicarBonificaciones(HashMap<Integer, Integer> puntajes){
        for(ExclusividadDePuntaje exclusividad : this.exclusividadesAplicadas){
            exclusividad.aplicar(puntajes);
        }
    }
}
