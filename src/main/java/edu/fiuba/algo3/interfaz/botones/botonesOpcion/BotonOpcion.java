package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;

public abstract class BotonOpcion extends Boton {

    public BotonOpcion(String enunciado, double posX, double posY, TipoBoton tipoBoton) {

        super(tipoBoton);
        this.setText(enunciado);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
}