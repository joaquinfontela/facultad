package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverAlMenuHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    public BotonVolverAlMenuHandler(Stage unStage) {
        stage = unStage;
    }

    @Override
    public void handle(ActionEvent event) {

        LayoutInicio layoutInicio = new LayoutInicio(stage);
        stage.setScene(new Scene(layoutInicio, 640, 480));
    }
}
