package edu.fiuba.algo3.interfaz;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class EstilosBotonEnviarRespuesta extends ButtonSkin {

    public EstilosBotonEnviarRespuesta(Button boton) {
        super(boton);

        eventoMousePasaPorArriba(boton);

        boton.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setTextFill(Color.SLATEGRAY);

        boton.setFont(new Font("FreeSans", 35));
        boton.setPrefSize(500, 80);

    }

    private void eventoMousePasaPorArriba(Button boton) {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(1);
        boton.setOnMouseEntered(e -> fadeIn.playFromStart());

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.7);
        boton.setOnMouseExited(e -> fadeOut.playFromStart());

        boton.setOpacity(0.7);
    }
}
