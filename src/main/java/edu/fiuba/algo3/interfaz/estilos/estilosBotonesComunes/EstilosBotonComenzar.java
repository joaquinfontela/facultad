package edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.EstilosBotonComun;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class EstilosBotonComenzar extends EstilosBotonComun {

    public EstilosBotonComenzar(Button unBoton) {

        super(unBoton);
        boton.setText("COMENZAR >>");
        boton.setTextFill(Color.BLACK);
        boton.setPrefSize(500, 100);
        boton.setStyle("-fx-background-color: transparent; -fx-font-size: 50px; -fx-border-color: black;" +
                "-fx-border-radius: 40px; -fx-border-width: 5px");
    }
}
