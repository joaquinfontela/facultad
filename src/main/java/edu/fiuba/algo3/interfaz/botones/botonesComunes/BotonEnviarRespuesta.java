package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonEnviarRespuesta;
import javafx.scene.control.Button;

public class BotonEnviarRespuesta extends Button {

    public BotonEnviarRespuesta() {

        this.setTranslateY(160.0);
        this.setSkin(new EstilosBotonEnviarRespuesta(this));

    }
}