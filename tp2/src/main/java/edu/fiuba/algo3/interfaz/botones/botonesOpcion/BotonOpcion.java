package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;

import java.util.ArrayList;

public abstract class BotonOpcion extends Boton {

    public BotonOpcion(String enunciado, double posX, double posY, TipoBoton tipoBoton, ArrayList<BotonOpcion> botones) {

        super(tipoBoton, botones);
        this.setText(enunciado);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

    public Integer obtenerPosicionOrden() {

        Ordenable ordenable = (Ordenable) this.tipo;
        return ordenable.getPosicionOrden();
    }

    public void desasignarOrden() {

        Ordenable ordenable = (Ordenable) this.tipo;
        ordenable.desasignarOrden();
        this.tipo = ordenable;
    }
}