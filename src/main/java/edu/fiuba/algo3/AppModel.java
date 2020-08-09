package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
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
    private Integer segundosRestantes;

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println(javafx.scene.text.Font.getFamilies());

        layoutPregunta = new LayoutPregunta();
        segundosRestantes = 30;

        layoutPregunta.agregarEnunciadoDeLaPregunta("Que seleccion es la mas ganadora de la historia de los mundiales? (seleccionar mas de una en caso de ser necesario)");

        layoutPregunta.agregarOpcion("Italia");
        layoutPregunta.agregarOpcion("Brasil");
        layoutPregunta.agregarOpcion("Argentina");
        layoutPregunta.agregarOpcion("Alemania");
        //layoutPregunta.agregarOpcion("Holanda");
        //layoutPregunta.agregarOpcion("Uruguay");

        var scene = new Scene(layoutPregunta.getLayout(), 640, 480);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.setHeight(900);
        stage.setWidth(1500);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}