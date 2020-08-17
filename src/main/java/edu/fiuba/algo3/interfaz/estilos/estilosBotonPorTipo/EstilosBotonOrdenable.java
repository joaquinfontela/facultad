package edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.animation.FadeTransition;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class EstilosBotonOrdenable implements EstilosBotonPorTipo {

    protected Boton boton;
    protected Ordenable ordenable;

    public void aplicarEstilos(Boton unBoton) {

        boton = unBoton;
        ordenable = (Ordenable) boton.getTipo();

        eventoMousePasaPorArriba();
        eventoBotonClickeado();
    }

    public void eventoMousePasaPorArriba() {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(0.8);
        boton.setOnMouseEntered(e -> {
            fadeIn.playFromStart();

        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.6);
        boton.setOnMouseExited(e -> {
            fadeOut.playFromStart();
        });

        boton.setOpacity(0.6);
    }

    public void eventoBotonClickeado() {

        boton.setOnMouseClicked(e -> {

            if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
                if (ordenable.getPosicionOrden() == null) {
                    ordenable.asignarOrden();
                } else {
                    ordenable.desasignarOrden();
                }
            }
        });
    }

    public void actualizarOrden() {

        if (ordenable.getPosicionOrden() == null) {
            boton.setText(boton.getText().substring(0, boton.getText().length() - 4));
        } else {
            boton.setText(boton.getText() + " (" + ordenable.getPosicionOrden().toString() + ")");
        }
    }

}
