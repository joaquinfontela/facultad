package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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

        var label = new Label("Que seleccion es la mas ganadora de la historia de los mundiales?");
        label.setTranslateY(-140.0);
        label.setFont(new Font("FreeSans", 18));

        layout.getChildren().add(label);

        var scene = new Scene(layout, 640, 480);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.show();
    }

    void inicializarLayout(){

        layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    void agregarPregunta

    public static void main(String[] args) {
        launch();
    }

}