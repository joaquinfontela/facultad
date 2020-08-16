package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonSeAcaboElTiempo;

public class BotonSeAcaboElTiempo extends Boton {

    public BotonSeAcaboElTiempo() {

        super();
        this.setSkin(new EstilosBotonSeAcaboElTiempo(this));

        this.setOnMouseClicked(e -> {
            System.out.println("CONTINUAR");
        });
    }
}
