package edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.EstilosBotonComun;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class EstilosBotonJugar extends EstilosBotonComun {

    public EstilosBotonJugar(Button unBoton){

        super(unBoton);
        boton.setText("JUGAR");
        boton.setTextFill(Color.web("47178f"));
        boton.setPrefSize(625, 50);
        boton.setStyle("-fx-background-color: transparent; -fx-font-size: 120px; -fx-border-color: transparent;" +
                "-fx-border-radius: 10px; -fx-border-width: 10px");
    }
}
