package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.CantidadRondasCheckbox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Stack;

public class CheckboxRondaHandler implements EventHandler<ActionEvent> {

    Stack<Integer> cantidadRondas;
    private CantidadRondasCheckbox checkbox;

    public CheckboxRondaHandler(Stack<Integer> rondas, CantidadRondasCheckbox unCheckbox){

        cantidadRondas = rondas;
        checkbox = unCheckbox;
    }

    @Override
    public void handle(ActionEvent event) {

        if(checkbox.isSelected()) {
            cantidadRondas.push(Integer.parseInt(checkbox.getText()));
        } else {
            checkbox.setSelected(true);
        }
    }
}