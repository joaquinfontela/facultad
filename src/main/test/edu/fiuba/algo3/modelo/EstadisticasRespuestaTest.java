package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadisticasRespuestaTest {

    @Test
    public void test01SeVerificaQueHayRespuestasIncorrectasyCorrectasSinEligir(){

        EstadisticasRespuesta estadisticas = new EstadisticasRespuesta();
        estadisticas.sumarCorrectaNoElegida();
        estadisticas.sumarIncorrectaElegida();
        assert(estadisticas.hayOpcionesIncorrectas());
        assert(estadisticas.hayOpcionesCorrectasNoElegidas());
    }

    @Test
    public void test02SeSumaUnaRespuestaCorrectaYUnaIncorectaYLaDiferenciaEsNula(){

        EstadisticasRespuesta estadisticas = new EstadisticasRespuesta();
        estadisticas.sumarCorrectaElegida();
        estadisticas.sumarIncorrectaElegida();
        assertEquals(estadisticas.calcularPuntajePenalidadBase(), 0);
    }
}
