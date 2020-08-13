package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.estilos.Tic;
import edu.fiuba.algo3.interfaz.layouts.puntajesSubLayouts.LayoutPuntajeJugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class LayoutPuntajeFinal {

    private StackPane layout;
    private final Image fondo = new Image("file:src/imagenes/fondo.jpg");
    private final Image caraGanador = new Image("file:src/imagenes/caraGanador.png");
    private final Image caraPerdedor = new Image("file:src/imagenes/caraPerdedor.png");
    private String nicknameGanador;
    private int puntajeGanador;
    private String nicknamePerdedor;
    private int puntajePerdedor;

    public LayoutPuntajeFinal() {

        layout = new StackPane();
        ImageView imageView = new ImageView();
        imageView.setImage(fondo);
        imageView.setFitHeight(760);
        imageView.setFitWidth(1300);
        layout.getChildren().add(imageView);
    }

    public void agregarJugadorGanador(String nickname, int puntaje) {

        nicknameGanador = nickname;
        puntajeGanador = puntaje;
    }

    public void agregarJugadorPerdedor(String nickname, int puntaje) {

        nicknamePerdedor = nickname;
        puntajePerdedor = puntaje;
    }

    private void crearLayout() {

        crearLayoutParteJugadorGanador();
        crearLayoutParteJugadorPerdedor();
    }


    private void crearLayoutParteJugadorGanador() {

        LayoutPuntajeJugador layoutPuntajeGanador = new LayoutPuntajeJugador(nicknameGanador, puntajeGanador, Color.LIMEGREEN);
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

        layout.getChildren().add(layoutPuntajeGanador);

        ImageView imageView = new ImageView();
        imageView.setImage(caraGanador);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setTranslateX(150);
        imageView.setTranslateY(-120);
        layout.getChildren().add(imageView);

        //layout.getChildren().add(tituloGanador);
    }

    private void crearLayoutParteJugadorPerdedor() {

        LayoutPuntajeJugador layoutPuntajePerdedor = new LayoutPuntajeJugador(nicknamePerdedor, puntajePerdedor, Color.DARKRED);
        layoutPuntajePerdedor.setTranslateY(150.0);
        layout.getChildren().add(layoutPuntajePerdedor);

        ImageView imageView = new ImageView();
        imageView.setImage(caraPerdedor);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setTranslateX(150);
        imageView.setTranslateY(150);
        layout.getChildren().add(imageView);
    }

    public StackPane getLayout() {

        crearLayout();
        return layout;
    }
}