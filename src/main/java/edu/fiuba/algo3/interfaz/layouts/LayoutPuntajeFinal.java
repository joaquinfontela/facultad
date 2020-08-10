package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.estilos.Tic;
import edu.fiuba.algo3.interfaz.layouts.puntajesParcialesSubLayouts.LayoutPuntajeJugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPuntajeFinal {

    StackPane layout;
    String nicknameGanador;
    Integer puntajeGanador;
    String nicknamePerdedor;
    Integer puntajePerdedor;

    public LayoutPuntajeFinal() {

        layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
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

        Label tituloGanador = new Label("GANADOR");
        tituloGanador.setTextFill(Color.LIMEGREEN);
        tituloGanador.setFont(new Font("FreeSans", 50));
        tituloGanador.setTranslateY(-300.0);

        layout.getChildren().add(layoutPuntajeGanador.getLayout());
        layout.getChildren().add(tituloGanador);
    }

    private void crearLayoutParteJugadorPerdedor() {

        LayoutPuntajeJugador layoutPuntajePerdedor = new LayoutPuntajeJugador(nicknamePerdedor, puntajePerdedor, Color.DARKRED);
        layoutPuntajePerdedor.getLayout().setTranslateY(240.0);

        layout.getChildren().add(layoutPuntajePerdedor.getLayout());
    }

    public StackPane getLayout() {

        crearLayout();
        return layout;
    }
}
