package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;

public abstract class BotonBonificacion extends Boton {

    public BotonBonificacion(double posX, double posY) {

        super(new Seleccionable());
        this.setPrefSize(100,100);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
}