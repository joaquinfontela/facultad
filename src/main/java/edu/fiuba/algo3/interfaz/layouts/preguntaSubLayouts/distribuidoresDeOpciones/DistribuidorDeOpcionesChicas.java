package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChico;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaOrderedChoice;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.Stack;

public abstract class DistribuidorDeOpcionesChicas extends StackPane {

    protected void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color) {

        BotonOpcion opcion = new BotonOpcionChico(enunciado, desplazamientoEnX, desplazamientoEnY, color);
        this.getChildren().add(opcion);
    }
}