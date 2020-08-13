package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.ModalidadPuntajeParcial;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModalidadPuntajeParcialTest {

    Jugador jugador1, jugador2;
    ModalidadPuntajeParcial modalidad;
    EstadisticasRespuesta estadisticasJugador1, estadisticasJugador2;
    RespuestaDeJugador respuestaJugador1, respuestaJugador2;
    ExclusividadDePuntaje exclusividad;

    @BeforeEach
    public void init() {

        jugador1 = new Jugador("Pablito");
        jugador2 = new Jugador("Ramona");
        modalidad = new ModalidadPuntajeParcial();
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
    public void test01SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientes() {

        for (int i = 0; i < 3; i++){
            estadisticasJugador1.sumarCorrectaElegida();
            estadisticasJugador2.sumarCorrectaElegida();
        }
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),3);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }

    @Test
    public void test02SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientesConExclusividad() throws Exception {

        for (int i = 0; i < 3; i++){
            estadisticasJugador1.sumarCorrectaElegida();
            estadisticasJugador2.sumarCorrectaElegida();
        }
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.recibirBonificacion(exclusividad);
        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),6);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }

    @Test
    public void test03SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientesConExclusividadDoble() throws Exception {

        for (int i = 0; i < 3; i++){
            estadisticasJugador1.sumarCorrectaElegida();
            estadisticasJugador2.sumarCorrectaElegida();
        }
        estadisticasJugador2.sumarIncorrectaElegida();

        ArrayList<RespuestaDeJugador> respuestas = new ArrayList<>(List.of(respuestaJugador1, respuestaJugador2));

        modalidad.recibirBonificacion(exclusividad);
        exclusividad = new ExclusividadDePuntaje(jugador2);
        modalidad.recibirBonificacion(exclusividad);
        modalidad.establecerPuntajes(respuestas);

        assertEquals(jugador1.obtenerPuntaje(),12);
        assertEquals(jugador2.obtenerPuntaje(),0);
    }
}