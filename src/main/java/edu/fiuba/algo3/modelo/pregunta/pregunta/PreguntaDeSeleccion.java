package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Opcion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.OpcionElegible;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

public abstract class PreguntaDeSeleccion extends Pregunta {

    private ArrayList<String> enunciadosCorrectos;
    private ArrayList<String> enunciadosIncorrectos;

    PreguntaDeSeleccion(Modalidad modalidad, String enunciado, ArrayList<String> enunciadosCorrectos,
                        ArrayList<String> enunciadosIncorrectos){
        super(modalidad, enunciado);
        this.enunciadosCorrectos = enunciadosCorrectos;
        this.enunciadosIncorrectos = enunciadosIncorrectos;
    }

    protected void inicializarOpcionesRespuestaCorrecta(){
        Integer id = 1;
        for ( String enunciadoCorrecto : this.enunciadosCorrectos ) {
            OpcionElegible opcionCorrecta = new OpcionElegible(id, enunciadoCorrecto);
            opcionCorrecta.elegir();
            this.respuestaCorrecta.agregarOpcion(opcionCorrecta);
            id++;
        }
        for ( String enunciadoIncorrecto : this.enunciadosIncorrectos ) {
            OpcionElegible opcionIncorrecta = new OpcionElegible(id, enunciadoIncorrecto);
            this.respuestaCorrecta.agregarOpcion(opcionIncorrecta);
            id++;
        }
    }


    @Override
    public void mostrarEnunciado() {}

    @Override
    public void mostrarOpciones() {}

    @Override
    public HashMap<Integer, ArrayList<Integer>> obtenerCantidadDeRespuestasCorrectasEIncorrectasPorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas) {
        return new HashMap<Integer, ArrayList<Integer>>();
    }
}


