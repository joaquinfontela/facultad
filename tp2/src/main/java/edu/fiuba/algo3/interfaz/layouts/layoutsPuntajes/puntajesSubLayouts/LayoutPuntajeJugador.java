package edu.fiuba.algo3.interfaz.layouts.layoutsPuntajes.puntajesSubLayouts;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPuntajeJugador extends StackPane {

    public LayoutPuntajeJugador(Jugador jugador, Color color){

        this.setMinSize(1200, 150);
        this.setMaxSize(1200, 150);
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setStyle("-fx-border-color: white");

        agregarNickname(jugador.obtenerNombre());
        agregarPuntuacion(jugador.obtenerPuntaje());
    }

    private void agregarNickname(String nickname) {

        Label contenedorDeNickname = new Label(nickname);
        contenedorDeNickname.setFont(new Font("FreeSans", 100));
        contenedorDeNickname.setTextFill(Color.WHITE);
        contenedorDeNickname.setTranslateX(-290.0);
        this.getChildren().add(contenedorDeNickname);
    }

    private void agregarPuntuacion(Integer puntaje) {

        Label contenedorDePuntuacion = new Label(puntaje.toString());

        contenedorDePuntuacion.setFont(new Font("FreeSans", 110));
        contenedorDePuntuacion.setTranslateX(400.0);
        contenedorDePuntuacion.setTextFill(Color.WHITE);
        this.getChildren().add(contenedorDePuntuacion);
    }
}