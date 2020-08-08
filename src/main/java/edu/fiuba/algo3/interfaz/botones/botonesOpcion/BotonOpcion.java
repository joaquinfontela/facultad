package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public abstract class BotonOpcion {

    protected Button boton;

    public BotonOpcion(String enunciado, double posX, double posY, Color color) {

        boton = new Button(enunciado);
        boton.setTranslateX(posX);
        boton.setTranslateY(posY);
    }

    public Button getBoton() {
        return boton;
    }

}
