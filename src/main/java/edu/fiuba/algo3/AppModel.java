package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.LayoutPuntajeFinal;
import edu.fiuba.algo3.interfaz.layouts.LayoutPuntajesParciales;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App cC
 */
public class AppModel extends Application {

    LayoutPregunta layoutPregunta;
    LayoutPuntajesParciales layoutPuntajesParciales;
    LayoutPuntajeFinal layoutPuntajeFinal;
    Scene scene;

    @Override
    public void start(Stage stage) {

        //System.out.println(javafx.scene.text.Font.getFamilies());

        //mostrarLayoutPregunta();
        mostrarLayoutPuntajesParciales();
        //mostrarLayoutPuntajeFinal();

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.setHeight(900);
        stage.setWidth(1500);
        stage.show();
    }

    private void mostrarLayoutPregunta() {

        layoutPregunta = new LayoutPregunta(7, 10);

        layoutPregunta.agregarEnunciadoDeLaPregunta("Que seleccion es la mas ganadora de la historia de los mundiales? (seleccionar mas de una en caso de ser necesario)");

        layoutPregunta.agregarOpcion("Italia");
        layoutPregunta.agregarOpcion("Brasil");
        layoutPregunta.agregarOpcion("Argentina");
        layoutPregunta.agregarOpcion("Alemania");
        //layoutPregunta.agregarOpcion("Holanda");
        //layoutPregunta.agregarOpcion("Uruguay");

        scene = new Scene(layoutPregunta.getLayout(), 640, 480);
    }

    private void mostrarLayoutPuntajesParciales() {

        layoutPuntajesParciales = new LayoutPuntajesParciales();
        layoutPuntajesParciales.agregarPuntaje("Miguel", 3);
        layoutPuntajesParciales.agregarPuntaje("Tomas", 1);

        scene = new Scene(layoutPuntajesParciales.getLayout(), 640, 480);
    }

    private void mostrarLayoutPuntajeFinal() {

        layoutPuntajeFinal = new LayoutPuntajeFinal();
        layoutPuntajeFinal.agregarJugadorGanador("Tomas", 14);
        layoutPuntajeFinal.agregarJugadorPerdedor("Miguel", 11);

        scene = new Scene(layoutPuntajeFinal.getLayout(), 640, 480);
    }

    public static void main(String[] args) {
        launch();
    }

}