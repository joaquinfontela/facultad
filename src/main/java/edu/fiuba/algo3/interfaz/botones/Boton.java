package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.control.Button;

public abstract class Boton extends Button {

    private TipoBoton tipo;

    protected Boton(TipoBoton tipo) {

        this.tipo = tipo;
    }

    public Boolean fueSeleccionado() throws Exception {

        return tipo.fueSeleccionado();
    }

    public TipoBoton getTipo() {

        return tipo;
    }
}