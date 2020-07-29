package noImplementadas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaDeJugador;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaOrderedChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    Pregunta pregunta;

    @BeforeEach
    public void init() {

        Modalidad modalidad = new ModalidadClasica();

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
    }

    @Test
    public void test01seCreaUnaPreguntaOrderedChoiceYSeVerificaLaOpcionCorrecta() {

        RespuestaOrderedChoice respuestaCorrectaVerificacion = new RespuestaOrderedChoice();

        EnunciadosOpciones opcionesParaAgregar = new EnunciadosOpciones();

        opcionesParaAgregar.agregarEnunciadoEidentificador(0, "Brasil");
        opcionesParaAgregar.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregar.agregarEnunciadoEidentificador(2, "Argentina");
        opcionesParaAgregar.agregarEnunciadoEidentificador(3, "Inglaterra");
        opcionesParaAgregar.agregarEnunciadoEidentificador(4, "Belgica");

        respuestaCorrectaVerificacion.rellenar(opcionesParaAgregar);

        assertEquals(pregunta.obtenerRespuestaCorrecta().compararCon(respuestaCorrectaVerificacion).obtenerOpcionesCorrectasElegidas(), 1);
    }

    @Test
    public void test02seCreaUnaPreguntaOrderedChoiceYSeVerificaLaCorrectaAsignacionDePuntos() {

        Jugador jugador1 = new Jugador("Santiago");
        Jugador jugador2 = new Jugador("Roberto");

        RespuestaOrderedChoice respuestaJugador1 = new RespuestaOrderedChoice();
        RespuestaOrderedChoice respuestaJugador2 = new RespuestaOrderedChoice();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();

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

        assertEquals(jugador1.obtenerPuntaje(), 1);
        assertEquals(jugador2.obtenerPuntaje(), 0);
    }

    @Test
    public void test03seCreaUnaPreguntaOrderedChoiceYSeVerificaLaCorrectaAsignacionDePuntos() {

        Jugador jugador1 = new Jugador("Santiago");
        Jugador jugador2 = new Jugador("Roberto");

        RespuestaOrderedChoice respuestaJugador1 = new RespuestaOrderedChoice();
        RespuestaOrderedChoice respuestaJugador2 = new RespuestaOrderedChoice();

        EnunciadosOpciones opcionesParaAgregarJugador1 = new EnunciadosOpciones();
        EnunciadosOpciones opcionesParaAgregarJugador2 = new EnunciadosOpciones();

        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(0, "Belgica");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(1, "Alemania");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(2, "Argentina");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(3, "Inglaterra");
        opcionesParaAgregarJugador1.agregarEnunciadoEidentificador(4, "Brasil");

        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (0, "Argentina");
        opcionesParaAgregarJugador2.agregarEnunciadoEidentificador (1, "Alemania");
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
}