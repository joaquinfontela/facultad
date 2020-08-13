package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonExclusividad;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonMultiplicadorX2;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonMultiplicadorX3;
import javafx.scene.layout.StackPane;

public class LayoutBonificaciones extends StackPane {

    public LayoutBonificaciones() {

        this.getChildren().add(new BotonExclusividad(-50,-420));
        this.getChildren().add(new BotonMultiplicadorX2(-50, -285));
        this.getChildren().add(new BotonMultiplicadorX3(-50, -170));
    }
}