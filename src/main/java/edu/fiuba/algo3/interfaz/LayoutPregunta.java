package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.interfaz.botones.BotonOpcion;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPregunta {

    private BorderPane layout;
    private StackPane layoutEnunciado;
    private StackPane layoutOpciones;

    public LayoutPregunta() {

        layout = new BorderPane();
        layoutEnunciado = new StackPane();
        layoutOpciones = new StackPane();

        agregarBotonEnviarRespuesta();
        layout.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

     public void agregarEnunciadoDeLaPregunta(String enunciado){

        var enunciadoDeLaPregunta = new Label(enunciado);

        enunciadoDeLaPregunta.setTranslateY(75.0);
        enunciadoDeLaPregunta.setFont(new Font("FreeSans", 50));

        layoutEnunciado.getChildren().add(enunciadoDeLaPregunta);
        layout.setTop(layoutEnunciado);
    }

    public void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color){

        BotonOpcion opcion = new BotonOpcion(enunciado, desplazamientoEnX, desplazamientoEnY, color);

        layoutOpciones.getChildren().add(opcion.getBoton());
        layout.setCenter(layoutOpciones);
    }

    public BorderPane getLayout() {

        return layout;
    }

    private void agregarBotonEnviarRespuesta() {

        BotonEnviarRespuesta botonEnviarRespuesta = new BotonEnviarRespuesta();

        layoutOpciones.getChildren().add(botonEnviarRespuesta.getBoton());
        layout.setCenter(layoutOpciones);
    }
}
