package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonComenzar;

public class BotonComenzar extends BotonSeleccionable {

    public BotonComenzar() {

        super();
        this.setSkin(new EstilosBotonComenzar(this));

        this.setOnMouseClicked(e -> {
            System.out.println("COMENZAR");
        });
    }
}
