package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.paint.Color;

public class EstilosBotonContinuar extends EstilosBoton {

    public EstilosBotonContinuar(Boton unBoton) {

        super(unBoton);
        boton.setText("CONTINUAR >>");
        boton.setTextFill(Color.ORANGE);
        boton.setPrefSize(500, 100);
        boton.setStyle("-fx-background-color: transparent; -fx-font-size: 50px; -fx-border-color: orange;" +
                       "-fx-border-radius: 40px; -fx-border-width: 5px");
    }
}
