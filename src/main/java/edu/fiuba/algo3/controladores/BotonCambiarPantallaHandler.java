package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonCambiarPantallaHandler implements EventHandler<ActionEvent> {

    protected Stage stage;
    protected Scene proximaEscena;

    public BotonCambiarPantallaHandler(Stage unStage, Scene scene) {

        stage = unStage;
        proximaEscena = scene;
    }

    @Override
    public void handle(ActionEvent event) {

        stage.setScene(proximaEscena);
    }
}