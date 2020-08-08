package edu.fiuba.algo3.interfaz.estilos;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class EstilosBotonEnviarRespuesta extends EstilosBoton {

    public EstilosBotonEnviarRespuesta(Button boton) {
        super(boton);

        boton.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setTextFill(Color.SLATEGRAY);

        boton.setFont(new Font("FreeSans", 35));
        boton.setPrefSize(500, 80);

        boton.setOnMouseClicked(e -> {
            System.out.println("RESPUESTA ENVIADA!");
        });
    }
}
