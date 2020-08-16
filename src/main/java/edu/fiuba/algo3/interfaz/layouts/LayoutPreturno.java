package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonEmpezarTurnoHandler;
import edu.fiuba.algo3.interfaz.botones.BotonPreturno;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.geometry.Insets;
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

    public LayoutPreturno(Stage stage, GestorDeJuego gestor) {

        this.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));

        TextField textArea = new TextField();
        textArea.setMaxSize(1500, 300);
        textArea.setMinSize(1500, 300);
        textArea.setTranslateY(-85.0);
        textArea.setStyle("-fx-border-color: mediumpurple; -fx-background-color: transparent; -fx-border-width: 5px");
        this.getChildren().add(textArea);

        this.agregarBoton(stage, gestor);
        this.agregarTitulo();
        this.agregarNicknameProximoTurno(gestor.obtenerNombreJugadorActual());
    }

    private void agregarBoton(Stage stage, GestorDeJuego gestor) {

        BotonPreturno botonPreturno = new BotonPreturno();
        botonPreturno.setTranslateY(200.0);
        botonPreturno.setOnAction(new BotonEmpezarTurnoHandler(stage, gestor));
        this.getChildren().add(botonPreturno);
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
