package edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class EstilosBotonMultiplicadorX2 extends EstilosBotonMultiplicador {

    public EstilosBotonMultiplicadorX2(Button boton) {

        super(boton);
        boton.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setText("X2");

        boton.setOnMouseClicked(e -> {
            System.out.println("MULTIPLICADOR X2 SELECCIONADO!");
        });
    }
}
