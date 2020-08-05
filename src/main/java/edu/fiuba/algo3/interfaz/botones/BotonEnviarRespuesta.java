package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.estilos.EstilosBotonEnviarRespuesta;
import javafx.scene.control.Button;

public class BotonEnviarRespuesta {

    private Button boton;

    public BotonEnviarRespuesta() {

        boton = new Button("ENVIAR RESPUESTA >>");
        boton.setTranslateY(-75.0);

        boton.setSkin(new EstilosBotonEnviarRespuesta(boton));
    }

    public Button getBoton() {

        return boton;
    }
}
