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

    LayoutEnunciadoPregunta(String enunciado) {

        enunciadoDeLaPregunta = new Label(enunciado);

        enunciadoDeLaPregunta.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        enunciadoDeLaPregunta.setWrapText(true);
        enunciadoDeLaPregunta.setMaxSize(1400,450);
        enunciadoDeLaPregunta.setMinSize(1400,450);
        enunciadoDeLaPregunta.setTextAlignment(TextAlignment.CENTER);
        enunciadoDeLaPregunta.setTranslateY(50.0);
        enunciadoDeLaPregunta.setTranslateX(225.0);
        enunciadoDeLaPregunta.setFont(new Font("KacstPoster", 50));
        enunciadoDeLaPregunta.setTextFill(Color.BLACK);
    }

    public Label getLayout() {

        return enunciadoDeLaPregunta;
    }
}
