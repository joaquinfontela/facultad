package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadClasica;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuestas;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalidadClasicaTest {

    @Test
    public void test01SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientes(){
        ModalidadClasica modalidad = new ModalidadClasica();

        HashMap<Integer, EstadisticasRespuestas> diccionarioEstadisticas = new HashMap<Integer, EstadisticasRespuestas>();

        EstadisticasRespuestas estadisticasJugadorUno = new EstadisticasRespuestas();
        estadisticasJugadorUno.sumarCorrectaElegida();
        diccionarioEstadisticas.put(1, estadisticasJugadorUno);

        EstadisticasRespuestas estadisticasJugadorDos = new EstadisticasRespuestas();
        estadisticasJugadorDos.sumarIncorrectaElegida();
        diccionarioEstadisticas.put(2, estadisticasJugadorDos);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioEstadisticas);
        assertEquals(puntajes.get(1),1);
        assertEquals(puntajes.get(2),0);
    }

    @Test
    public void test02SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientesConExlusividad(){

        ModalidadClasica modalidad = new ModalidadClasica();

        HashMap<Integer, EstadisticasRespuestas> diccionarioEstadisticas = new HashMap<Integer, EstadisticasRespuestas>();

        EstadisticasRespuestas estadisticasJugadorUno = new EstadisticasRespuestas();
        estadisticasJugadorUno.sumarCorrectaElegida();
        diccionarioEstadisticas.put(1, estadisticasJugadorUno);

        EstadisticasRespuestas estadisticasJugadorDos = new EstadisticasRespuestas();
        estadisticasJugadorDos.sumarIncorrectaElegida();
        diccionarioEstadisticas.put(2, estadisticasJugadorDos);

        ExclusividadDePuntaje exclusividad = new ExclusividadDePuntaje();
        modalidad.recibirBonificacion(exclusividad);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioEstadisticas);
        assertEquals(puntajes.get(1),2);
        assertEquals(puntajes.get(2),0);
    }

    @Test
    public void test03SeCreaDosRespuestasCorrectasYLaExclusividadNoAfecta(){

        ModalidadClasica modalidad = new ModalidadClasica();

        HashMap<Integer, EstadisticasRespuestas> diccionarioEstadisticas = new HashMap<Integer, EstadisticasRespuestas>();

        EstadisticasRespuestas estadisticasJugadorUno = new EstadisticasRespuestas();
        estadisticasJugadorUno.sumarCorrectaElegida();
        diccionarioEstadisticas.put(1, estadisticasJugadorUno);

        EstadisticasRespuestas estadisticasJugadorDos = new EstadisticasRespuestas();
        estadisticasJugadorDos.sumarCorrectaElegida();
        diccionarioEstadisticas.put(2, estadisticasJugadorDos);

        ExclusividadDePuntaje exclusividad = new ExclusividadDePuntaje();
        modalidad.recibirBonificacion(exclusividad);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioEstadisticas);
        assertEquals(puntajes.get(1),1);
        assertEquals(puntajes.get(2),1);
    }
    @Test
    public void test04SeCreaUnaRespuestaCorrectaYOtraIncorrectaYSeVerificanLosPuntajesCorrespondientesConExlusividadDoble(){

        ModalidadClasica modalidad = new ModalidadClasica();

        HashMap<Integer, EstadisticasRespuestas> diccionarioEstadisticas = new HashMap<Integer, EstadisticasRespuestas>();

        EstadisticasRespuestas estadisticasJugadorUno = new EstadisticasRespuestas();
        estadisticasJugadorUno.sumarCorrectaElegida();
        diccionarioEstadisticas.put(1, estadisticasJugadorUno);

        EstadisticasRespuestas estadisticasJugadorDos = new EstadisticasRespuestas();
        estadisticasJugadorDos.sumarIncorrectaElegida();
        diccionarioEstadisticas.put(2, estadisticasJugadorDos);

        for(int i=0; i<2; i++){
            ExclusividadDePuntaje exclusividad = new ExclusividadDePuntaje();
            modalidad.recibirBonificacion(exclusividad);
        }

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioEstadisticas);
        assertEquals(puntajes.get(1),4);
        assertEquals(puntajes.get(2),0);
    }
}
