package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.RespuestaDeJugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaOrderedChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceConExclusividadTest {

    Pregunta pregunta;

    Jugador jugador1;
    Jugador jugador2;

    RespuestaOrderedChoice respuestaJugador1;
    RespuestaOrderedChoice respuestaJugador2;

    EnunciadosOpciones opcionesParaAgregarJugador1;
    EnunciadosOpciones opcionesParaAgregarJugador2;

    @BeforeEach
    public void init() throws Exception {

        Modalidad modalidad = new ModalidadClasica();

        ExclusividadDePuntaje exclusividadDePuntaje = new ExclusividadDePuntaje(jugador1);
        modalidad.recibirBonificacion(exclusividadDePuntaje);

        String enunciado = "Ordenar los siguientes paises segun la cantidad de copas " +
                "mundiales de futbol ganadas (en orden descendiente).";

        Respuesta respuestaCorrecta = new RespuestaOrderedChoice();

        EnunciadosOpciones opcionesParaAgregar = new EnunciadosOpciones();

        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Brasil");
        opcionesParaAgregar.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregar.agregarEnunciadoEidentificador(2, "Argentina");
        opcionesParaAgregar.agregarEnunciadoEidentificador(3, "Inglaterra");
        opcionesParaAgregar.agregarEnunciadoEidentificador(4, "Belgica");

        respuestaCorrecta.rellenar(opcionesParaAgregar);

        pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        jugador1 = new Jugador("Santiago");
        jugador2 = new Jugador("Roberto");

        respuestaJugador1 = new RespuestaOrderedChoice();
        respuestaJugador2 = new RespuestaOrderedChoice();

        opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        opcionesParaAgregarJugador2 = new EnunciadosOpciones();

    }

    @Test
    public void test01seCreaUnaPreguntaOrderedChoiceYSeVerificaLaCorrectaAsignacionDePuntos() {

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Brasil");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(2, "Argentina");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(3, "Inglaterra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(4, "Belgica");

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Brasil");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(2, "Argentina");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(3, "Belgica");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(4, "Inglaterra");

        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);

        RespuestaDeJugador respuestaDeJugador1 = new RespuestaDeJugador(jugador1, respuestaJugador1);
        RespuestaDeJugador respuestaDeJugador2 = new RespuestaDeJugador(jugador2, respuestaJugador2);

        ArrayList<RespuestaDeJugador> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaDeJugador1);
        respuestasJugadores.add(respuestaDeJugador2);

        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(jugador1.obtenerPuntaje(), 2);
        assertEquals(jugador2.obtenerPuntaje(), 0);
    }

    @Test
    public void test02seCreaUnaPreguntaOrderedChoiceYSeVerificaLaCorrectaAsignacionDePuntos() {

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Belgica");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(2, "Argentina");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(3, "Inglaterra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(4, "Brasil");

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Argentina");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(2, "Brasil");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(3, "Inglaterra");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(4, "Belgica");

        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);

        RespuestaDeJugador respuestaDeJugador1 = new RespuestaDeJugador(jugador1, respuestaJugador1);
        RespuestaDeJugador respuestaDeJugador2 = new RespuestaDeJugador(jugador2, respuestaJugador2);

        ArrayList<RespuestaDeJugador> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaDeJugador1);
        respuestasJugadores.add(respuestaDeJugador2);

        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(jugador1.obtenerPuntaje(), 0);
        assertEquals(jugador2.obtenerPuntaje(), 0);
    }

    @Test
    public void test03seCreaUnaPreguntaOrderedChoiceYSeVerificaLaCorrectaAsignacionDePuntos() {

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Brasil");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(2, "Argentina");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(3, "Inglaterra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(4, "Belgica");

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Brasil");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(2, "Argentina");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(3, "Inglaterra");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(4, "Belgica");

        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);

        RespuestaDeJugador respuestaDeJugador1 = new RespuestaDeJugador(jugador1, respuestaJugador1);
        RespuestaDeJugador respuestaDeJugador2 = new RespuestaDeJugador(jugador2, respuestaJugador2);

        ArrayList<RespuestaDeJugador> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaDeJugador1);
        respuestasJugadores.add(respuestaDeJugador2);

        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), 1);
    }
}