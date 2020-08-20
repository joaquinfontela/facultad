package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public abstract class AlertHandler implements EventHandler<ActionEvent> {

    public abstract void handle(ActionEvent event);

    protected void mostrarAlerta(Exception exception) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(exception.getMessage());
        alert.show();
    }
}
