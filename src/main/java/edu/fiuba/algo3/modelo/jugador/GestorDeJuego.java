package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.pregunta.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.pregunta.InformacionPregunta;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class GestorDeJuego {

    private ArrayList<Jugador> jugadoresRegistrados;
    private int rondaActual;
    private GeneradorDePreguntas generadorDePreguntas;
    private Pregunta preguntaActual;
    private ArrayList<RespuestaDeJugador> respuestasActuales;

    public GestorDeJuego(ArrayList<InformacionPregunta> informacionPreguntas, ArrayList<Jugador> jugadores) {

        jugadoresRegistrados = jugadores;
        rondaActual = 0;
        generadorDePreguntas = new GeneradorDePreguntas(informacionPreguntas);
        this.comenzarNuevaRonda();
    }

    private void comenzarNuevaRonda() {

        preguntaActual = generadorDePreguntas.obtenerNuevaPregunta();
        rondaActual++;
    }

    public void guardarRespuesta(Respuesta respuesta, Jugador jugador) {

        RespuestaDeJugador respuestaJugador = new RespuestaDeJugador(jugador, respuesta);
        respuestasActuales.add(respuestaJugador);
    }

    public void enviarRespuestas() throws Exception {

        this.verificarTotalidadDeRespuestasJugadores();
        preguntaActual.evaluarRespuestas(respuestasActuales);
        respuestasActuales.clear();
        this.comenzarNuevaRonda();
    }

    private void verificarTotalidadDeRespuestasJugadores() throws Exception {

        for (RespuestaDeJugador respuesta : respuestasActuales) {
            if (!jugadoresRegistrados.contains(respuesta.obtenerDuenio())) throw new Exception();
        }
    }

    public void aplicarMultiplicadorX2(Jugador jugador) throws Exception {

        preguntaActual.recibirBonificacion(jugador.obtenerMultiplicadorX2());
        jugador.eliminarMultiplicadorX2();
    }

    public void aplicarMultiplicadorX3(Jugador jugador) throws Exception {

        preguntaActual.recibirBonificacion(jugador.obtenerMultiplicadorX3());
        jugador.eliminarMultiplicadorX3();
    }

    public void aplicarExclusividad(Jugador jugador) throws Exception {

        preguntaActual.recibirBonificacion(jugador.obtenerExclusividad());
        jugador.eliminarExclusividad();
    }
}