package edu.fiuba.algo3.interfaz.botones;


import edu.fiuba.algo3.interfaz.estilos.EstilosBotonVolverAlMenu;

public class BotonVolverAlMenu extends Boton {

    public BotonVolverAlMenu() {
        super();
        this.setSkin(new EstilosBotonVolverAlMenu(this));

        this.setOnMouseClicked(e -> {
            System.out.println("Volver Al Menu");
        });
    }
}
