package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonRegistro;

public class BotonRegistro extends BotonComun {

    public BotonRegistro() {
        this.setSkin(new EstilosBotonRegistro(this));
    }
}
