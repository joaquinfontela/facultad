package edu.fiuba.algo3.interfaz;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LayoutPregunta {

    private StackPane layout;

    public LayoutPregunta() {

        layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Color.SLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

     public void agregarEnunciadoDeLaPregunta(String enunciado){

        var enunciadoDeLaPregunta = new Label(enunciado);

        enunciadoDeLaPregunta.setTranslateY(-400.0);
        enunciadoDeLaPregunta.setFont(new Font("FreeSans", 50));

        layout.getChildren().add(enunciadoDeLaPregunta);
    }

    public void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color){

        Button opcion = new Button();

        opcion.setSkin(new MyButtonSkin(opcion));

        opcion.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        opcion.setText(enunciado);
        opcion.setTextFill(Color.SLATEGRAY);
        opcion.setTranslateX(desplazamientoEnX);
        opcion.setTranslateY(desplazamientoEnY);

        opcion.setFont(new Font("FreeSans", 55));
        opcion.setPrefSize(350, 100);

        layout.getChildren().add(opcion);
    }

    public StackPane getLayout() {

        return layout;
    }
}
