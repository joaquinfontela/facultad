package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.estilos.Tic;
import edu.fiuba.algo3.interfaz.layouts.puntajesSubLayouts.LayoutPuntajeJugador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class LayoutPuntajeFinal extends StackPane {

    public LayoutPuntajeFinal(Jugador jugadorGanador, Jugador jugadorPerdedor) {

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("file:src/imagenes/fondo.jpg"));
        imageView.setFitHeight(760);
        imageView.setFitWidth(1300);
        this.getChildren().add(imageView);
        crearLayoutParteJugadorGanador(jugadorGanador);
        crearLayoutParteJugadorPerdedor(jugadorPerdedor);
    }


    private void crearLayoutParteJugadorGanador(Jugador jugadorGanador) {

        LayoutPuntajeJugador layoutPuntajeGanador = new LayoutPuntajeJugador(jugadorGanador, Color.LIMEGREEN);
        layoutPuntajeGanador.setTranslateY(-120.0);

        Tic tic = new Tic();
        tic.setScaleX(20);
        tic.setScaleY(20);
        tic.setFill(Color.DARKGREEN);
        tic.setTranslateX(650.0);
        layoutPuntajeGanador.getChildren().add(tic);


        //Label tituloGanador = new Label("GANADOR");
        //tituloGanador.setTextFill(Color.WHITE);
        //tituloGanador.setFont(new Font("FreeSans", 90));
        //tituloGanador.setTranslateY(-250.0);

        this.getChildren().add(layoutPuntajeGanador);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("file:src/imagenes/caraGanador.png"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setTranslateX(150);
        imageView.setTranslateY(-120);
        this.getChildren().add(imageView);

        //layout.getChildren().add(tituloGanador);
    }

    private void crearLayoutParteJugadorPerdedor(Jugador jugadorPerdedor) {

        LayoutPuntajeJugador layoutPuntajePerdedor = new LayoutPuntajeJugador(jugadorPerdedor, Color.DARKRED);
        layoutPuntajePerdedor.setTranslateY(150.0);
        this.getChildren().add(layoutPuntajePerdedor);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("file:src/imagenes/caraPerdedor.png"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setTranslateX(150);
        imageView.setTranslateY(150);
        this.getChildren().add(imageView);
    }
}