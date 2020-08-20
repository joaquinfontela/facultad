package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.pregunta.InformacionPregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestorDeJuegoTest {

    private GestorDeJuego gestor;
    private ArrayList<Jugador> jugadores;

    @BeforeEach
    public void init() throws Exception {

        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Daniela"));
        jugadores.add(new Jugador("Roberto"));
        LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();
        ArrayList<InformacionPregunta> infoArchivo = lectorDeArchivo.obtenerListaDeInformacionDePreguntas(3);
        gestor = new GestorDeJuego(infoArchivo, jugadores, 3);
    }

    @Test
    public void test01SeVerificaQueAlTerminarTurnoElJugadorActualCambia() throws Exception {

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        assertEquals(jugadores.get(0).obtenerNombre(),gestor.obtenerNombreJugadorActual());
        gestor.terminarTurno(respuesta);
        assertEquals(jugadores.get(1).obtenerNombre(),gestor.obtenerNombreJugadorActual());
    }
}