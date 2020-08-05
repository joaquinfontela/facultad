package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.interfaz.botones.BotonOpcion;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class LayoutOpciones {

    private StackPane layout;

    LayoutOpciones() {

        layout = new StackPane();
        agregarBotonEnviarRespuesta();
    }

    public void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY) {

        BotonOpcion opcion = new BotonOpcion(enunciado, desplazamientoEnX, desplazamientoEnY, Color.BLACK);
        layout.getChildren().add(opcion.getBoton());
    }

    public StackPane getLayout() {

        //distribuidor de opCiones segun si son 2, 3, etC.
        return layout;
    }

    private void agregarBotonEnviarRespuesta() {

        BotonEnviarRespuesta botonEnviarRespuesta = new BotonEnviarRespuesta();
        layout.getChildren().add(botonEnviarRespuesta.getBoton());
    }
}
