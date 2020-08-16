package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;

public abstract class BotonBonificacion extends BotonSeleccionable {

    public BotonBonificacion(double posX, double posY) {

        super();
        this.setPrefSize(100,100);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
}