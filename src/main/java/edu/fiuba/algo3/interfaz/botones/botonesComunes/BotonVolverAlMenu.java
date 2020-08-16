package edu.fiuba.algo3.interfaz.botones.botonesComunes;


import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonVolverAlMenu;

public class BotonVolverAlMenu extends BotonSeleccionable {

    public BotonVolverAlMenu() {
        super();
        this.setSkin(new EstilosBotonVolverAlMenu(this));

        this.setOnMouseClicked(e -> {
            System.out.println("Volver Al Menu");
        });
    }
}
