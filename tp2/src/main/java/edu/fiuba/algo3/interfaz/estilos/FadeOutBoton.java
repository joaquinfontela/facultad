package edu.fiuba.algo3.interfaz.estilos;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class FadeOutBoton {

    public FadeOutBoton(Button boton, double opacidad) {

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(opacidad);
        boton.setOnMouseExited(e -> {
            fadeOut.playFromStart();
        });
    }
}
