package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonOpcion;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class BotonOpcion {

    private Button boton;

    public BotonOpcion(String enunciado, double posX, double posY, Color color) {

        boton = new Button(enunciado);
        boton.setTranslateX(posX);
        boton.setTranslateY(posY);

        boton.setSkin(new EstilosBotonOpcion(boton, color));
    }

    public Button getBoton() {
        return boton;
    }

}
