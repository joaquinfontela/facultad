package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class EstilosBotonEnviarRespuesta extends EstilosBoton {

    public EstilosBotonEnviarRespuesta(Boton unBoton) {

        super(unBoton);

        boton.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setPrefSize(150, 75);

        Tic formaBoton = new Tic();
        boton.setShape(formaBoton);

        boton.setStyle("-fx-border-width: 2px; -fx-border-color: green");
    }
}