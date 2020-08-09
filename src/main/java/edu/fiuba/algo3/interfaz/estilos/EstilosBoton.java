package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class EstilosBoton extends ButtonSkin {

    protected Button boton;
    protected Boton manejadorDeBoton;

    public EstilosBoton(Boton unManejadorDeBoton) {

        super(unManejadorDeBoton.getBoton());

        manejadorDeBoton = unManejadorDeBoton;
        boton = manejadorDeBoton.getBoton();

        eventoMousePasaPorArriba();
        eventoBotonClickeado();
    }

    private void eventoMousePasaPorArriba() {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(0.8);
        boton.setOnMouseEntered(e -> {
            if (!manejadorDeBoton.fueSeleccionado()) {
                fadeIn.playFromStart();
            }
        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.6);
        boton.setOnMouseExited(e -> {
            if (!manejadorDeBoton.fueSeleccionado()) {
                fadeOut.playFromStart();
            }
        });

        boton.setOpacity(0.6);
    }

    private void eventoBotonClickeado() {

        boton.setOnMouseClicked(e -> {

            if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
                manejadorDeBoton.switchSeleccionado();
                actualizarOpacidad();
            }
        });
    }

    private void actualizarOpacidad() {

        if (manejadorDeBoton.fueSeleccionado()) {
            boton.setOpacity(1.0);
        } else {
            boton.setOpacity(0.6);
        }
    }

}
