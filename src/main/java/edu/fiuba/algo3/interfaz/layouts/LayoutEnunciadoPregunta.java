package edu.fiuba.algo3.interfaz.layouts;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class LayoutEnunciadoPregunta {

    Label enunciadoDeLaPregunta;
    StackPane layout;

    LayoutEnunciadoPregunta(String enunciado) {

        layout = new StackPane();
        enunciadoDeLaPregunta = new Label(enunciado);

        enunciadoDeLaPregunta.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        enunciadoDeLaPregunta.setWrapText(true);
        enunciadoDeLaPregunta.setMaxSize(1050,425);
        enunciadoDeLaPregunta.setMinSize(1050,425);
        enunciadoDeLaPregunta.setTextAlignment(TextAlignment.CENTER);
        enunciadoDeLaPregunta.setFont(new Font("KacstPoster", 50));
        enunciadoDeLaPregunta.setTextFill(Color.BLACK);

        layout.setMaxSize(1100, 450);
        layout.setMinSize(1100, 450);
        layout.setTranslateY(25.0);
        layout.setTranslateX(190.0);
        layout.setStyle("-fx-background-color: gray; -fx-border: 5000");
        layout.getChildren().add(enunciadoDeLaPregunta);
    }

    public StackPane getLayout() {

        return layout;
    }
}
