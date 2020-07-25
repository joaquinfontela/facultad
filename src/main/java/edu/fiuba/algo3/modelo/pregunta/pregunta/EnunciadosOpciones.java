package edu.fiuba.algo3.modelo.pregunta.pregunta;

import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnunciadosOpciones {
    HashMap<Integer, ArrayList<String>> opciones;

    public EnunciadosOpciones(){
        opciones=new HashMap<Integer, ArrayList<String>>();
    }

    public ArrayList<String> opcionesCorrectas(){
        return opciones.get(1);
    }

    public ArrayList<String> opcionesIncorrectas(){
        return opciones.get(0);
    }

    public ArrayList<String> opcionesGrupoA(){
        return opciones.get(0);
    }

    public ArrayList<String> opcionesGrupoB(){
        return opciones.get(1);
    }

    public ArrayList<String> opcionesOrdenadas(){

        ArrayList<String> enunciadosOrdenados = new ArrayList<>();
        for (Integer i=0; i < opciones.size();i++){
            enunciadosOrdenados.add(opciones.get(i).get(0));
        }
        return enunciadosOrdenados;
    }
}
