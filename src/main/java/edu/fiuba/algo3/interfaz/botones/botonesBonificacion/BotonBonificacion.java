package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public abstract class BotonBonificacion {

    protected Button boton;

    public BotonBonificacion(double posX, double posY) {

        boton = new Button();
        boton.setPrefSize(110,110);
        boton.setTranslateX(posX);
        boton.setTranslateY(posY);
    }

    public Button getBoton() {

        return boton;
    }
}
