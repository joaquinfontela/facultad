package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonSeAcaboElTiempo;

public class BotonSeAcaboElTiempo extends BotonSeleccionable {

    public BotonSeAcaboElTiempo() {

        super();
        this.setSkin(new EstilosBotonSeAcaboElTiempo(this));

        this.setOnMouseClicked(e -> {
            System.out.println("CONTINUAR");
        });
    }
}
