package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

public class VerdaderoFalso extends PreguntaDeSeleccion {

    public VerdaderoFalso(Modalidad modalidad, String enunciado, ArrayList<String> opcionesCorrectas,
                   ArrayList<String> opcionesIncorrectas){

    }

    @Override
    public HashMap<Integer, Integer> obtenerPuntajePorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas){
        return new HashMap<Integer, Integer>();
    }
}
