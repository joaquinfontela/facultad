package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalidadClasicaTest {

    ModalidadClasica modalidad;
    HashMap<Integer, EstadisticasRespuestas> diccionarioIdEstadisticas;
    EstadisticasRespuestas estadisticasJugadorUno;
    EstadisticasRespuestas estadisticasJugadorDos;
    ExclusividadDePuntaje exclusividad;

    @BeforeEach
    public void init(){

        modalidad = new ModalidadClasica();
        diccionarioIdEstadisticas = new HashMap<Integer, EstadisticasRespuestas>();
        estadisticasJugadorUno = new EstadisticasRespuestas();
        estadisticasJugadorDos = new EstadisticasRespuestas();
        exclusividad = new ExclusividadDePuntaje();
    }

    @Test
    public void test01SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientes(){

        estadisticasJugadorUno.sumarCorrectaElegida();
        diccionarioIdEstadisticas.put(1, estadisticasJugadorUno);

        estadisticasJugadorDos.sumarIncorrectaElegida();
        diccionarioIdEstadisticas.put(2, estadisticasJugadorDos);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioIdEstadisticas);
        assertEquals(puntajes.get(1),1);
        assertEquals(puntajes.get(2),0);
    }

    @Test
    public void test02SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientesConExlusividad(){

        estadisticasJugadorUno.sumarCorrectaElegida();
        diccionarioIdEstadisticas.put(1, estadisticasJugadorUno);

        estadisticasJugadorDos.sumarIncorrectaElegida();
        diccionarioIdEstadisticas.put(2, estadisticasJugadorDos);

        modalidad.recibirBonificacion(exclusividad);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioIdEstadisticas);
        assertEquals(puntajes.get(1),2);
        assertEquals(puntajes.get(2),0);
    }

    @Test
    public void test03SeCreaDosRespuestasCorrectasYLaExclusividadNoAfecta(){

        estadisticasJugadorUno.sumarCorrectaElegida();
        diccionarioIdEstadisticas.put(1, estadisticasJugadorUno);

        estadisticasJugadorDos.sumarCorrectaElegida();
        diccionarioIdEstadisticas.put(2, estadisticasJugadorDos);

        modalidad.recibirBonificacion(exclusividad);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioIdEstadisticas);
        assertEquals(puntajes.get(1),1);
        assertEquals(puntajes.get(2),1);
    }

    @Test
    public void test04SeCreaDosRespuestasIncorrectasYLaExclusividadNoAfecta(){

        estadisticasJugadorUno.sumarIncorrectaElegida();
        diccionarioIdEstadisticas.put(1, estadisticasJugadorUno);

        estadisticasJugadorDos.sumarIncorrectaElegida();
        diccionarioIdEstadisticas.put(2, estadisticasJugadorDos);

        modalidad.recibirBonificacion(exclusividad);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioIdEstadisticas);
        assertEquals(puntajes.get(1),0);
        assertEquals(puntajes.get(2),0);
    }


    @Test
    public void test05SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientesConExlusividadDoble(){

        estadisticasJugadorUno.sumarCorrectaElegida();
        diccionarioIdEstadisticas.put(1, estadisticasJugadorUno);

        estadisticasJugadorDos.sumarIncorrectaElegida();
        diccionarioIdEstadisticas.put(2, estadisticasJugadorDos);

        modalidad.recibirBonificacion(exclusividad);
        exclusividad = new ExclusividadDePuntaje();
        modalidad.recibirBonificacion(exclusividad);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioIdEstadisticas);
        assertEquals(puntajes.get(1),4);
        assertEquals(puntajes.get(2),0);
    }
}