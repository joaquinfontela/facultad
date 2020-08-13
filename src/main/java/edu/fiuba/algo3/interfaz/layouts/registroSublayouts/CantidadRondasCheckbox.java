package edu.fiuba.algo3.interfaz.layouts.registroSublayouts;

import javafx.scene.control.CheckBox;

public class CantidadRondasCheckbox extends CheckBox {

    public CantidadRondasCheckbox(String enunciado) {

        super();
        this.setPrefSize(100, 100);
        this.setText(enunciado);
        this.setStyle("-fx-font-size: 50px");
    }
}