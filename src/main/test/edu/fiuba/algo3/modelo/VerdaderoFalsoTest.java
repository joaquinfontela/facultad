package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VerdaderoFalsoTest {

    @BeforeEach
    void init() {

        ModalidadClasica modalidad = new ModalidadClasica();

        String enunciado = "El agua hierve a 100 C.";

        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("Verdadero");

        List<String> opcionesIncorrectas = new ArrayList<String>();
        opcionesIncorrectas.add("Falso");

        VerdaderoFalso pregunta = new VerdaderoFalso(modalidad, enunciado, opcionesCorrectas, opcionesIncorrectas);
    }


    @Test
    public void test01seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaOpcionCorrecta() {

        assertEquals(pregunta.obtenerOpcionesCorrectas().get(0).enunciado(), "Verdadero");
    }

    @Test
    public void test02seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaCorrectaAsignacionDePuntos() {

        // HACER CON MOCKITO!!!

        Jugador jugador1 = new Jugador("Santiago");
        Jugador jugador2 = new Jugador("Roberto");

        RespuestaVerdaderoFalso respuestaJugador1 = mock(RespuestaVerdaderoFalso.class);
        RespuestaVerdaderoFalso respuestaJugador2 = mock(RespuestaVerdaderoFalso.class);

        //when(respuestaJugador1.compararCon(any())).thenReturn( new ArrayList<Integer>(List.of( 1, 0 )) );
        //when(respuestaJugador2.compararCon(any())).thenReturn( new ArrayList<Integer>(List.of( 0, 1 )) );

        doReturn(new ArrayList<>( List.of(1, 0)) ).when( respuestaJugador1.compararCon( any() ));
        doReturn(new ArrayList<>( List.of(0, 1)) ).when( respuestaJugador2.compararCon( any() ));

        Map<Integer, RespuestaVerdaderoFalso> idsRespuestas = new HashMap<Integer, RespuestaVerdaderoFalso>();

        idsRespuestas.put(1, respuestaJugador1);
        idsRespuestas.put(2, respuestaJugador2);

        Map<Integer, Integer> idsPuntuaciones = pregunta.obtenerPuntuacionesPorJugador(idsRespuestas);

        jugador1.sumarPuntos(idsPuntuaciones.get(1));
        jugador2.sumarPuntos(idsPuntuaciones.get(2));

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), 0);

    }

}

cC