package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.layoutRegistro.LayoutRegistro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonInicioHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    public BotonInicioHandler(Stage unStage) {

        stage = unStage;
    }

    @Override
    public void handle(ActionEvent event) {

        LayoutRegistro layoutRegistro = new LayoutRegistro(stage);
        stage.setScene(new Scene(layoutRegistro, 640, 480));
    }
}
