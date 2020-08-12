package edu.fiuba.algo3.interfaz.layouts;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class LayoutInicio {

    private StackPane layout;

    public LayoutInicio() {

        layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void crearLayout() {

        Button botonContinuar = new Button();
        layout.getChildren().add(botonContinuar);
    }

    public StackPane getLayout() {

        this.crearLayout();
        return layout;
    }
}
