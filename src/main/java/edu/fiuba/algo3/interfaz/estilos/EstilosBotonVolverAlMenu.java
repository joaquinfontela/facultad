package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class EstilosBotonVolverAlMenu extends EstilosBoton{
    public EstilosBotonVolverAlMenu(Boton unBoton) {
        super(unBoton);
        boton.setText("Volver al Menu!");
        boton.setTextFill(Color.WHITE);
        boton.setPrefSize(500, 100);
        boton.setStyle("-fx-background-color: black; -fx-font-size: 50px; -fx-border-color: black;" +
                "-fx-border-radius: 40px; -fx-border-width: 5px");
    }
    @Override
    protected void eventoMousePasaPorArriba() {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(1.0);
        boton.setOnMouseEntered(e -> {
            if (!boton.fueSeleccionado()) {
                fadeIn.playFromStart();
            }
        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.8);
        boton.setOnMouseExited(e -> {
            if (!boton.fueSeleccionado()) {
                fadeOut.playFromStart();
            }
        });

       // boton.setOpacity(0.8); ¿sirve para algo wey?
    }
}

