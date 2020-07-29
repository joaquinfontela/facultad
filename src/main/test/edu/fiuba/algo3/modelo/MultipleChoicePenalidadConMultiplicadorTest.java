package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Multiplicador;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaMultipleChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoicePenalidadConMultiplicadorTest {

    String enunciado;

    Respuesta respuestaCorrecta;

    Jugador jugador1;
    Jugador jugador2;

    @BeforeEach
    public void init() {

        jugador1 = new Jugador("Santiago");
        jugador2 = new Jugador("Roberto");

        enunciado = "El agua hierve a 100 C.";

        respuestaCorrecta = new RespuestaMultipleChoice();

        EnunciadosOpciones opcionesParaAgregar = new EnunciadosOpciones();

        opcionesParaAgregar.agregarEnunciadoEidentificador (1, "Ornitorrinco");
        opcionesParaAgregar.agregarEnunciadoEidentificador (1, "Pez piedra");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaCorrecta.rellenar(opcionesParaAgregar);
    }

    @Test
    public void test01seCreaUnaPreguntaMultipleChoicePenalidadYSeVerificaLaCorrectaAsignacionDePuntos() {

        Modalidad modalidad = new ModalidadPenalidad();

        Multiplicador multiplicadorX2jugador1 = new Multiplicador(2, jugador1);
        modalidad.recibirBonificacion(multiplicadorX2jugador1);

        Pregunta pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        RespuestaMultipleChoice respuestaJugador1 = new RespuestaMultipleChoice();
        RespuestaMultipleChoice respuestaJugador2 = new RespuestaMultipleChoice();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Ornitorrinco");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Pez piedra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Ornitorrinco");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Pez piedra");
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
        assertEquals(jugador2.obtenerPuntaje(), -2);
    }

    @Test
    public void test02seCreaUnaPreguntaMultipleChoicePenalidadYSeVerificaLaCorrectaAsignacionDePuntos() {

        Modalidad modalidad = new ModalidadPenalidad();

        Multiplicador multiplicadorX2jugador2 = new Multiplicador(2, jugador2);
        modalidad.recibirBonificacion(multiplicadorX2jugador2);

        Pregunta pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        RespuestaMultipleChoice respuestaJugador1 = new RespuestaMultipleChoice();
        RespuestaMultipleChoice respuestaJugador2 = new RespuestaMultipleChoice();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Ornitorrinco");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Pez piedra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Ornitorrinco");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Pez piedra");
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
        assertEquals(jugador2.obtenerPuntaje(), -4);
    }

    @Test
    public void test03seCreaUnaPreguntaMultipleChoicePenalidadYSeVerificaLaCorrectaAsignacionDePuntos() {

        Modalidad modalidad = new ModalidadPenalidad();

        Multiplicador multiplicadorX3jugador1 = new Multiplicador(3, jugador1);
        modalidad.recibirBonificacion(multiplicadorX3jugador1);

        Pregunta pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        RespuestaMultipleChoice respuestaJugador1 = new RespuestaMultipleChoice();
        RespuestaMultipleChoice respuestaJugador2 = new RespuestaMultipleChoice();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Ornitorrinco");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Pez piedra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Ornitorrinco");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Pez piedra");
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

        assertEquals(jugador1.obtenerPuntaje(), 6);
        assertEquals(jugador2.obtenerPuntaje(), -2);
    }

    @Test
    public void test04seCreaUnaPreguntaMultipleChoicePenalidadYSeVerificaLaCorrectaAsignacionDePuntos() {

        Modalidad modalidad = new ModalidadPenalidad();

        Multiplicador multiplicadorX3jugador2 = new Multiplicador(3, jugador2);
        modalidad.recibirBonificacion(multiplicadorX3jugador2);

        Pregunta pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        RespuestaMultipleChoice respuestaJugador1 = new RespuestaMultipleChoice();
        RespuestaMultipleChoice respuestaJugador2 = new RespuestaMultipleChoice();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Ornitorrinco");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador (1, "Pez piedra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Rana toro");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Serpiente falsa coral");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Pez payaso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Ornitorrinco");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Pez piedra");
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
        assertEquals(jugador2.obtenerPuntaje(), -6);
    }
}