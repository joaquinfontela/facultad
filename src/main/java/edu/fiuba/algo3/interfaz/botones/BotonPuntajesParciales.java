package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonPuntajesParciales;

public class BotonPuntajesParciales extends Boton {

    public BotonPuntajesParciales() {

        super();
        this.setSkin(new EstilosBotonPuntajesParciales(this));

        this.setOnMouseClicked(e -> {
            System.out.println("CONTINUAR");
        });
    }
}
