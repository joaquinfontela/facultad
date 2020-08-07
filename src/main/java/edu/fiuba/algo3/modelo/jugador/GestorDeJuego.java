package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.pregunta.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.pregunta.InformacionPregunta;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class GestorDeJuego {

    private ArrayList<Jugador> jugadoresRegistrados;
    private int turnoActual;
    private int rondasRestantes;
    private GeneradorDePreguntas generadorDePreguntas;
    private Pregunta preguntaActual;
    private ArrayList<RespuestaDeJugador> respuestasActuales;
    private boolean juegoEnProgreso;

    public GestorDeJuego(ArrayList<InformacionPregunta> informacionPreguntas, ArrayList<Jugador> jugadores,
                                                                                                int rondasTotales) {

        jugadoresRegistrados = jugadores;
        rondasRestantes = rondasTotales;
        generadorDePreguntas = new GeneradorDePreguntas(informacionPreguntas);
        juegoEnProgreso = true;
        this.comenzarNuevaRonda();
    }

    private void comenzarNuevaRonda() {

        turnoActual = 0;
        preguntaActual = generadorDePreguntas.obtenerNuevaPregunta();
        rondasRestantes--;
    }

    public void terminarTurno(Respuesta respuesta) throws Exception {

        if (!juegoEnProgreso) throw new Exception();
        this.guardarRespuesta(respuesta, jugadoresRegistrados.get(turnoActual));
        turnoActual++;
        if (respuestasActuales.size() == jugadoresRegistrados.size()) this.enviarRespuestas();
    }

    private void guardarRespuesta(Respuesta respuesta, Jugador jugador) {

        RespuestaDeJugador respuestaJugador = new RespuestaDeJugador(jugador, respuesta);
        respuestasActuales.add(respuestaJugador);
    }

    private void enviarRespuestas() {

        preguntaActual.evaluarRespuestas(respuestasActuales);
        respuestasActuales.clear();
        if (rondasRestantes > 0) {
            this.comenzarNuevaRonda();
        } else {
            this.finalizarJuego();
        }
    }

    private void finalizarJuego() {
        juegoEnProgreso = false;
    }

    public void aplicarMultiplicadorX2DelJugadorActual() throws Exception {

        if (!juegoEnProgreso) throw new Exception();
        Jugador jugadorActual = jugadoresRegistrados.get(turnoActual);
        preguntaActual.recibirBonificacion(jugadorActual.obtenerMultiplicadorX2());
        jugadorActual.eliminarMultiplicadorX2();
    }

    public void aplicarMultiplicadorX3DelJugadorActual() throws Exception {

        if (!juegoEnProgreso) throw new Exception();
        Jugador jugadorActual = jugadoresRegistrados.get(turnoActual);
        preguntaActual.recibirBonificacion(jugadorActual.obtenerMultiplicadorX3());
        jugadorActual.eliminarMultiplicadorX3();
    }

    public void aplicarExclusividadDelJugadorActual() throws Exception {

        if (!juegoEnProgreso) throw new Exception();
        Jugador jugadorActual = jugadoresRegistrados.get(turnoActual);
        preguntaActual.recibirBonificacion(jugadorActual.obtenerExclusividad());
        jugadorActual.eliminarExclusividad();
    }

    public String obtenerJugadorActual() {
        return jugadoresRegistrados.get(turnoActual).obtenerNombre();
    }
}