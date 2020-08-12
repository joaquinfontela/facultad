package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.BotonContinuar;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
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

        botonContinuar = new BotonContinuar();
        botonContinuar.setTranslateY(200.0);
        layout.getChildren().add(botonContinuar);

        cartelProximoTurno = new Label();
        cartelProximoTurno.setTranslateY(-50.0);
        cartelProximoTurno.setText(nicknameJugadorProximoTurno);
        cartelProximoTurno.setFont(new Font("KacstPoster", 95));
        cartelProximoTurno.setTextFill(Color.ORANGE);
        layout.getChildren().add(cartelProximoTurno);
    }

    public StackPane getLayout() {

        return layout;
    }
}
