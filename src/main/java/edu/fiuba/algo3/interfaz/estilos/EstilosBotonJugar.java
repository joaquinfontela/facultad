package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.paint.Color;

public class EstilosBotonJugar extends EstilosBoton {

    public EstilosBotonJugar(Boton unBoton){

        super(unBoton);
        boton.setText("JUGAR");
        boton.setTextFill(Color.web("2D06A2"));
        boton.setPrefSize(800, 50);
        boton.setStyle("-fx-background-color: orange; -fx-font-size: 120px; -fx-border-color: orange;" +
                "-fx-border-radius: 40px; -fx-border-width: 40px");
    }
}
