package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonVolverAlInicio;

public class BotonVolverAlMenu extends BotonComun {

    public BotonVolverAlMenu() {
        this.setSkin(new EstilosBotonVolverAlInicio(this));
    }
}
