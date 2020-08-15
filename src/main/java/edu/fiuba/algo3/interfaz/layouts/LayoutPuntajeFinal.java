package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.estilos.Tic;
import edu.fiuba.algo3.interfaz.layouts.puntajesSubLayouts.LayoutPuntajeJugador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class LayoutPuntajeFinal extends StackPane {

    public LayoutPuntajeFinal(Jugador jugadorArriba, Jugador jugadorAbajo) {

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("file:src/imagenes/fondo.jpg"));
        imageView.setFitHeight(760);
        imageView.setFitWidth(1300);
        this.getChildren().add(imageView);
        this.crearLayoutParteJugadorArriba(jugadorArriba, jugadorAbajo);
        this.crearLayoutParteJugadorAbajo(jugadorArriba,jugadorAbajo);
    }


    private void crearLayoutParteJugadorArriba(Jugador jugadorArriba,Jugador jugadorAbajo) {

        ImageView imageView = new ImageView();
        Color color;
        if (jugadorArriba.obtenerPuntaje() == jugadorAbajo.obtenerPuntaje()) {
            imageView.setImage(new Image("file:src/imagenes/Empate.jpeg"));
            color = Color.BROWN;
        } else {
            imageView.setImage(new Image("file:src/imagenes/caraGanador.png"));
            color = Color.LIMEGREEN;
        }

        LayoutPuntajeJugador layoutPuntajeArriba = new LayoutPuntajeJugador(jugadorArriba, color);
        layoutPuntajeArriba.setTranslateY(-120.0);

        Tic tic = new Tic();
        tic.setScaleX(20);
        tic.setScaleY(20);
        tic.setFill(Color.DARKGREEN);
        tic.setTranslateX(650.0);
        layoutPuntajeArriba.getChildren().add(tic);

        this.getChildren().add(layoutPuntajeArriba);

        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setTranslateX(150);
        imageView.setTranslateY(-120);
        this.getChildren().add(imageView);
    }

    private void crearLayoutParteJugadorAbajo(Jugador jugadorArriba, Jugador jugadorAbajo) {

        ImageView imageView = new ImageView();
        Color color;
        if (jugadorArriba.obtenerPuntaje() == jugadorAbajo.obtenerPuntaje()) {
            imageView.setImage(new Image("file:src/imagenes/Empate.jpeg"));
            color = Color.BROWN;
        } else {
            imageView.setImage(new Image("file:src/imagenes/caraPerdedor.png"));
            color = Color.DARKRED;
        }

        LayoutPuntajeJugador layoutPuntajeAbajo = new LayoutPuntajeJugador(jugadorAbajo, color);
        layoutPuntajeAbajo.setTranslateY(150.0);
        this.getChildren().add(layoutPuntajeAbajo);

        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setTranslateX(150);
        imageView.setTranslateY(150);
        this.getChildren().add(imageView);
    }
}