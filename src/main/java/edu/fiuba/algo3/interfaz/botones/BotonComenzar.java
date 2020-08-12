package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonComenzar;

public class BotonComenzar extends Boton {

    public BotonComenzar() {

        super();
        this.setSkin(new EstilosBotonComenzar(this));

        this.setOnMouseClicked(e -> {
            System.out.println("COMENZAR");
        });
    }
}
