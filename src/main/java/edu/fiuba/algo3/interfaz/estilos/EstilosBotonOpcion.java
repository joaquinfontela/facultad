package edu.fiuba.algo3.interfaz.estilos;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class EstilosBotonOpcion extends ButtonSkin {

    private boolean seleccionado;

    public EstilosBotonOpcion(Button opcion, Color color) {
        super(opcion);

        seleccionado = false;

        eventoMousePasaPorArriba(opcion);
        eventoBotonClickeado(opcion);

        opcion.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        opcion.setTextFill(Color.ORANGE);

        opcion.setFont(new Font("FreeSans", 55));
        opcion.setPrefSize(350, 100);

    }

    private void eventoBotonClickeado(Button opcion) {

        opcion.setOnMouseClicked(e -> {

            if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
                switchSeleccionado();
            }
        });
    }

    private void eventoMousePasaPorArriba(Button opcion) {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(opcion);
        fadeIn.setToValue(1);
        opcion.setOnMouseEntered(e -> fadeIn.playFromStart());

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(opcion);
        fadeOut.setToValue(0.7);
        opcion.setOnMouseExited(e -> {
            if (! seleccionado) {
                fadeOut.playFromStart();
            }
        });

        opcion.setOpacity(0.7);
    }

    public void switchSeleccionado() {

        if (seleccionado) {
            seleccionado = false;
        } else {
            seleccionado = true;
        }
    }
}
