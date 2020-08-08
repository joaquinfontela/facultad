package edu.fiuba.algo3.interfaz.estilos;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class EstilosBoton extends ButtonSkin {

    private Boolean seleccionado;

    public EstilosBoton(Button boton) {

        super(boton);
        seleccionado = false;

        eventoMousePasaPorArriba(boton);
        eventoBotonClickeado(boton);
    }


    private void eventoBotonClickeado(Button opcion) {

        opcion.setOnMouseClicked(e -> {

            if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
                switchSeleccionado(opcion);
            }
        });
    }

    private void eventoMousePasaPorArriba(Button opcion) {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(opcion);
        fadeIn.setToValue(0.8);
        opcion.setOnMouseEntered(e -> {
            if (! seleccionado) {
                fadeIn.playFromStart();
            }
        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(opcion);
        fadeOut.setToValue(0.6);
        opcion.setOnMouseExited(e -> {
            if (! seleccionado) {
                fadeOut.playFromStart();
            }
        });

        opcion.setOpacity(0.6);
    }

    public void switchSeleccionado(Button opcion) {

        if (seleccionado) {
            seleccionado = false;
        } else {
            seleccionado = true;
            opcion.setOpacity(1);
        }
    }
}
