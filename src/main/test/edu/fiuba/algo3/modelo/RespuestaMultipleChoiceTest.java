package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RespuestaMultipleChoiceTest {

    // pregunta: de los siguientes, que colores son primarios?

    EnunciadosOpciones enunciadosOpcionesRespuestaCorrecta;
    EnunciadosOpciones enunciadosOpcionesRespuestaRecibida;
    RespuestaMultipleChoice respuestaCorrecta;
    RespuestaMultipleChoice respuestaRecibida;

    @BeforeEach
    public void init() {

        //cC

        enunciadosOpcionesRespuestaCorrecta = new EnunciadosOpciones();
        enunciadosOpcionesRespuestaRecibida = new EnunciadosOpciones();

        respuestaCorrecta = new RespuestaMultipleChoice();
        respuestaRecibida = new RespuestaMultipleChoice();

        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(1, "Azul");
        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(1, "Rojo");
        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(1, "Amarillo");
        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(0, "Negro");
        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(0, "Verde");

        respuestaCorrecta.rellenar(enunciadosOpcionesRespuestaCorrecta);
    }

    @Test
    public void test01CreoDosRespuestasYLasComparoEsperandoObtenerTresCorrectas() {

        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Rojo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Azul");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Amarillo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Negro");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Verde");

        respuestaRecibida.rellenar(enunciadosOpcionesRespuestaRecibida);

        EstadisticasRespuesta estadisticasComparacion = respuestaCorrecta.compararCon(respuestaRecibida);

        assertEquals(estadisticasComparacion.obtenerOpcionesCorrectasElegidas(), 3);
        assertFalse(estadisticasComparacion.hayOpcionesCorrectasNoElegidas());
        assertFalse(estadisticasComparacion.hayOpcionesIncorrectas());
    }

    @Test
    public void test03CreoDosRespuestasYLasComparoEsperandoObtenerDosCorrectasIncorrectasYCorrectasNoElegidas() {

        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Rojo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Azul");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Amarillo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Negro");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Verde");

        respuestaRecibida.rellenar(enunciadosOpcionesRespuestaRecibida);

        EstadisticasRespuesta estadisticasComparacion = respuestaCorrecta.compararCon(respuestaRecibida);

        assertEquals(estadisticasComparacion.obtenerOpcionesCorrectasElegidas(), 2);
        assert(estadisticasComparacion.hayOpcionesCorrectasNoElegidas());
        assert(estadisticasComparacion.hayOpcionesIncorrectas());
    }

    @Test
    public void test03CreoDosRespuestasYLasComparoEsperandoObtenerDosCorrectasYCorrectasNoElegidas() {

        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Rojo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Azul");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Amarillo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Negro");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Verde");

        respuestaRecibida.rellenar(enunciadosOpcionesRespuestaRecibida);

        EstadisticasRespuesta estadisticasComparacion = respuestaCorrecta.compararCon(respuestaRecibida);

        assertEquals(estadisticasComparacion.obtenerOpcionesCorrectasElegidas(), 2);
        assert(estadisticasComparacion.hayOpcionesCorrectasNoElegidas());
        assertFalse(estadisticasComparacion.hayOpcionesIncorrectas());
    }

    @Test
    public void test04CreoDosRespuestasYLasComparoEsperandoIncorrectasYCorrectasNoElegidas() {

        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Rojo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Azul");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Amarillo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Negro");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Verde");

        respuestaRecibida.rellenar(enunciadosOpcionesRespuestaRecibida);

        EstadisticasRespuesta estadisticasComparacion = respuestaCorrecta.compararCon(respuestaRecibida);

        assertEquals(estadisticasComparacion.obtenerOpcionesCorrectasElegidas(), 0);
        assert(estadisticasComparacion.hayOpcionesCorrectasNoElegidas());
        assert(estadisticasComparacion.hayOpcionesIncorrectas());
    }

    @Test
    public void test05CreoDosRespuestasYLasComparoEsperandoObtenerUnaCorrectaIncorrectasYCorrectasNoElegidas() {

        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Rojo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Azul");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Amarillo");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Negro");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Verde");

        respuestaRecibida.rellenar(enunciadosOpcionesRespuestaRecibida);

        EstadisticasRespuesta estadisticasComparacion = respuestaCorrecta.compararCon(respuestaRecibida);

        assertEquals(estadisticasComparacion.obtenerOpcionesCorrectasElegidas(), 1);
        assert(estadisticasComparacion.hayOpcionesCorrectasNoElegidas());
        assert(estadisticasComparacion.hayOpcionesIncorrectas());
    }

}

