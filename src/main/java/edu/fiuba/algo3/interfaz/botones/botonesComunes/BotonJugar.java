package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonJugar;

public class BotonJugar extends BotonSeleccionable {

    public BotonJugar() {

        super();
        this.setSkin(new EstilosBotonJugar(this));

        this.setOnMouseClicked(e -> {
            System.out.println("JUGAR");
        });
    }
}
