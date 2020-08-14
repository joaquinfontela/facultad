package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutRegistro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    public BotonJugarHandler(Stage unStage) {

        stage = unStage;
    }

    @Override
    public void handle(ActionEvent event) {

        LayoutRegistro layoutRegistro = new LayoutRegistro(stage);
        stage.setScene(new Scene(layoutRegistro, 640, 480));
    }
}
