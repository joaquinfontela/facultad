package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.LayoutPregunta;
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

        layoutPregunta.agregarEnunciadoDeLaPregunta("Que seleccion/es es/son la/s mas ganadora/s de la historia de los mundiales?");

        layoutPregunta.agregarOpcion("Italia", -400, -125, Color.BLACK);
        layoutPregunta.agregarOpcion("Brasil", 400, -125, Color.BLACK);
        layoutPregunta.agregarOpcion("Argentina", -400, 125, Color.BLACK);
        layoutPregunta.agregarOpcion("Alemania", 400, 125, Color.BLACK);

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