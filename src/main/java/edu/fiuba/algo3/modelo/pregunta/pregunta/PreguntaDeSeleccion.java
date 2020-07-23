package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Opcion;
import edu.fiuba.algo3.modelo.pregunta.respuesta.OpcionElegible;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

public abstract class PreguntaDeSeleccion extends Pregunta {

    protected ArrayList<String> enunciadosCorrectos;
    protected ArrayList<String> enunciadosIncorrectos;

    PreguntaDeSeleccion(Modalidad modalidad, String enunciado, ArrayList<String> enunciadosCorrectos,
                        ArrayList<String> enunciadosIncorrectos){
        super(modalidad, enunciado);
        this.enunciadosCorrectos = enunciadosCorrectos;
        this.enunciadosIncorrectos = enunciadosIncorrectos;
    }

    @Override
    public void mostrarEnunciado() {}

    @Override
    public void mostrarOpciones() {}

}


