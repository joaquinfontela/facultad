package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.paint.Color;

public class EstilosBotonPuntajesParciales extends EstilosBoton {

    public EstilosBotonPuntajesParciales(Boton unBoton) {

        super(unBoton);
        boton.setText("CONTINUAR");
        boton.setTextFill(Color.GOLDENROD);
        boton.setPrefSize(450, 50);
        boton.setStyle("-fx-background-color: transparent; -fx-font-size: 50px; -fx-border-color: goldenrod;" +
                "-fx-border-radius: 10px; -fx-border-width: 10px");
    }
}
