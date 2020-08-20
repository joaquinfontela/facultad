package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonSeAcaboElTiempo;

public class BotonSeAcaboElTiempo extends BotonComun {

    public BotonSeAcaboElTiempo() {

        this.setSkin(new EstilosBotonSeAcaboElTiempo(this));
    }
}
