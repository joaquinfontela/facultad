package edu.fiuba.algo3.interfaz;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPregunta {

    private BorderPane layout;
    private StackPane layoutEnunciado;
    private StackPane layoutOpciones;
    private StackPane layoutBottom;

    public LayoutPregunta() {

        layout = new BorderPane();
        layoutEnunciado = new StackPane();
        layoutOpciones = new StackPane();
        layoutBottom = new StackPane();

        layout.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        agregarLayoutBottom();
    }

     public void agregarEnunciadoDeLaPregunta(String enunciado){

        var enunciadoDeLaPregunta = new Label(enunciado);

        enunciadoDeLaPregunta.setTranslateY(75.0);
        enunciadoDeLaPregunta.setFont(new Font("FreeSans", 50));

        layoutEnunciado.getChildren().add(enunciadoDeLaPregunta);
        layout.setTop(layoutEnunciado);
    }

    public void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color){

        Button opcion = new Button();

        opcion.setSkin(new EstilosBotonOpcion(opcion, color));

        opcion.setText(enunciado);
        opcion.setTranslateX(desplazamientoEnX);
        opcion.setTranslateY(desplazamientoEnY);

        layoutOpciones.getChildren().add(opcion);
        layout.setCenter(layoutOpciones);
    }

    public BorderPane getLayout() {

        return layout;
    }

    private void agregarLayoutBottom() {

        Button botonEnviarRespuesta = new Button();

        botonEnviarRespuesta.setSkin(new EstilosBotonEnviarRespuesta(botonEnviarRespuesta));

        botonEnviarRespuesta.setText("ENVIAR RESPUESTA >>");
        botonEnviarRespuesta.setTranslateY(-75.0);

        layoutBottom.getChildren().add(botonEnviarRespuesta);
        layout.setBottom(layoutBottom);
    }
}
