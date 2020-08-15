package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.pregunta.InformacionPregunta;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;

import java.util.ArrayList;

public class GestorDeJuego {

    private ArrayList<Jugador> jugadoresRegistrados;
    private int turnoActual;
    private int rondaActual;
    private int rondasTotales;
    private GeneradorDePreguntas generadorDePreguntas;
    private Pregunta preguntaActual;
    private ArrayList<RespuestaDeJugador> respuestasActuales;
    private boolean juegoEnProgreso;

    public GestorDeJuego(ArrayList<InformacionPregunta> informacionPreguntas, ArrayList<Jugador> jugadores,
                                                                                                int cantidadRondas) {

        rondaActual = 0;
        jugadoresRegistrados = jugadores;
        rondasTotales = cantidadRondas;
        generadorDePreguntas = new GeneradorDePreguntas(informacionPreguntas);
        respuestasActuales = new ArrayList<>();
        juegoEnProgreso = true;
        this.comenzarNuevaRonda();
    }

    private void comenzarNuevaRonda(){

        turnoActual = 0;
        preguntaActual = generadorDePreguntas.obtenerNuevaPregunta();
        rondaActual++;
    }

    public void terminarTurno(Respuesta respuesta) throws Exception {

        if (!juegoEnProgreso) throw new Exception("El juego ha finalizado");
        this.guardarRespuesta(respuesta, jugadoresRegistrados.get(turnoActual));
        this.avanzarSiguienteTurno();
    }

    public void avanzarSiguienteTurno() throws Exception {

        if (!juegoEnProgreso) throw new Exception("El juego ha finalizado");
        turnoActual++;
        if (turnoActual == jugadoresRegistrados.size()) this.enviarRespuestas();
    }

    private void guardarRespuesta(Respuesta respuesta, Jugador jugador) {

        RespuestaDeJugador respuestaJugador = new RespuestaDeJugador(jugador, respuesta);
        respuestasActuales.add(respuestaJugador);
    }

    private void enviarRespuestas() {

        preguntaActual.evaluarRespuestas(respuestasActuales);
        respuestasActuales.clear();
        if (rondaActual < rondasTotales) {
            this.comenzarNuevaRonda();
        } else {
            this.finalizarJuego();
        }
    }

    private void finalizarJuego() {
        juegoEnProgreso = false;
    }

    public void aplicarMultiplicadorX2DelJugadorActual() throws Exception {

        if (!juegoEnProgreso) throw new Exception("El juego ha finalizgestorado");
        Jugador jugadorActual = jugadoresRegistrados.get(turnoActual);
        preguntaActual.recibirBonificacion(jugadorActual.obtenerMultiplicadorX2());
        jugadorActual.eliminarMultiplicadorX2();
    }

    public void aplicarMultiplicadorX3DelJugadorActual() throws Exception {

        if (!juegoEnProgreso) throw new Exception("El juego ha finalizado");
        Jugador jugadorActual = jugadoresRegistrados.get(turnoActual);
        preguntaActual.recibirBonificacion(jugadorActual.obtenerMultiplicadorX3());
        jugadorActual.eliminarMultiplicadorX3();
    }

    public void aplicarExclusividadDelJugadorActual() throws Exception {

        if (!juegoEnProgreso) throw new Exception("El juego ha finalizado");
        Jugador jugadorActual = jugadoresRegistrados.get(turnoActual);
        preguntaActual.recibirBonificacion(jugadorActual.obtenerExclusividad());
        jugadorActual.eliminarExclusividad();
    }

    public String obtenerNombreJugadorActual() {
        return jugadoresRegistrados.get(turnoActual).obtenerNombre();
    }

    public int obtenerRondaActual() {
        return rondaActual;
    }

    public int obtenerRondasTotales() {
        return rondasTotales;
    }

    public boolean comienzaNuevaRonda() {
        return turnoActual == 0;
    }

    public String obtenerEnunciadoPreguntaActual() {
        return preguntaActual.obtenerEnunciado();
    }

    public ArrayList<String> obtenerEnunciadosOpcionesActuales() {
        return preguntaActual.obtenerEnunciadosOpciones();
    }

    public boolean juegoFinalizado() {
        return !juegoEnProgreso;
    }

    public ArrayList<Jugador> obtenerJugadoresRegistrados() {
        return jugadoresRegistrados;
    }

    public Jugador obtenerPosibleJugadorGanador() {

        int contador = 0;
        Jugador candidatoGanador = jugadoresRegistrados.get(0);
        for (Jugador jugador : jugadoresRegistrados) {
            if(jugador.obtenerPuntaje() > candidatoGanador.obtenerPuntaje()) {
                candidatoGanador = jugador;
            }
        }
        return candidatoGanador;
    }

    public Jugador obtenerPosibleJugadorPerdedor() {

        Jugador jugadorGanador = obtenerPosibleJugadorGanador();
        Jugador jugadorPerdedor = null;
        for (Jugador jugador : jugadoresRegistrados) {
            if(jugadorGanador != jugador) {
                jugadorPerdedor = jugador;
            }
        }
        return jugadorPerdedor;
    }

    public boolean esTipoDeRespuestaComparable(Class clase) {

        return preguntaActual.esTipoDeRespuestaComparable(clase);
    }
}