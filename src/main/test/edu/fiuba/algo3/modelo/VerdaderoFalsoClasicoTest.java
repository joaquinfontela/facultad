package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class VerdaderoFalsoClasicoTest {

    Pregunta pregunta;

    @BeforeEach
    public void init() {

        Modalidad modalidad = new ModalidadClasica();

        String enunciado = "El agua hierve a 100 C.";

        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso();
        EnunciadosOpciones opcionesParaAgregar = new EnunciadosOpciones();
        opcionesParaAgregar.agregarEnunciadoEidentificador (1, "Verdadero");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Falso");
        respuestaCorrecta.rellenar(opcionesParaAgregar);
        pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);
    }

    @Test
    public void test01seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaOpcionCorrecta() {

        RespuestaVerdaderoFalso respuestaCorrectaVerificacion = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesParaAgregar = new EnunciadosOpciones();
        opcionesParaAgregar.agregarEnunciadoEidentificador (1, "Verdadero");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Falso");
        respuestaCorrectaVerificacion.rellenar(opcionesParaAgregar);
        assertEquals(pregunta.obtenerRespuestaCorrecta().compararCon(respuestaCorrectaVerificacion).obtenerOpcionesCorrectasElegidas(), 1);
    }

    @Test
    public void test02seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaCorrectaAsignacionDePuntos() {
        
        Jugador jugador1 = new Jugador("Santiago");
        Jugador jugador2 = new Jugador("Roberto");

        RespuestaVerdaderoFalso respuestaJugador1 = new RespuestaVerdaderoFalso();
        RespuestaVerdaderoFalso respuestaJugador2 = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Verdadero");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Falso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Verdadero");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Falso");
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);

        RespuestaDeJugador respuestaDeJugador1 = new RespuestaDeJugador(jugador1, respuestaJugador1);
        RespuestaDeJugador respuestaDeJugador2 = new RespuestaDeJugador(jugador2, respuestaJugador2);

        ArrayList<RespuestaDeJugador> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaDeJugador1);
        respuestasJugadores.add(respuestaDeJugador2);

        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), 0);
    }
}