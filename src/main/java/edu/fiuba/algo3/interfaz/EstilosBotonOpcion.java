package edu.fiuba.algo3.interfaz;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class EstilosBotonOpcion extends ButtonSkin {

    public EstilosBotonOpcion(Button opcion, Color color) {
        super(opcion);

        eventoMousePasaPorArriba(opcion);

        opcion.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        opcion.setTextFill(Color.SLATEGRAY);

        opcion.setFont(new Font("FreeSans", 55));
        opcion.setPrefSize(350, 100);
        
    }

    private void eventoMousePasaPorArriba(Button opcion) {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(opcion);
        fadeIn.setToValue(1);
        opcion.setOnMouseEntered(e -> fadeIn.playFromStart());

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(opcion);
        fadeOut.setToValue(0.7);
        opcion.setOnMouseExited(e -> fadeOut.playFromStart());

        opcion.setOpacity(0.7);
    }
}
