package edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class EstilosBotonMultiplicadorX3 extends EstilosBotonMultiplicador {

    public EstilosBotonMultiplicadorX3(Boton manejadorDeBoton) {

        super(manejadorDeBoton);
        boton.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setText("X3");
    }
}
