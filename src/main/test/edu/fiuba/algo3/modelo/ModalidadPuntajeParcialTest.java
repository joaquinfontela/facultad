package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.modalidad.ModalidadPuntajeParcial;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.respuesta.EstadisticasRespuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalidadPuntajeParcialTest {

    ModalidadPuntajeParcial modalidad;
    HashMap<Integer, EstadisticasRespuesta> diccionarioIdEstadisticas;
    EstadisticasRespuesta estadisticasJugadorUno;
    EstadisticasRespuesta estadisticasJugadorDos;
    ExclusividadDePuntaje exclusividad;

    @BeforeEach
    public void init() {

        modalidad = new ModalidadPuntajeParcial();
        diccionarioIdEstadisticas = new HashMap<Integer, EstadisticasRespuesta>();
        estadisticasJugadorUno = new EstadisticasRespuesta();
        estadisticasJugadorDos = new EstadisticasRespuesta();
        exclusividad = new ExclusividadDePuntaje();
    }

    @Test
    public void test01SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientes() {

        for (int i = 0; i < 3; i++){
            estadisticasJugadorUno.sumarCorrectaElegida();
            estadisticasJugadorDos.sumarCorrectaElegida();
        }
        estadisticasJugadorDos.sumarIncorrectaElegida();

        diccionarioIdEstadisticas.put(1, estadisticasJugadorUno);
        diccionarioIdEstadisticas.put(2, estadisticasJugadorDos);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioIdEstadisticas);
        assertEquals(puntajes.get(1),3);
        assertEquals(puntajes.get(2),0);
    }

    @Test
    public void test02SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientesConExclusividad() {

        modalidad.recibirBonificacion(exclusividad);

        for (int i = 0; i < 3; i++){
            estadisticasJugadorUno.sumarCorrectaElegida();
            estadisticasJugadorDos.sumarCorrectaElegida();
        }
        estadisticasJugadorDos.sumarIncorrectaElegida();

        diccionarioIdEstadisticas.put(1, estadisticasJugadorUno);
        diccionarioIdEstadisticas.put(2, estadisticasJugadorDos);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioIdEstadisticas);
        assertEquals(puntajes.get(1),6);
        assertEquals(puntajes.get(2),0);
    }

    @Test
    public void test03SeCreaUnaRespuestaCorrectaMultipleYOtraIncorrectaMultipleYSeVerificanLosPuntajesCorrespondientesConExclusividadDoble() {

        modalidad.recibirBonificacion(exclusividad);
        modalidad = new ModalidadPuntajeParcial();
        modalidad.recibirBonificacion(exclusividad);

        for (int i = 0; i < 3; i++){
            estadisticasJugadorUno.sumarCorrectaElegida();
            estadisticasJugadorDos.sumarCorrectaElegida();
        }
        estadisticasJugadorDos.sumarIncorrectaElegida();

        diccionarioIdEstadisticas.put(1, estadisticasJugadorUno);
        diccionarioIdEstadisticas.put(2, estadisticasJugadorDos);

        HashMap<Integer,Integer> puntajes = modalidad.obtenerPuntajesPorJugador(diccionarioIdEstadisticas);
        assertEquals(puntajes.get(1),6);
        assertEquals(puntajes.get(2),0);
    }
}