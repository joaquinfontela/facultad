package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonPreturno;

public class BotonPreturno extends BotonSeleccionable {

    public BotonPreturno() {

        super();
        this.setSkin(new EstilosBotonPreturno(this));

        this.setOnMouseClicked(e -> {
            System.out.println("CONTINUAR");
        });
    }
}
