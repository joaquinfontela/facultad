package edu.fiuba.algo3.interfaz.layouts.registroSublayouts;

import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class TextFieldJugador extends TextField {

    public TextFieldJugador() {

        super();
        this.setMaxSize(500, 80);
        this.setMinSize(500, 80);
        this.setFont(new Font("FreeSans", 30));
        this.setStyle("-fx-border-width: 3px; -fx-border-color: black; -fx-background-color: lightgray");
    }
}