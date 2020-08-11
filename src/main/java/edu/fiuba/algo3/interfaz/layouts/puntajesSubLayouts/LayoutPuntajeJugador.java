package edu.fiuba.algo3.interfaz.layouts.puntajesSubLayouts;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPuntajeJugador {

    private StackPane layout;
    private String nickname;
    private Integer puntaje;

    public LayoutPuntajeJugador(String unNickname, Integer unPuntaje, Color color){

        layout = new StackPane();
        nickname = unNickname;
        puntaje = unPuntaje;

        layout.setMinSize(1550, 200);
        layout.setMaxSize(1550, 200);
        layout.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setStyle("-fx-border-color: black");

        agregarNickname();
        agregarPuntuacion();
    }

    private void agregarNickname() {

        Label contenedorDeNickname = new Label(nickname);
        contenedorDeNickname.setFont(new Font("FreeSans", 100));
        contenedorDeNickname.setTranslateX(-400.0);
        layout.getChildren().add(contenedorDeNickname);
    }

    private void agregarPuntuacion() {

        Label contenedorDePuntuacion = new Label(puntaje.toString());

        contenedorDePuntuacion.setFont(new Font("FreeSans", 110));
        contenedorDePuntuacion.setTranslateX(400.0);
        layout.getChildren().add(contenedorDePuntuacion);
    }

    public StackPane getLayout() {
        return layout;
    }
}