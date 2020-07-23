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
    public HashMap<Integer,Integer> obtenerCantidadDeRespuestasCorrectasEIncorrectasPorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas) {

        HashMap<Integer , EstadisticasRespuestas> idJugador_Estadistica = new HashMap<Integer, EstadisticasRespuestas>();
        for (Map.Entry<Integer, Respuesta> entrada : idsJugadores_respuestas.entrySet()) {
            Respuesta respuestaActual = entrada.getValue();
            Integer idActual = entrada.getKey();
            EstadisticasRespuestas estadisticasRespuestasActual = this.respuestaCorrecta.compararCon(respuestaActual);
            idJugador_Estadistica.put(idActual, estadisticasRespuestasActual);
        }
        return (this.modalidad.obtenerPuntajesPorJugador(idJugador_Estadistica));
    }
}


