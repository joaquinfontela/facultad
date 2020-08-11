package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.layouts.puntajesSubLayouts.LayoutPuntajeJugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPuntajesParciales {

    StackPane layout;
    LayoutPuntajeJugador layoutPuntajeParcialJugador1;
    LayoutPuntajeJugador layoutPuntajeParcialJugador2;

    public LayoutPuntajesParciales() {

        layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        agregarTituloDelLayout();
    }

    private void agregarTituloDelLayout() {

        StackPane contenedorTitulo = new StackPane();
        contenedorTitulo.setMinSize(1200, 95);
        contenedorTitulo.setMaxSize(1200, 95);
        contenedorTitulo.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorTitulo.setStyle("-fx-border-color: white");
        contenedorTitulo.setTranslateY(-300.0);

        Label titulo = new Label("PUNTUACIONES");
        titulo.setFont(new Font("FreeSans", 50));
        titulo.setTextFill(Color.YELLOW);

        contenedorTitulo.getChildren().add(titulo);
        layout.getChildren().add(contenedorTitulo);
    }

    public void agregarPuntaje(String nicknameJugador, Integer puntuacion) {

        if (layoutPuntajeParcialJugador1 == null) {
            layoutPuntajeParcialJugador1 = new LayoutPuntajeJugador(nicknameJugador, puntuacion, Color.BLUE);
            layoutPuntajeParcialJugador1.getLayout().setTranslateY(-120.0);
            layout.getChildren().add(layoutPuntajeParcialJugador1.getLayout());
        } else {
            layoutPuntajeParcialJugador2 = new LayoutPuntajeJugador(nicknameJugador, puntuacion, Color.RED);
            layoutPuntajeParcialJugador2.getLayout().setTranslateY(120.0);
            layout.getChildren().add(layoutPuntajeParcialJugador2.getLayout());
        }
    }

    public StackPane getLayout() {

        return layout;
    }
}