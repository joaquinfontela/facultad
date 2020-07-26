package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RespuestaVerdaderoFalsoTest {

    EnunciadosOpciones enunciadosOpcionesRespuestaCorrecta;
    EnunciadosOpciones enunciadosOpcionesRespuestaRecibida;
    RespuestaVerdaderoFalso respuestaCorrecta;
    RespuestaVerdaderoFalso respuestaRecibida;

    @BeforeEach
    public void init() {

        enunciadosOpcionesRespuestaCorrecta = new EnunciadosOpciones();
        enunciadosOpcionesRespuestaRecibida = new EnunciadosOpciones();

        respuestaCorrecta = new RespuestaVerdaderoFalso();
        respuestaRecibida = new RespuestaVerdaderoFalso();
    }

    @Test
    public void test01creoDosRespuestasYLasComparoEsperandoObtenerUnaCorrectaElegida() {

        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(0, "Falso");
        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(1, "Verdadero");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Falso");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Verdadero");

        respuestaCorrecta.rellenar(enunciadosOpcionesRespuestaCorrecta);
        respuestaRecibida.rellenar(enunciadosOpcionesRespuestaRecibida);

        EstadisticasRespuesta estadisticasComparacion = respuestaCorrecta.compararCon(respuestaRecibida);

        assertEquals(estadisticasComparacion.obtenerOpcionesCorrectasElegidas(), 1);
        assertFalse(estadisticasComparacion.hayOpcionesCorrectasNoElegidas());
        assertFalse(estadisticasComparacion.hayOpcionesIncorrectas());
    }

    @Test
    public void test02creoDosRespuestasYLasComparoEsperandoObtenerUnaIncorrectaElegida() {

        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(0, "Verdadero");
        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(1, "Falso");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Falso");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Verdadero");

        respuestaCorrecta.rellenar(enunciadosOpcionesRespuestaCorrecta);
        respuestaRecibida.rellenar(enunciadosOpcionesRespuestaRecibida);

        EstadisticasRespuesta estadisticasComparacion = respuestaCorrecta.compararCon(respuestaRecibida);

        assertEquals(estadisticasComparacion.obtenerOpcionesCorrectasElegidas(), 0);
        assert(estadisticasComparacion.hayOpcionesIncorrectas());
        assertFalse(estadisticasComparacion.hayOpcionesCorrectasNoElegidas());
    }
}

