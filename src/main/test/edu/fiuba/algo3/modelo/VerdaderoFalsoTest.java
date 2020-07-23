package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;
import edu.fiuba.algo3.modelo.pregunta.respuesta.OpcionElegible;
import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;

public class VerdaderoFalsoTest {

    VerdaderoFalso pregunta;

    @BeforeEach
    public void init() {

        Modalidad modalidad = new ModalidadClasica();

        String enunciado = "El agua hierve a 100 C.";

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("Verdadero");     // id opcion = 1

        ArrayList<String> opcionesIncorrectas = new ArrayList<String>();
        opcionesIncorrectas.add("Falso");       // id opcion = 2

        this.pregunta = new VerdaderoFalso(modalidad, enunciado, opcionesCorrectas, opcionesIncorrectas);

    }

    @Test
    public void test01seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaOpcionCorrecta() {

        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso();

        OpcionElegible opcionVerdadero = new OpcionElegible(1, "Verdadero");
        opcionVerdadero.elegir();
        OpcionElegible opcionFalso = new OpcionElegible(2, "Falso");

        respuestaCorrecta.agregarOpcion(opcionVerdadero);
        respuestaCorrecta.agregarOpcion(opcionFalso);

        assertEquals(this.pregunta.obtenerRespuestaCorrecta().compararCon(respuestaCorrecta).obtenerOpcionesCorrectasElegidas(), 1);
    }

    @Test
    public void test02seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaCorrectaAsignacionDePuntos() {
        
        Jugador jugador1 = new Jugador("Santiago");
        Jugador jugador2 = new Jugador("Roberto");

        RespuestaVerdaderoFalso respuestaJugador1 = mock(RespuestaVerdaderoFalso.class);
        RespuestaVerdaderoFalso respuestaJugador2 = mock(RespuestaVerdaderoFalso.class);

        EstadisticasRespuestas estadisticasRespuestasJugador1 = mock(EstadisticasRespuestas.class);
        EstadisticasRespuestas estadisticasRespuestasJugador2 = mock(EstadisticasRespuestas.class);

        when(respuestaJugador1.compararCon( any() )).thenReturn( estadisticasRespuestasJugador1 );
        when(respuestaJugador2.compararCon( any() )).thenReturn( estadisticasRespuestasJugador2 );

        when( estadisticasRespuestasJugador1.obtenerOpcionesCorrectasElegidas() ).thenReturn( 1 );
        when( estadisticasRespuestasJugador2.obtenerOpcionesCorrectasElegidas() ).thenReturn( 0 );

        HashMap<Integer, Respuesta> idJugadores_respuestas = new HashMap<Integer, Respuesta>();

        idJugadores_respuestas.put(1, respuestaJugador1);
        idJugadores_respuestas.put(2, respuestaJugador2);

        Map<Integer, Integer> idsPuntuaciones = this.pregunta.obtenerPuntajePorJugador(idJugadores_respuestas);

        jugador1.sumarPuntos(idsPuntuaciones.get(1));
        jugador2.sumarPuntos(idsPuntuaciones.get(2));

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), 0);

    }

}