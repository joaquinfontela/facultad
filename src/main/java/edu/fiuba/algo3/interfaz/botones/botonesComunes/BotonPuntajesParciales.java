package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonPuntajesParciales;

public class BotonPuntajesParciales extends BotonSeleccionable {

    public BotonPuntajesParciales() {

        super();
        this.setSkin(new EstilosBotonPuntajesParciales(this));

        this.setOnMouseClicked(e -> {
            System.out.println("CONTINUAR");
        });
    }
}
