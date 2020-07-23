package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalidadClasicaTest {

    @Test
    public void test01SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientes(){

        ModalidadClasica modalidad = new ModalidadClasica();

        HashMap<Integer, EstadisticasRespuestas> idsJugadores_estadisticasRespuestas = new HashMap<Integer, EstadisticasRespuestas>();

        EstadisticasRespuestas estadisticasJugadorUno = new EstadisticasRespuestas();
        estadisticasJugadorUno.sumarCorrectaElegida();
        idsJugadores_estadisticasRespuestas.put(1, estadisticasJugadorUno);

        EstadisticasRespuestas estadisticasJugadorDos = new EstadisticasRespuestas();
        estadisticasJugadorDos.sumarIncorrectaElegida();
        idsJugadores_estadisticasRespuestas.put(2, estadisticasJugadorDos);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(idsJugadores_estadisticasRespuestas);
        assertEquals(puntajes.get(1),1);
        assertEquals(puntajes.get(2),0);
    }
}
