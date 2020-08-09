package edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class EstilosBotonMultiplicadorX2 extends EstilosBotonMultiplicador {

    public EstilosBotonMultiplicadorX2(Boton manejadorDeBoton) {

        super(manejadorDeBoton);
        boton.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setText("X2");
    }
}
