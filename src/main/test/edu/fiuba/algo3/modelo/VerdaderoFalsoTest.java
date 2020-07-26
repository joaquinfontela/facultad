package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;

public class VerdaderoFalsoTest {

    Pregunta pregunta;

    @BeforeEach
    public void init() {

        Modalidad modalidad = new ModalidadClasica();

        String enunciado = "El agua hierve a 100 C.";

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("Verdadero");     // id opcion = 1

        ArrayList<String> opcionesIncorrectas = new ArrayList<String>();
        opcionesIncorrectas.add("Falso");       // id opcion = 2

        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso();
        EnunciadosOpciones opcionesAagregar = new EnunciadosOpciones();
        opcionesAagregar.agregarEnunciadoEidentificador (1, "Verdadero");
        opcionesAagregar.agregarEnunciadoEidentificador(0, "Falso");
        respuestaCorrecta.rellenar(opcionesAagregar);
        this.pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

    }

    @Test
    public void test01seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaOpcionCorrecta() {

        RespuestaVerdaderoFalso respuestaCorrectaVerificacion = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesAagregar = new EnunciadosOpciones();
        opcionesAagregar.agregarEnunciadoEidentificador (1, "Verdadero");
        opcionesAagregar.agregarEnunciadoEidentificador(0, "Falso");
        respuestaCorrectaVerificacion.rellenar(opcionesAagregar);
        assertEquals(this.pregunta.obtenerRespuestaCorrecta().compararCon(respuestaCorrectaVerificacion).obtenerOpcionesCorrectasElegidas(), 1);
    }

    @Test
    public void test02seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaCorrectaAsignacionDePuntos() {
        
        Jugador jugador1 = new Jugador("Santiago");
        Jugador jugador2 = new Jugador("Roberto");

        RespuestaVerdaderoFalso respuestaJugador1 = new RespuestaVerdaderoFalso();
        RespuestaVerdaderoFalso respuestaJugador2 = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesAagregarJugador1 = new EnunciadosOpciones();
        opcionesAagregarJugador1.agregarEnunciadoEidentificador (1, "Verdadero");
        opcionesAagregarJugador1.agregarEnunciadoEidentificador(0, "Falso");
        respuestaJugador1.rellenar(opcionesAagregarJugador1);

        EnunciadosOpciones opcionesAagregarJugador2 = new EnunciadosOpciones();
        opcionesAagregarJugador2.agregarEnunciadoEidentificador (0, "Verdadero");
        opcionesAagregarJugador2.agregarEnunciadoEidentificador(1, "Falso");
        respuestaJugador2.rellenar(opcionesAagregarJugador2);


        HashMap<Integer, Respuesta> idJugadores_respuestas = new HashMap<>();

        idJugadores_respuestas.put(1, respuestaJugador1);
        idJugadores_respuestas.put(2, respuestaJugador2);

        Map<Integer, Integer> idsPuntuaciones = this.pregunta.obtenerPuntajePorJugador(idJugadores_respuestas);

        jugador1.sumarPuntos(idsPuntuaciones.get(1));
        jugador2.sumarPuntos(idsPuntuaciones.get(2));

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), 0);

    }

}

