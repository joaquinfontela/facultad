package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonSeAcaboElTiempo;
import javafx.scene.control.Button;

public class BotonSeAcaboElTiempo extends Button {

    public BotonSeAcaboElTiempo() {

        this.setSkin(new EstilosBotonSeAcaboElTiempo(this));
    }
}
