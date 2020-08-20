package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;

public abstract class BotonComun extends Boton {

    public BotonComun() {

        super(new Seleccionable());
    }
}
