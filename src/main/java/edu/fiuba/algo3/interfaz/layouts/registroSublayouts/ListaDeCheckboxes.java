package edu.fiuba.algo3.interfaz.layouts.registroSublayouts;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class ListaDeCheckboxes extends ArrayList<CheckBox> {

    public ListaDeCheckboxes() {

        super();
    }

    @Override
    public boolean add(CheckBox checkBox) {

        boolean valorADevolver = super.add(checkBox);
        checkBox.setOnMouseClicked(e -> {
            for (CheckBox c : this){
                if (!c.equals(checkBox)) {
                    c.setSelected(false);
                }
            }
        });
        return valorADevolver;
    }
}