package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonJugar;

public class BotonJugar extends Boton {

    public BotonJugar() {

        super();
        this.setSkin(new EstilosBotonJugar(this));

        this.setOnMouseClicked(e -> {
            System.out.println("JUGAR");
        });
    }
}
