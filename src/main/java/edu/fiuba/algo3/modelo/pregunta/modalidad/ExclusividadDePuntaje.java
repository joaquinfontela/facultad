package edu.fiuba.algo3.modelo.pregunta.modalidad;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import java.util.HashMap;
import java.util.Map;

public class ExclusividadDePuntaje {

    void aplicar(HashMap<Integer, Integer> puntajes){
        int idPosibleCandidato, cantidadDeCandidatos = 0;
        for (Map.Entry<Integer, Integer> entrada : puntajes.entrySet()) {
            if(entrada.getValue() > 0){
                idPosibleCandidato = entrada.getKey();
                cantidadDeCandidatos++;
            }
        }
        if(cantidadDeCandidatos == 1){
            puntajes.put(idPosibleCandidato,puntajes.get(idPosibleCandidato)*2);
        }
    }
}
