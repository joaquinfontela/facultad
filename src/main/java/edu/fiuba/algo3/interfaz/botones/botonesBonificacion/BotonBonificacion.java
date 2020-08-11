package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.control.Button;

public abstract class BotonBonificacion extends Boton {

    public BotonBonificacion(double posX, double posY) {

        super();
        this.setPrefSize(100,100);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
}