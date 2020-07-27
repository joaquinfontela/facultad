package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Multiplicador;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoPenalidadConMultiplicadorTest {

    String enunciado;
    Respuesta respuestaCorrecta;

    Jugador jugador1;
    Jugador jugador2;

    @BeforeEach
    public void init() {

        jugador1 = new Jugador("Santiago");
        jugador2 = new Jugador("Roberto");

        enunciado = "El agua hierve a 100 C.";

        respuestaCorrecta = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesParaAgregar = new EnunciadosOpciones();

        opcionesParaAgregar.agregarEnunciadoEidentificador(1, "Verdadero");
        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Falso");

        respuestaCorrecta.rellenar(opcionesParaAgregar);

    }

    @Test
    public void test01seCreaUnaPreguntaVerdaderoOFalsoPenalidadYSeVerificaLaCorrectaAsignacionDePuntos() {

        Modalidad modalidad = new ModalidadPenalidad();

        Multiplicador multiplicadorX2jugador1 = new Multiplicador(2, 1);
        modalidad.recibirBonificacion(multiplicadorX2jugador1);

        Pregunta pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        RespuestaVerdaderoFalso respuestaJugador1 = new RespuestaVerdaderoFalso();
        RespuestaVerdaderoFalso respuestaJugador2 = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Verdadero");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Falso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Verdadero");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Falso");
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);


        HashMap<Integer, Respuesta> idJugadores_respuestas = new HashMap<>();

        idJugadores_respuestas.put(1, respuestaJugador1);
        idJugadores_respuestas.put(2, respuestaJugador2);

        Map<Integer, Integer> idsPuntuaciones = pregunta.obtenerPuntajePorJugador(idJugadores_respuestas);

        jugador1.sumarPuntos(idsPuntuaciones.get(1));
        jugador2.sumarPuntos(idsPuntuaciones.get(2));

        assertEquals(jugador1.obtenerPuntaje(), 2);
        assertEquals(jugador2.obtenerPuntaje(), -1);
    }

    @Test
    public void test02seCreaUnaPreguntaVerdaderoOFalsoPenalidadYSeVerificaLaCorrectaAsignacionDePuntos() {

        Modalidad modalidad = new ModalidadPenalidad();

        Multiplicador multiplicadorX2jugador2 = new Multiplicador(2, 2);
        modalidad.recibirBonificacion(multiplicadorX2jugador2);

        Pregunta pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        RespuestaVerdaderoFalso respuestaJugador1 = new RespuestaVerdaderoFalso();
        RespuestaVerdaderoFalso respuestaJugador2 = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Verdadero");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Falso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Verdadero");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Falso");
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);


        HashMap<Integer, Respuesta> idJugadores_respuestas = new HashMap<>();

        idJugadores_respuestas.put(1, respuestaJugador1);
        idJugadores_respuestas.put(2, respuestaJugador2);

        Map<Integer, Integer> idsPuntuaciones = pregunta.obtenerPuntajePorJugador(idJugadores_respuestas);

        jugador1.sumarPuntos(idsPuntuaciones.get(1));
        jugador2.sumarPuntos(idsPuntuaciones.get(2));

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), -2);
    }

    @Test
    public void test03seCreaUnaPreguntaVerdaderoOFalsoPenalidadYSeVerificaLaCorrectaAsignacionDePuntos() {

        Modalidad modalidad = new ModalidadPenalidad();

        Multiplicador multiplicadorX3jugador1 = new Multiplicador(3, 1);
        modalidad.recibirBonificacion(multiplicadorX3jugador1);

        Pregunta pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        RespuestaVerdaderoFalso respuestaJugador1 = new RespuestaVerdaderoFalso();
        RespuestaVerdaderoFalso respuestaJugador2 = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Verdadero");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Falso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Verdadero");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Falso");
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);


        HashMap<Integer, Respuesta> idJugadores_respuestas = new HashMap<>();

        idJugadores_respuestas.put(1, respuestaJugador1);
        idJugadores_respuestas.put(2, respuestaJugador2);

        Map<Integer, Integer> idsPuntuaciones = pregunta.obtenerPuntajePorJugador(idJugadores_respuestas);

        jugador1.sumarPuntos(idsPuntuaciones.get(1));
        jugador2.sumarPuntos(idsPuntuaciones.get(2));

        assertEquals(jugador1.obtenerPuntaje(), 3);
        assertEquals(jugador2.obtenerPuntaje(), -1);
    }

    @Test
    public void test04seCreaUnaPreguntaVerdaderoOFalsoPenalidadYSeVerificaLaCorrectaAsignacionDePuntos() {

        Modalidad modalidad = new ModalidadPenalidad();

        Multiplicador multiplicadorX3jugador2 = new Multiplicador(3, 2);
        modalidad.recibirBonificacion(multiplicadorX3jugador2);

        Pregunta pregunta = new Pregunta(modalidad, enunciado, respuestaCorrecta);

        RespuestaVerdaderoFalso respuestaJugador1 = new RespuestaVerdaderoFalso();
        RespuestaVerdaderoFalso respuestaJugador2 = new RespuestaVerdaderoFalso();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Verdadero");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Falso");
        respuestaJugador1.rellenar(opcionesParaAgregarJugador1);

        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(0, "Verdadero");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador(1, "Falso");
        respuestaJugador2.rellenar(opcionesParaAgregarJugador2);

        HashMap<Integer, Respuesta> idJugadores_respuestas = new HashMap<>();

        idJugadores_respuestas.put(1, respuestaJugador1);
        idJugadores_respuestas.put(2, respuestaJugador2);

        Map<Integer, Integer> idsPuntuaciones = pregunta.obtenerPuntajePorJugador(idJugadores_respuestas);

        jugador1.sumarPuntos(idsPuntuaciones.get(1));
        jugador2.sumarPuntos(idsPuntuaciones.get(2));

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), -3);
    }
}