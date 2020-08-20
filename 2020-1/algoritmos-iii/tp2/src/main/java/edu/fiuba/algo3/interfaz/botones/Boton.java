package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.control.Button;

import java.util.ArrayList;

public abstract class Boton extends Button {

    protected TipoBoton tipo;

    protected Boton(TipoBoton tipo) {

        this.tipo = tipo;
    }

    protected Boton(TipoBoton tipo, ArrayList<BotonOpcion> botones) {

        this.tipo = tipo;
        this.tipo.agregarBotones(botones);
    }

    public TipoBoton getTipo() {

        return tipo;
    }
}