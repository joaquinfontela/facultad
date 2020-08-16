package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonPreturno;
import javafx.scene.control.Button;

public class BotonPreturno extends Button {

    public BotonPreturno() {

        this.setSkin(new EstilosBotonPreturno(this));

    }
}
