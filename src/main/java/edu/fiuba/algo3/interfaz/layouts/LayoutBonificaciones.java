package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonExclusividad;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonMultiplicadorX2;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonMultiplicadorX3;
import javafx.scene.layout.StackPane;

public class LayoutBonificaciones {

    private StackPane layout;

    LayoutBonificaciones() {

        layout = new StackPane();
        layout.getChildren().add(new BotonExclusividad(-50,-625).getBoton());
        layout.getChildren().add(new BotonMultiplicadorX2(-50, -450).getBoton());
        layout.getChildren().add(new BotonMultiplicadorX3(-50, -300).getBoton());
    }

    public StackPane getLayout() {

        return layout;
    }
}
