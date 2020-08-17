package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01jugadorSeInicializaConPuntaje0() {

        Jugador jugador = new Jugador("Jorge");
        assertEquals(jugador.obtenerPuntaje(), 0);
    }

    @Test
    public void test02jugadorSumaPuntajesPositivos() {

        Jugador jugador = new Jugador("Jorge");
        jugador.sumarPuntos(50);
        assertEquals(jugador.obtenerPuntaje(), 50);
    }

    @Test
    public void test03jugadorSumaPuntajesNegativos() {

        Jugador jugador = new Jugador("Jorge");
        jugador.sumarPuntos(-50);
        assertEquals(jugador.obtenerPuntaje(), -50);
    }

    @Test
    public void test04jugadorSumaElNuevoPuntajePositivoAlPuntajeQueYaPoseia() {

        Jugador jugador = new Jugador("Jorge");
        jugador.sumarPuntos(50);
        jugador.sumarPuntos(30);
        assertEquals(jugador.obtenerPuntaje(), 80);
    }

    @Test
    public void test05jugadorSumaElNuevoPuntajeNegativoAlPuntajeQueYaPoseia() {

        Jugador jugador = new Jugador("Jorge");
        jugador.sumarPuntos(50);
        jugador.sumarPuntos(-30);
        assertEquals(jugador.obtenerPuntaje(), 20);
    }
}