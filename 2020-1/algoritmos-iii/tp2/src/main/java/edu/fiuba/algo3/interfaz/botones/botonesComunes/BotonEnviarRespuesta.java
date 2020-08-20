package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonEnviarRespuesta;

public class BotonEnviarRespuesta extends BotonComun {

    public BotonEnviarRespuesta() {

        this.setTranslateY(160.0);
        this.setSkin(new EstilosBotonEnviarRespuesta(this));

    }
}