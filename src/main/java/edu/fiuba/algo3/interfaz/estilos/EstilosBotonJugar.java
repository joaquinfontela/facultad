package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.paint.Color;

public class EstilosBotonJugar extends EstilosBoton {

    public EstilosBotonJugar(Boton unBoton){

        super(unBoton);
        boton.setText("JUGAR");
        boton.setTextFill(Color.BLUEVIOLET);
        boton.setPrefSize(450, 150);
        boton.setStyle("-fx-background-color: transparent; -fx-font-size: 75px; -fx-border-color: blueviolet;" +
                "-fx-border-radius: 40px; -fx-border-width: 5px");
    }
}
