package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ContadorPregunta extends StackPane {

    ContadorPregunta(Integer numPreguntaActual, Integer numPreguntasTotales) {

        this.setMaxSize(100, 80);
        this.setMinSize(100, 80);
        this.setTranslateY(175.0);
        this.setStyle("-fx-border-color: gold; -fx-border-width: 2px");
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        int preguntaActual = numPreguntaActual;
        int preguntasTotales = numPreguntasTotales;

        Label textoContador = new Label(preguntaActual + " / " + preguntasTotales);
        textoContador.setTextFill(Color.GOLD);
        textoContador.setFont(new Font("KacstPoster", 30));

        this.getChildren().add(textoContador);
    }
}