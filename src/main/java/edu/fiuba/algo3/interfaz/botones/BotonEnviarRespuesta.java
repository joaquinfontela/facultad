package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonEnviarRespuesta;
import javafx.scene.control.Button;

public class BotonEnviarRespuesta extends Boton {

    public BotonEnviarRespuesta() {

        super();
        boton.setTranslateY(160.0);
        boton.setSkin(new EstilosBotonEnviarRespuesta(this));
    }
}
