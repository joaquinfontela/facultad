package edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class EstilosBotonSeleccionable implements EstilosBotonPorTipo {

    protected Boton boton;
    protected Seleccionable seleccionable;

    public void aplicarEstilos(Boton unBoton) {

        boton = unBoton;
        seleccionable = (Seleccionable) boton.getTipo();

        eventoMousePasaPorArriba();
    }

    public void eventoMousePasaPorArriba() {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(0.8);
        boton.setOnMouseEntered(e -> {
            try {
                if (!seleccionable.fueSeleccionado()) {
                    fadeIn.playFromStart();
                }
            } catch (Exception exception) {
            }
        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.6);
        boton.setOnMouseExited(e -> {
            try {
                if (!seleccionable.fueSeleccionado()) {
                    fadeOut.playFromStart();
                }
            } catch (Exception exception) {
            }
        });

        boton.setOpacity(0.6);
    }
}