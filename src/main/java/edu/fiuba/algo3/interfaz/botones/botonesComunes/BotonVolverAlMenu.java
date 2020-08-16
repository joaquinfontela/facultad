package edu.fiuba.algo3.interfaz.botones.botonesComunes;


import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonVolverAlMenu;
import javafx.scene.control.Button;

public class BotonVolverAlMenu extends BotonComun {

    public BotonVolverAlMenu() {
        this.setSkin(new EstilosBotonVolverAlMenu(this));
    }
}
