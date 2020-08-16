package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.paint.Color;

public class EstilosBotonPreturno extends EstilosBoton {

    public EstilosBotonPreturno(Boton unBoton) {

        super(unBoton);
        boton.setText("CONTINUAR >>");
        boton.setTextFill(Color.WHITE);
        boton.setPrefSize(500, 100);
        boton.setStyle("-fx-background-color: transparent; -fx-font-size: 50px; -fx-border-color: white;" +
                       "-fx-border-radius: 40px; -fx-border-width: 5px");
    }
}