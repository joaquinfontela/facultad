package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.RespuestaDeJugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Multiplicador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModalidadPenalidadTest {

    Jugador jugador1, jugador2;
    ModalidadPenalidad modalidad;
    EstadisticasRespuesta estadisticasJugador1, estadisticasJugador2;
    RespuestaDeJugador respuestaJugador1, respuestaJugador2;
    Multiplicador multiplicadorJugadorUnoX2, multiplicadorJugadorDosX3;

    @BeforeEach
    public void init() {

        jugador1 = new Jugador("Pablito");
        jugador2 = new Jugador("Ramona");
        modalidad = new ModalidadPenalidad();
        estadisticasJugador1 = new EstadisticasRespuesta();
        estadisticasJugador2 = new EstadisticasRespuesta();
        respuestaJugador1 = mock(RespuestaDeJugador.class);
        respuestaJugador2 = mock(RespuestaDeJugador.class);
        multiplicadorJugadorUnoX2 = new Multiplicador(2,jugador1);
        multiplicadorJugadorDosX3 = new Multiplicador(3,jugador2);

        when(respuestaJugador1.obtenerEstadisticasRespuesta()).thenReturn(estadisticasJugador1);
        when(respuestaJugador2.obtenerEstadisticasRespuesta()).thenReturn(estadisticasJugador2);
        when(respuestaJugador1.obtenerDuenio()).thenReturn(jugador1);
        when(respuestaJugador2.obtenerDuenio()).thenReturn(jugador2);
    }

    @Test
    public void test01SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientes() {

        for (int i = 0; i < 3; i++){
            estadisticasJugador1.sumarCorrectaElegida();
            estadisticasJugador2.sumarIncorrectaElegida();
        }

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),3);
        assertEquals(jugador2.obtenerPuntaje(),-3);
    }

    @Test
    public void test02SeCreaUnaRespuestaCorrectaParcialMultipleYOtraIncorrectaParcialMultipleYSeVerificanLosPuntajesCorrespondientes() {

        for (int i = 0; i < 3; i++){
            estadisticasJugador1.sumarCorrectaElegida();
            estadisticasJugador2.sumarIncorrectaElegida();
        }
        estadisticasJugador1.sumarCorrectaNoElegida();
        estadisticasJugador2.sumarCorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),3);
        assertEquals(jugador2.obtenerPuntaje(),-2);
    }

    @Test
    public void test03SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientesConMultiplicadorX2DelJugadorUno() throws Exception {

        for (int i = 0; i < 3; i++){
            estadisticasJugador1.sumarCorrectaElegida();
            estadisticasJugador2.sumarIncorrectaElegida();
        }

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.recibirBonificacion(multiplicadorJugadorUnoX2);
        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),6);
        assertEquals(jugador2.obtenerPuntaje(),-3);
    }

    @Test
    public void test04SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientesConMultiplicadorX3DelJugadorDos() throws Exception {

        for (int i = 0; i < 3; i++){
            estadisticasJugador1.sumarCorrectaElegida();
            estadisticasJugador2.sumarIncorrectaElegida();
        }

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.recibirBonificacion(multiplicadorJugadorDosX3);
        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),3);
        assertEquals(jugador2.obtenerPuntaje(),-9);
    }
}