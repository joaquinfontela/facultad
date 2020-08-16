package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonEnviarRespuestaHandler extends BotonTerminarTurnoHandler {

    private LayoutPregunta layoutActual;

    public BotonEnviarRespuestaHandler(Stage unStage, GestorDeJuego unGestor, LayoutPregunta layout) {

        super(unStage, unGestor);
        layoutActual = layout;
    }

    @Override
    public void handle(ActionEvent event) {

        layoutActual.detenerTemporizador();
        this.cambiarEscena();
    }
}