package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.estilos.Tic;
import edu.fiuba.algo3.interfaz.layouts.puntajesSubLayouts.LayoutPuntajeJugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPuntajeFinal {

    private StackPane layout;
    private final Image fondo = new Image("file:src/imagenes/fondo.jpg");
    private final Image caraGanador = new Image("file:src/imagenes/caraGanador.png");
    private final Image caraPerdedor = new Image("file:src/imagenes/caraPerdedor.png");
    private String nicknameGanador;
    private Integer puntajeGanador;
    private String nicknamePerdedor;
    private Integer puntajePerdedor;

    public LayoutPuntajeFinal() {

        layout = new StackPane();
        ImageView imageView = new ImageView();
        imageView.setImage(fondo);
        imageView.setFitHeight(760);
        imageView.setFitWidth(1300);
        layout.getChildren().add(imageView);
    }

    public void agregarJugadorGanador(String nickname, Integer puntaje) {

        nicknameGanador = nickname;
        puntajeGanador = puntaje;
    }

    public void agregarJugadorPerdedor(String nickname, Integer puntaje) {

        nicknamePerdedor = nickname;
        puntajePerdedor = puntaje;
    }

    private void crearLayout() {

        crearLayoutParteJugadorGanador();
        crearLayoutParteJugadorPerdedor();
    }

    private void crearLayoutParteJugadorGanador() {

        LayoutPuntajeJugador layoutPuntajeGanador = new LayoutPuntajeJugador(nicknameGanador, puntajeGanador, Color.LIMEGREEN);
        layoutPuntajeGanador.getLayout().setTranslateY(-120.0);

        Tic tic = new Tic();
        tic.setScaleX(20);
        tic.setScaleY(20);
        tic.setFill(Color.DARKGREEN);
        tic.setTranslateX(650.0);
        layoutPuntajeGanador.getLayout().getChildren().add(tic);


        //Label tituloGanador = new Label("GANADOR");
        //tituloGanador.setTextFill(Color.WHITE);
        //tituloGanador.setFont(new Font("FreeSans", 90));
        //tituloGanador.setTranslateY(-250.0);

        layout.getChildren().add(layoutPuntajeGanador.getLayout());

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
        layoutPuntajePerdedor.getLayout().setTranslateY(150.0);
        layout.getChildren().add(layoutPuntajePerdedor.getLayout());

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