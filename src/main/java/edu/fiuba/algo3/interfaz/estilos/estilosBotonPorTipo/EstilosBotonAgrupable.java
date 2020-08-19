package edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class EstilosBotonAgrupable implements EstilosBotonPorTipo {

    private Boton boton;
    private Agrupable agrupable;

    public void aplicarEstilos(Boton unBoton) {

        boton = unBoton;
        boton.setBackground(new Background(new BackgroundFill(Color.web("d8b97b"), CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setTextFill(Color.BLACK);
        agrupable = (Agrupable) boton.getTipo();

        eventoMousePasaPorArriba();
    }

    public void eventoMousePasaPorArriba() {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(1.0);
        boton.setOnMouseEntered(e -> {
            fadeIn.playFromStart();
        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.8);
        boton.setOnMouseExited(e -> {
            fadeOut.playFromStart();
        });

        boton.setOpacity(0.8);
    }
}
