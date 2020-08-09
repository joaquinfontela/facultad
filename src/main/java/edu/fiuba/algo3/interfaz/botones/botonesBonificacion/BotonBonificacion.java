package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.control.Button;

public abstract class BotonBonificacion extends Boton {

    public BotonBonificacion(double posX, double posY) {

        super();
        boton.setPrefSize(110,110);
        boton.setTranslateX(posX);
        boton.setTranslateY(posY);
    }
}
