package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadisticasRespuestasTest {

    @Test
    public void test01SeVerificaQueHayRespuestasIncorrectasyCorrectasSinEligir(){

        EstadisticasRespuestas estadisticas = new EstadisticasRespuestas();
        estadisticas.sumarCorrectaNoElegida();
        estadisticas.sumarIncorrectaElegida();
        assert(estadisticas.hayOpcionesIncorrectas());
        assert(estadisticas.hayOpcionesCorrectasNoElegidas());
    }

    @Test
    public void test02SeSumaUnaRespuestaCorrectaYUnaIncorectaYLaDiferenciaEsNula(){

        EstadisticasRespuestas estadisticas = new EstadisticasRespuestas();
        estadisticas.sumarCorrectaElegida();
        estadisticas.sumarIncorrectaElegida();
        assertEquals(estadisticas.calcularPuntajePenalidadBase(), 0);
    }
}
