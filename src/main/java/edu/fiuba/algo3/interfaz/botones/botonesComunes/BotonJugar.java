package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonJugar;

public class BotonJugar extends BotonComun {

    public BotonJugar() {

        this.setSkin(new EstilosBotonJugar(this));
    }
}
