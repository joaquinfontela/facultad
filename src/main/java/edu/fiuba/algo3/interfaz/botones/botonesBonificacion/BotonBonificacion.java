package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonSeleccionableHandler;
import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;

public abstract class BotonBonificacion extends Boton {

    public BotonBonificacion(double posX, double posY) {

        super(new Seleccionable());
        this.setPrefSize(100,100);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        this.setOnAction(new BotonSeleccionableHandler(this));
    }

    public boolean fueSeleccionado() {

        Seleccionable tipoSeleccionable = (Seleccionable) this.tipo;
        return tipoSeleccionable.fueSeleccionado();
    }
}