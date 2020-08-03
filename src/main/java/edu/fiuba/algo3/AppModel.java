package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class AppModel extends Application {

    StackPane layout;

    @Override
    public void start(Stage stage) throws Exception {

        //System.out.println(javafx.scene.text.Font.getFamilies());

        inicializarLayout();

        agregarEnunciadoDeLaPregunta("Que seleccion es la mas ganadora de la historia de los mundiales?");

        agregarOpcion("Brasil", -500, -175, Color.LIGHTSALMON);
        agregarOpcion("Italia", 500, -175, Color.LIGHTGREEN);
        agregarOpcion("Alemania", -500, 175, Color.LIGHTBLUE);
        agregarOpcion("Argentina", 500, 175, Color.LIGHTYELLOW);

        var scene = new Scene(layout, 640, 480);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.setMaximized(true); // o setFullScreen, despues vemos.
        stage.show();
    }

    void inicializarLayout(){

        layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    void agregarEnunciadoDeLaPregunta(String enunciado){

        var enunciadoDeLaPregunta = new Label(enunciado);

        enunciadoDeLaPregunta.setTranslateY(-400.0);
        enunciadoDeLaPregunta.setFont(new Font("FreeSans", 50));

        layout.getChildren().add(enunciadoDeLaPregunta);
    }

    void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color){

        Button opcion = new Button();

        opcion.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        opcion.setText(enunciado);
        opcion.setTranslateX(desplazamientoEnX);
        opcion.setTranslateY(desplazamientoEnY);

        opcion.setFont(new Font("FreeSans", 55));
        opcion.setPrefSize(350, 100);

        layout.getChildren().add(opcion);
    }

    public static void main(String[] args) {
        launch();
    }

}