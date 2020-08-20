package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.RespuestaDeJugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModalidadClasicaTest {

    Jugador jugador1, jugador2;
    ModalidadClasica modalidad;
    EstadisticasRespuesta estadisticasJugador1, estadisticasJugador2;
    RespuestaDeJugador respuestaJugador1, respuestaJugador2;
    ExclusividadDePuntaje exclusividad;

    @BeforeEach
    public void init() {

        jugador1 = new Jugador("Pablito");
        jugador2 = new Jugador("Ramona");
        modalidad = new ModalidadClasica();
        estadisticasJugador1 = new EstadisticasRespuesta();
        estadisticasJugador2 = new EstadisticasRespuesta();
        respuestaJugador1 = mock(RespuestaDeJugador.class);
        respuestaJugador2 = mock(RespuestaDeJugador.class);
        exclusividad = new ExclusividadDePuntaje(jugador1);

        when(respuestaJugador1.obtenerEstadisticasRespuesta()).thenReturn(estadisticasJugador1);
        when(respuestaJugador2.obtenerEstadisticasRespuesta()).thenReturn(estadisticasJugador2);
        when(respuestaJugador1.obtenerDuenio()).thenReturn(jugador1);
        when(respuestaJugador2.obtenerDuenio()).thenReturn(jugador2);
    }

    @Test
    public void test01SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientes() {

        estadisticasJugador1.sumarCorrectaElegida();
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),1);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }

    @Test
    public void test02SeCreaUnaRespuestaCorrectaDobleYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientes() {

        estadisticasJugador1.sumarCorrectaElegida();
        estadisticasJugador1.sumarCorrectaElegida();
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),1);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }

    @Test
    public void test03SeCreaUnaRespuestaCorrectaParcialYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientes() {

        estadisticasJugador1.sumarCorrectaElegida();
        estadisticasJugador1.sumarCorrectaNoElegida();
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),0);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }

    @Test
    public void test04SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientesConExlusividad() throws Exception {

        estadisticasJugador1.sumarCorrectaElegida();
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.recibirBonificacion(exclusividad);
        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),2);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }

    @Test
    public void test05SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientesConExlusividadDoble() throws Exception {

        estadisticasJugador1.sumarCorrectaElegida();
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.recibirBonificacion(exclusividad);
        exclusividad = new ExclusividadDePuntaje(jugador2);
        modalidad.recibirBonificacion(exclusividad);
        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),4);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }

    @Test
    public void test06SeCreaDosRespuestasCorrectasYLaExclusividadNoAfecta()throws Exception {

        estadisticasJugador1.sumarCorrectaElegida();
        estadisticasJugador2.sumarCorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.recibirBonificacion(exclusividad);
        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),1);
        assertEquals(jugador2.obtenerPuntaje(),1);
    }

    @Test
    public void test07SeCreaDosRespuestasIncorrectasYLaExclusividadNoAfecta() throws Exception {

        estadisticasJugador1.sumarIncorrectaElegida();
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.recibirBonificacion(exclusividad);
        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),0);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }
}