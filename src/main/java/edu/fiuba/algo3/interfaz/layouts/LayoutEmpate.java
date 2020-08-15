package edu.fiuba.algo3.interfaz.layouts;
import edu.fiuba.algo3.interfaz.estilos.Tic;
import edu.fiuba.algo3.interfaz.layouts.puntajesSubLayouts.LayoutPuntajeJugador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class LayoutEmpate extends StackPane {

    public LayoutEmpate(Jugador jugadorArriba, Jugador jugadorAbajo) {

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("file:src/imagenes/fondo.jpg"));
        imageView.setFitHeight(760);
        imageView.setFitWidth(1300);
        this.getChildren().add(imageView);
        crearLayoutParteJugadorArriba(jugadorArriba);
        crearLayoutParteJugadorAbajo(jugadorAbajo);
    }


    private void crearLayoutParteJugadorArriba(Jugador jugadorArriba) {

        LayoutPuntajeJugador layoutPuntajeArriba = new LayoutPuntajeJugador(jugadorArriba, Color.LIMEGREEN);
        layoutPuntajeArriba.setTranslateY(-120.0);

        Tic tic = new Tic();
        tic.setScaleX(20);
        tic.setScaleY(20);
        tic.setFill(Color.DARKGREEN);
        tic.setTranslateX(650.0);
        layoutPuntajeArriba.getChildren().add(tic);

        this.getChildren().add(layoutPuntajeArriba);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("file:src/imagenes/Empate.jpeg"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setTranslateX(150);
        imageView.setTranslateY(-120);
        this.getChildren().add(imageView);

    }

    private void crearLayoutParteJugadorAbajo(Jugador jugadorAbajo) {

        LayoutPuntajeJugador layoutPuntajeAbajo = new LayoutPuntajeJugador(jugadorAbajo, Color.DARKRED);
        layoutPuntajeAbajo.setTranslateY(150.0);
        this.getChildren().add(layoutPuntajeAbajo);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("file:src/imagenes/Empate.jpeg"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setTranslateX(150);
        imageView.setTranslateY(150);
        this.getChildren().add(imageView);
    }
}

