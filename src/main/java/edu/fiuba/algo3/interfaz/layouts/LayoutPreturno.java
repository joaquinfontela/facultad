package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonCambiarPantallaHandler;
import edu.fiuba.algo3.interfaz.botones.BotonContinuar;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LayoutPreturno extends StackPane {

    public LayoutPreturno(Stage stage, Scene proximaEscena, String nicknameJugadorProximoTurno) {

        this.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));

        TextField textArea = new TextField();
        textArea.setMaxSize(1500, 300);
        textArea.setMinSize(1500, 300);
        textArea.setTranslateY(-85.0);
        textArea.setStyle("-fx-border-color: mediumpurple; -fx-background-color: transparent; -fx-border-width: 5px");
        this.getChildren().add(textArea);

        agregarBotonContinuar(stage, proximaEscena);
        agregarTitulo();
        agregarNicknameProximoTurno(nicknameJugadorProximoTurno);
    }

    private void agregarBotonContinuar(Stage stage, Scene proximaEscena) {

        BotonContinuar botonContinuar = new BotonContinuar();
        botonContinuar.setTranslateY(200.0);
        botonContinuar.setOnAction(new BotonCambiarPantallaHandler(stage, proximaEscena));
        this.getChildren().add(botonContinuar);
    }

    private void agregarTitulo() {

        Label titulo = new Label("Turno de");
        titulo.setFont(new Font("KacstPoster", 70));
        titulo.setTextFill(Color.WHITE);
        titulo.setTranslateY(-140.0);
        this.getChildren().add(titulo);
    }

    private void agregarNicknameProximoTurno(String nicknameJugadorProximoTurno) {

        Label cartelProximoTurno = new Label();
        cartelProximoTurno.setTranslateY(-50.0);
        cartelProximoTurno.setText(nicknameJugadorProximoTurno);
        cartelProximoTurno.setFont(new Font("KacstPoster", 95));
        cartelProximoTurno.setTextFill(Color.WHITE);
        this.getChildren().add(cartelProximoTurno);
    }
}
