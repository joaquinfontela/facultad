package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonPreturno;

public class BotonPreturno extends Boton {

    public BotonPreturno() {

        super();
        this.setSkin(new EstilosBotonPreturno(this));

        this.setOnMouseClicked(e -> {
            System.out.println("CONTINUAR");
        });
    }
}
