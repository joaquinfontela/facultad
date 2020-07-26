package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RespuestaVerdaderoFalsoTest {

    @Test
    public void test01creoDosRespuestasYLasComparoEsperandoObtenerUnaCorrectaElegida() {

        EnunciadosOpciones enunciadosOpcionesRespuestaCorrecta = new EnunciadosOpciones();
        EnunciadosOpciones enunciadosOpcionesRespuestaRecibida = new EnunciadosOpciones();

        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(0, "Falso");
        enunciadosOpcionesRespuestaCorrecta.agregarEnunciadoEidentificador(1, "Verdadero");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(0, "Falso");
        enunciadosOpcionesRespuestaRecibida.agregarEnunciadoEidentificador(1, "Verdadero");

        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso();
        respuestaCorrecta.rellenar(enunciadosOpcionesRespuestaCorrecta);
        RespuestaVerdaderoFalso respuestaRecibida = new RespuestaVerdaderoFalso();
        respuestaRecibida.rellenar(enunciadosOpcionesRespuestaRecibida);

        EstadisticasRespuestas estadisticasComparacion = respuestaCorrecta.compararCon(respuestaRecibida);

        assertEquals(estadisticasComparacion.obtenerOpcionesCorrectasElegidas(), 1);

    }
}
