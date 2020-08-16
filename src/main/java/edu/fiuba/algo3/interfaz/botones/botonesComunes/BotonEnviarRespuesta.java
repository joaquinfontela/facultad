package edu.fiuba.algo3.interfaz.botones.botonesComunes;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonesComunes.EstilosBotonEnviarRespuesta;

public class BotonEnviarRespuesta extends BotonSeleccionable {

    public BotonEnviarRespuesta() {

        super();
        this.setTranslateY(160.0);
        this.setSkin(new EstilosBotonEnviarRespuesta(this));

        this.setOnMouseClicked(e -> {
            System.out.println("RESPUESTA ENVIADA!");
        });
    }
}