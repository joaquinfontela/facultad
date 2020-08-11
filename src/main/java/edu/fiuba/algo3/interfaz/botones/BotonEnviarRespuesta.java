package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonEnviarRespuesta;

public class BotonEnviarRespuesta extends Boton {

    public BotonEnviarRespuesta() {

        super();
        this.setTranslateY(160.0);
        this.setSkin(new EstilosBotonEnviarRespuesta(this));

        this.setOnMouseClicked(e -> {
            System.out.println("RESPUESTA ENVIADA!");
        });
    }
}