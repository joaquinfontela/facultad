//package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.modalidad.ModalidadPuntajeParcial;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaMultipleChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoicePuntajeParcialConExclusividadTest {

    Pregunta pregunta;

    Jugador jugador1;
    Jugador jugador2;

    RespuestaMultipleChoice respuestaJugador1;
    RespuestaMultipleChoice respuestaJugador2;

    EnunciadosOpciones opcionesParaAgregarJugador1;
    EnunciadosOpciones opcionesParaAgregarJugador2;

    @BeforeEach
    public void init() throws Exception {

        Modalidad modalidad = new ModalidadPuntajeParcial();

        ExclusividadDePuntaje exclusividadDePuntaje = new ExclusividadDePuntaje(jugador1);
        modalidad.recibirBonificacion(exclusividadDePuntaje);

        String enunciado = "¿Cuáles de estos animales son Venenosos?";

        Respuesta respuestaCorrecta = new RespuestaMultipleChoice();

        EnunciadosOpciones opcionesParaAgregar = new EnunciadosOpciones();

        opcionesParaAgregar.agregarEnunciadoEidentificador(1, "Ornitorrinco");
        opcionesParaAgregar.agregarEnunciadoEidentificador(1, "Pez piedra");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Pez payaso");

        respuestaCorrecta.rellenar(opcionesParaAgregar);

        pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        jugador1 = new Jugador("Santiago");
        jugador2 = new Jugador("Roberto");

        respuestaJugador1 = new RespuestaMultipleChoice();
        respuestaJugador2 = new RespuestaMultipleChoice();

        opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        opcionesParaAgregarJugador2 = new EnunciadosOpciones();
    }

    @Test
    public void test01seCreaUnaPreguntaMultipleChoicePuntajeParcialYSeVerificaLaCorrectaAsignacionDePuntos() {

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Ornitorrinco");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Pez piedra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Ornitorrinco");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Pez piedra");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Rana toro");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Serpiente falsa coral");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);

        RespuestaDeJugador respuestaDeJugador1 = new RespuestaDeJugador(jugador1, respuestaJugador1);
        RespuestaDeJugador respuestaDeJugador2 = new RespuestaDeJugador(jugador2, respuestaJugador2);

        ArrayList<RespuestaDeJugador> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaDeJugador1);
        respuestasJugadores.add(respuestaDeJugador2);

        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(jugador1.obtenerPuntaje(), 4);
        assertEquals(jugador2.obtenerPuntaje(), 0);
    }

    @Test
    public void test02seCreaUnaPreguntaMultipleChoicePuntajeParcialYSeVerificaLaCorrectaAsignacionDePuntos() {

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Ornitorrinco");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez piedra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Ornitorrinco");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Pez piedra");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Rana toro");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Serpiente falsa coral");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Pez payaso");
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
    public void test03seCreaUnaPreguntaMultipleChoicePuntajeParcialYSeVerificaLaCorrectaAsignacionDePuntos() {

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Ornitorrinco");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Pez piedra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Ornitorrinco");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Pez piedra");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Rana toro");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Serpiente falsa coral");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);

        RespuestaDeJugador respuestaDeJugador1 = new RespuestaDeJugador(jugador1, respuestaJugador1);
        RespuestaDeJugador respuestaDeJugador2 = new RespuestaDeJugador(jugador2, respuestaJugador2);

        ArrayList<RespuestaDeJugador> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaDeJugador1);
        respuestasJugadores.add(respuestaDeJugador2);

        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(jugador1.obtenerPuntaje(), 4);
        assertEquals(jugador2.obtenerPuntaje(), 0);
    }

    @Test
    public void test04seCreaUnaPreguntaMultipleChoicePuntajeParcialYSeVerificaLaCorrectaAsignacionDePuntos() {

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Ornitorrinco");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez piedra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Ornitorrinco");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Pez piedra");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);

        RespuestaDeJugador respuestaDeJugador1 = new RespuestaDeJugador(jugador1, respuestaJugador1);
        RespuestaDeJugador respuestaDeJugador2 = new RespuestaDeJugador(jugador2, respuestaJugador2);

        ArrayList<RespuestaDeJugador> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaDeJugador1);
        respuestasJugadores.add(respuestaDeJugador2);

        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), 2);
    }
}