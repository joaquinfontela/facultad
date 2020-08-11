package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ContadorPregunta {

    StackPane layout;
    Label textoContador;
    Integer preguntaActual;
    Integer preguntasTotales;

    ContadorPregunta(Integer numPreguntaActual, Integer numPreguntasTotales) {

        layout = new StackPane();
        layout.setMaxSize(100, 80);
        layout.setMinSize(100, 80);
        layout.setTranslateY(175.0);
        layout.setStyle("-fx-border-color: gold; -fx-border-width: 2px");
        layout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        preguntaActual = numPreguntaActual;
        preguntasTotales = numPreguntasTotales;

        textoContador = new Label(preguntaActual.toString() + " / " + preguntasTotales.toString());
        textoContador.setTextFill(Color.GOLD);
        textoContador.setFont(new Font("KacstPoster", 30));

        layout.getChildren().add(textoContador);
    }

    public StackPane getLayout() {
        return layout;
    }
}