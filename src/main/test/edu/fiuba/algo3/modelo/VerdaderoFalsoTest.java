package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.respuesta.OpcionElegible;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;

public class VerdaderoFalsoTest {

    @BeforeEach
    public void init() {

    }

    @Test
    public void test01seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaOpcionCorrecta() {

        Modalidad modalidad = new ModalidadClasica();

        String enunciado = "El agua hierve a 100 C.";

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("Verdadero");     // id opcion = 1

        ArrayList<String> opcionesIncorrectas = new ArrayList<String>();
        opcionesIncorrectas.add("Falso");       // id opcion = 2

        VerdaderoFalso pregunta = new VerdaderoFalso(modalidad, enunciado, opcionesCorrectas, opcionesIncorrectas);

        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso();

        OpcionElegible opcionVerdadero = new OpcionElegible(1, "Verdadero");
        opcionVerdadero.elegir();
        OpcionElegible opcionFalso = new OpcionElegible(2, "Falso");

        respuestaCorrecta.agregarOpcion(opcionVerdadero);
        respuestaCorrecta.agregarOpcion(opcionFalso);

        assertEquals(pregunta.obtenerCantidadDeRespuestasCorrectasEIncorrectasPorJugador(respuestaCorrecta).get(0), 1);
    }

    @Test
    public void test02seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaCorrectaAsignacionDePuntos() {


        Modalidad modalidad = new ModalidadClasica();

        String enunciado = "El agua hierve a 100 C.";

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("Verdadero");     // id opcion = 1

        ArrayList<String> opcionesIncorrectas = new ArrayList<String>();
        opcionesIncorrectas.add("Falso");       // id opcion = 2

        VerdaderoFalso pregunta = new VerdaderoFalso(modalidad, enunciado, opcionesCorrectas, opcionesIncorrectas);
        
        Jugador jugador1 = new Jugador("Santiago");
        Jugador jugador2 = new Jugador("Roberto");

        RespuestaVerdaderoFalso respuestaJugador1 = mock(RespuestaVerdaderoFalso.class);
        RespuestaVerdaderoFalso respuestaJugador2 = mock(RespuestaVerdaderoFalso.class);

        //when(respuestaJugador1.compararCon(any())).thenReturn( new ArrayList<Integer>(List.of( 1, 0 )) );
        //when(respuestaJugador2.compararCon(any())).thenReturn( new ArrayList<Integer>(List.of( 0, 1 )) );

        doReturn(new ArrayList<>( List.of(1, 0)) ).when( respuestaJugador1.compararCon( any() )); // any = respuestaCorrecta
        doReturn(new ArrayList<>( List.of(0, 1)) ).when( respuestaJugador2.compararCon( any() ));

        Map<Integer, RespuestaVerdaderoFalso> idJugadores_respuestas = new HashMap<Integer, RespuestaVerdaderoFalso>();

        idJugadores_respuestas.put(1, respuestaJugador1);
        idJugadores_respuestas.put(2, respuestaJugador2);

        Map<Integer, Integer> idsPuntuaciones = pregunta.obtenerPuntajePorJugador(idJugadores_respuestas);

        jugador1.sumarPuntos(idsPuntuaciones.get(1));
        jugador2.sumarPuntos(idsPuntuaciones.get(2));

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), 0);

    }

}