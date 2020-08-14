package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.layouts.puntajesSubLayouts.LayoutPuntajeJugador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.HashMap;

public class LayoutPuntajesParciales extends StackPane {

    public LayoutPuntajesParciales(ArrayList<Jugador> jugadores) {

        this.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.agregarTituloDelLayout();
        agregarPuntajes(jugadores);
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
        this.getChildren().add(contenedorTitulo);
    }

    private void agregarPuntajes(ArrayList<Jugador> jugadores) {

        ArrayList<Color> colores = new ArrayList<>();
        colores.add(Color.BLUE);
        colores.add(Color.RED);
        int contador = 0;
        for (Jugador jugador : jugadores) {
            LayoutPuntajeJugador layout = new LayoutPuntajeJugador(jugador, colores.get(contador));
            if (contador == 0) layout.setTranslateY(-120.0);
            else layout.setTranslateY(120.0);
            this.getChildren().add(layout);
            contador++;
        }
    }
}