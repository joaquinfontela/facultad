package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.paint.Color;

public class EstilosBotonSeAcaboElTiempo extends EstilosBoton {

    public EstilosBotonSeAcaboElTiempo(Boton boton) {

        super(boton);
        boton.setText("Seguir Jugando");
        boton.setTextFill(Color.BLACK);
        boton.setPrefSize(600, 50);
        boton.setStyle("-fx-background-color: transparent; -fx-font-size: 50px; -fx-border-color: black;" +
                "-fx-border-radius: 10px; -fx-border-width: 10px");
    }
}