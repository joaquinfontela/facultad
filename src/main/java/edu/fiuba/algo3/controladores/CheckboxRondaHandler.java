package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.CantidadRondasCheckbox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Stack;

public class CheckboxRondaHandler implements EventHandler<ActionEvent> {

    private CantidadRondasCheckbox checkbox;

    public CheckboxRondaHandler(CantidadRondasCheckbox unCheckbox){
        checkbox = unCheckbox;
    }

    @Override
    public void handle(ActionEvent event) {
        if (!checkbox.isSelected()) checkbox.setSelected(true);
    }
}