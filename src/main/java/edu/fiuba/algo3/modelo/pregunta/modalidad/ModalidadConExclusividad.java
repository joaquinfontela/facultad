package edu.fiuba.algo3.modelo.pregunta.modalidad;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ModalidadConExclusividad implements Modalidad {

    private ExclusividadDePuntaje exclusividad;

    Boolean seAplicaLaExclusividad(HashMap<Integer, ArrayList<Integer>>){
        return false;
    }
}
