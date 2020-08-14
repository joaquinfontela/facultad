package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.layouts.*;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.LectorDeArchivo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App cC
 */
public class App extends Application {

    LayoutPregunta layoutPregunta;
    LayoutPuntajesParciales layoutPuntajesParciales;
    LayoutPuntajeFinal layoutPuntajeFinal;
    LayoutPreturno layoutPreturno;
    LayoutInicio layoutInicio;
    LayoutRegistro layoutRegistro;
    Scene scene;

    @Override
    public void start(Stage stage) {

        //System.out.println(javafx.scene.text.Font.getFamilies());

        //mostrarLayoutPuntajesParciales();
        //mostrarLayoutPuntajeFinal();

        layoutInicio = new LayoutInicio(stage);
        scene = new Scene(layoutInicio, 640, 480);

        mostrarStage(stage);
    }

    private void mostrarStage(Stage stage) {

        stage.setTitle("Algohoot!");
        stage.setScene(scene);
        stage.setHeight(720);
        stage.setWidth(1200);
        stage.show();
    }

    private void mostrarLayoutPuntajesParciales() {

        layoutPuntajesParciales = new LayoutPuntajesParciales();
        layoutPuntajesParciales.agregarPuntaje("Miguel", 3);
        layoutPuntajesParciales.agregarPuntaje("Tomás", 1);

        scene = new Scene(layoutPuntajesParciales, 640, 480);
    }

    private void mostrarLayoutPuntajeFinal() {

        layoutPuntajeFinal = new LayoutPuntajeFinal();
        layoutPuntajeFinal.agregarJugadorGanador("Tomás", 14);
        layoutPuntajeFinal.agregarJugadorPerdedor("Miguel", 11);

        scene = new Scene(layoutPuntajeFinal.getLayout(), 640, 480);
    }

    public static void main(String[] args) {
        launch();
    }
}