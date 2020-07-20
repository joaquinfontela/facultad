package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalsoTest {

    @Test
    public void test01seCreaUnaPreguntaVerdaderoOFalsoYSeVerificaLaOpcionCorrecta() {

        ModalidadClasica modalidad = new ModalidadClasica();

        String enunciado = "El agua hierve a 100 C.";

        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("Verdadero");

        List<String> opcionesIncorrectas = new ArrayList<String>();
        opcionesIncorrectas.add("Falso");

        VerdaderoFalso pregunta = new VerdaderoFalso(modalidad, enunciado, opcionesCorrectas, opcionesIncorrectas);

        assertEquals(pregunta.obtenerOpcionesCorrectas().get(0).enunciado(), "Verdadero");

    }

}
