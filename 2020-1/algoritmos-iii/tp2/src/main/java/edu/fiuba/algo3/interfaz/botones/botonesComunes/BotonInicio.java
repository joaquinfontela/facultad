package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonInicio;

public class BotonInicio extends BotonComun {

    public BotonInicio() {

        this.setSkin(new EstilosBotonInicio(this));
    }
}
