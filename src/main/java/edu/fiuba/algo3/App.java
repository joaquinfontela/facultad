package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.layouts.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App cC
 */
public class App extends Application {

    LayoutInicio layoutInicio;
    Scene scene;

    @Override
    public void start(Stage stage) {
        /*
        layoutInicio = new LayoutInicio(stage);
        scene = new Scene(layoutInicio, 640, 480);
        */
        Jugador jugador1= new Jugador("ruso");
        Jugador jugador2= new Jugador("betz");
        LayoutPuntajeFinal layout = new LayoutPuntajeFinal(stage,jugador1,jugador2);
        scene = new Scene(layout, 640,480);
        mostrarStage(stage);
    }

    private void mostrarStage(Stage stage) {

        stage.setTitle("Algohoot!");
        stage.setScene(scene);
        stage.setHeight(720);
        stage.setWidth(1200);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}