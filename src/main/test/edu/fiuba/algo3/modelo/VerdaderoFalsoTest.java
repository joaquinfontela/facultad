package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalsoTest {

    @BeforeEach
    void init() {

        ModalidadClasica modalidad = new ModalidadClasica();

        String enunciado = "El agua hierve a 100 C.";

        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("Verdadero");  // id opcion = 1

        List<String> opcionesIncorrectas = new ArrayList<String>();
        opcionesIncorrectas.add("Falso");   // id opcion = 2

        VerdaderoFalso pregunta = new VerdaderoFalso(modalidad, enunciado, opcionesCorrectas, opcionesIncorrectas);
    }


    @Test
    public void test01seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaOpcionCorrecta() {
        assertEquals(pregunta.obtenerOpcionesCorrectas().get(0).enunciado(), "Verdadero");
    }

    @Test
    public void test02seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaCorrectaAsignacionDePuntos() {

        // HACER CON MOCKITO!!!

        Jugador jugador1 = new Jugador("Santiago");
        Jugador jugador2 = new Jugador("Roberto");

        GestorDeJuego gestor = new GestorDeJuego();
        gestor.agregarJugador(jugador1);
        gestor.agregarJugador(jugador2);

        jugador1.setRespuestaADar(new ArrayList<String>(List.of(1)));

        gestor.obtenerRespuesta(jugador1);
        gestor.obtenerRespuesta(jugador2);
        
    }

}
