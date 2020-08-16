package edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.EstilosBotonComun;
import edu.fiuba.algo3.interfaz.estilos.Tic;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class EstilosBotonEnviarRespuesta extends EstilosBotonComun {

    public EstilosBotonEnviarRespuesta(Button unBoton) {

        super(unBoton);

        boton.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setPrefSize(150, 75);

        Tic formaBoton = new Tic();
        boton.setShape(formaBoton);

        boton.setStyle("-fx-border-width: 2px; -fx-border-color: green");
    }
}