package edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonComun;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class EstilosBotonVolverAlMenu extends EstilosBotonComun {

    public EstilosBotonVolverAlMenu(Button unBoton) {
        super(unBoton);
        boton.setText("Volver al Menu!");
        boton.setTextFill(Color.WHITE);
        boton.setPrefSize(500, 100);
        boton.setStyle("-fx-background-color: black; -fx-font-size: 50px; -fx-border-color: black;" +
                "-fx-border-radius: 40px; -fx-border-width: 5px");
    }
}

