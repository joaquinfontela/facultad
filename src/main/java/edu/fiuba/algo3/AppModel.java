package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class AppModel extends Application {

    LayoutPregunta layoutPregunta;

    @Override
    public void start(Stage stage) throws Exception {

        //System.out.println(javafx.scene.text.Font.getFamilies());

        LayoutPregunta layoutPregunta = new LayoutPregunta();

        layoutPregunta.agregarEnunciadoDeLaPregunta("Que seleccion es la mas ganadora de la historia de los mundiales? (seleccionar mas de una en caso de ser necesario)");

        layoutPregunta.agregarOpcion("Italia");
        layoutPregunta.agregarOpcion("Brasil");
        layoutPregunta.agregarOpcion("Argentina");
        layoutPregunta.agregarOpcion("Alemania");

        var scene = new Scene(layoutPregunta.getLayout(), 640, 480);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.setMaximized(true); // o setFullScreen, despues vemos.
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}