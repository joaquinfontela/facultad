package edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.animation.FadeTransition;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class EstilosBotonOrdenable implements EstilosBotonPorTipo {

    protected Boton boton;
    protected TipoBoton seleccionable;

    public void aplicarEstilos(Boton unBoton) {

        boton = unBoton;
        seleccionable = boton.getTipo();

        eventoMousePasaPorArriba();
        eventoBotonClickeado();
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
            } catch (Exception exception) { }
        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.6);
        boton.setOnMouseExited(e -> {
            try {
                if (!seleccionable.fueSeleccionado()) {
                    fadeOut.playFromStart();
                }
            } catch (Exception exception) { }
        });

        boton.setOpacity(0.6);
    }

    public void eventoBotonClickeado() {

        boton.setOnMouseClicked(e -> {

            if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
                try {
                    seleccionable.switchSeleccionado();
                    actualizarOpacidad();
                } catch (Exception exception) { }
            }
        });
    }

    private void actualizarOpacidad() throws Exception {

        if (seleccionable.fueSeleccionado()) {
            boton.setOpacity(1.0);
        } else {
            boton.setOpacity(0.6);
        }
    }
}
