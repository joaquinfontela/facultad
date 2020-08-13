package edu.fiuba.algo3.interfaz.layouts.registroSublayouts;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class LayoutRegistroJugadores extends StackPane {

    private TextFieldJugador textFieldJugador1;
    private TextFieldJugador textFieldJugador2;

    public LayoutRegistroJugadores() {

        this.agregarTituloJugador1();
        this.agregarTituloJugador2();
        this.agregarTextFields();
    }

    private void agregarTituloJugador1() {

        Label tituloJugador1 = new Label("JUGADOR 1");
        tituloJugador1.setFont(new Font("KacstPoster", 50));
        tituloJugador1.setTranslateX(-350.0);
        tituloJugador1.setTranslateY(50.0);
        tituloJugador1.setStyle("-fx-text-fill: black");
        this.getChildren().add(tituloJugador1);
    }

    private void agregarTituloJugador2() {

        Label tituloJugador2 = new Label("JUGADOR 2");
        tituloJugador2.setFont(new Font("KacstPoster", 50));
        tituloJugador2.setTranslateX(-350.0);
        tituloJugador2.setTranslateY(200.0);
        tituloJugador2.setStyle("-fx-text-fill: black");
        this.getChildren().add(tituloJugador2);
    }

    private void agregarTextFields() {

        textFieldJugador1 = new TextFieldJugador();
        textFieldJugador1.setTranslateX(250.0);
        textFieldJugador1.setTranslateY(50.0);
        this.getChildren().add(textFieldJugador1);

        textFieldJugador2 = new TextFieldJugador();
        textFieldJugador2.setTranslateX(250.0);
        textFieldJugador2.setTranslateY(200.0);
        this.getChildren().add(textFieldJugador2);
    }
}