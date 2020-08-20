package edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class LayoutEnunciadoPregunta extends StackPane {

    public LayoutEnunciadoPregunta(String enunciado) {

        Label enunciadoDeLaPregunta = new Label(enunciado);

        enunciadoDeLaPregunta.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        enunciadoDeLaPregunta.setWrapText(true);
        enunciadoDeLaPregunta.setMaxSize(770,355);
        enunciadoDeLaPregunta.setMinSize(770,355);
        enunciadoDeLaPregunta.setTextAlignment(TextAlignment.CENTER);
        enunciadoDeLaPregunta.setFont(new Font("KacstPoster", 40));
        enunciadoDeLaPregunta.setTextFill(Color.BLACK);

        this.setMaxSize(785, 370);
        this.setMinSize(785, 370);
        this.setTranslateY(15.0);
        this.setTranslateX(200.0);
        this.setStyle("-fx-background-color: gray; -fx-border: 5000");
        this.getChildren().add(enunciadoDeLaPregunta);
    }
}