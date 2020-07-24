package edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion;

import java.util.HashMap;
import java.util.Map;

public class ExclusividadDePuntaje implements Bonificacion {

    @Override
    //solo se aplica si uno no puntua y el otro si (aunque sea parcialmente)
    public void aplicar(HashMap<Integer, Integer> puntajes){
        int idPosibleCandidato = 0;
        int cantidadDeCandidatos = 0;
        for (Map.Entry<Integer, Integer> entrada : puntajes.entrySet()) {
            if(entrada.getValue() > 0){
                idPosibleCandidato = entrada.getKey();
                cantidadDeCandidatos++;
            }
        }
        if(cantidadDeCandidatos == 1){
            puntajes.put(idPosibleCandidato, puntajes.get(idPosibleCandidato)*2);
        }
    }
}