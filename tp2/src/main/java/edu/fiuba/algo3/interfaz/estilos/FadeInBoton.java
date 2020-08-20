package edu.fiuba.algo3.interfaz.estilos;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class FadeInBoton {

    public FadeInBoton(Button boton, double opacidad) {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(opacidad);
        boton.setOnMouseEntered(e -> {
            fadeIn.playFromStart();
        });
    }
}
