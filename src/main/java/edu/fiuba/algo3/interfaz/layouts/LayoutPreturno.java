package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.BotonContinuar;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPreturno {

    private StackPane layout;
    private BotonContinuar botonContinuar;
    private Label cartelProximoTurno;

    public LayoutPreturno(String nicknameJugadorProximoTurno) {

        layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));

        TextField textArea = new TextField();
        textArea.setMaxSize(1500, 300);
        textArea.setMinSize(1500, 300);
        textArea.setTranslateY(-85.0);
        textArea.setStyle("-fx-border-color: mediumpurple; -fx-background-color: transparent; -fx-border-width: 5px");
        layout.getChildren().add(textArea);

        agregarBotonContinuar();
        agregarTitulo();
        agregarNicknameProximoTurno(nicknameJugadorProximoTurno);
    }

    private void agregarBotonContinuar() {

        botonContinuar = new BotonContinuar();
        botonContinuar.setTranslateY(200.0);
        layout.getChildren().add(botonContinuar);
    }

    private void agregarTitulo() {

        Label titulo = new Label("Turno de");
        titulo.setFont(new Font("KacstPoster", 70));
        titulo.setTextFill(Color.WHITE);
        titulo.setTranslateY(-140.0);
        layout.getChildren().add(titulo);
    }

    private void agregarNicknameProximoTurno(String nicknameJugadorProximoTurno) {

        cartelProximoTurno = new Label();
        cartelProximoTurno.setTranslateY(-50.0);
        cartelProximoTurno.setText(nicknameJugadorProximoTurno);
        cartelProximoTurno.setFont(new Font("KacstPoster", 95));
        cartelProximoTurno.setTextFill(Color.WHITE);
        layout.getChildren().add(cartelProximoTurno);
    }

    public StackPane getLayout() {

        return layout;
    }
}
