package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Multiplicador;
import edu.fiuba.algo3.modelo.pregunta.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.pregunta.InformacionPregunta;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class GestorDeJuego {

    private int rondaActual;
    private GeneradorDePreguntas generadorDePreguntas;
    private Pregunta preguntaActual;
    private ArrayList<RespuestaDeJugador> respuestasActuales;

    public GestorDeJuego(ArrayList<InformacionPregunta> informacionPreguntas, ArrayList<Jugador> jugadoresIngresados) {

        rondaActual = 0;
        generadorDePreguntas = new GeneradorDePreguntas(informacionPreguntas);
        this.comenzarNuevaRonda();
    }

    private void comenzarNuevaRonda() {

        preguntaActual = generadorDePreguntas.obtenerNuevaPregunta();
        rondaActual++;
    }

    public void guardarRespuesta(Respuesta respuesta, Jugador jugador) {

        // falta contemplar excepcion
        RespuestaDeJugador respuestaJugador = new RespuestaDeJugador(jugador, respuesta);
        respuestasActuales.add(respuestaJugador);
    }

    public void enviarRespuestas() {

        // falta contemplar excepcion
        preguntaActual.evaluarRespuestas(respuestasActuales);
        respuestasActuales.clear();
        this.comenzarNuevaRonda();
    }

    //Problema sin solucionar

    public void aplicarMultiplicadorX2(Jugador jugador) {

        Multiplicador multiplicadorX2 = jugador.obtenerMultiplicadorX2();
        preguntaActual.recibirBonificacion(multiplicadorX2);
    }

    public void aplicarMultiplicadorX3(Jugador jugador) {

        Multiplicador multiplicadorX3 = jugador.obtenerMultiplicadorX3();
        preguntaActual.recibirBonificacion(multiplicadorX3);
    }

    public void aplicarExclusividad(Jugador jugador) {

        ExclusividadDePuntaje exclusividad = jugador.obtenerExclusividad();
        preguntaActual.recibirBonificacion(exclusividad);
    }
}
