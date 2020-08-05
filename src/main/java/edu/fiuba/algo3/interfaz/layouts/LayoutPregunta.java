package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.interfaz.botones.BotonOpcion;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class LayoutPregunta {

    private BorderPane layout;
    private StackPane layoutEnunciado;
    private LayoutOpciones layoutOpciones;

    public LayoutPregunta() {

        layout = new BorderPane();
        layoutEnunciado = new StackPane();
        layoutOpciones = new LayoutOpciones();

        layout.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setCenter(layoutOpciones.getLayout());
    }

     public void agregarEnunciadoDeLaPregunta(String enunciado){

        var enunciadoDeLaPregunta = new Label(enunciado);

        enunciadoDeLaPregunta.setWrapText(true);
        enunciadoDeLaPregunta.setMaxSize(1500,200);
        enunciadoDeLaPregunta.setMinSize(1500,200);
        enunciadoDeLaPregunta.setTextAlignment(TextAlignment.CENTER);
        enunciadoDeLaPregunta.setTranslateY(10.0);
        enunciadoDeLaPregunta.setFont(new Font("FreeSans", 50));

        layoutEnunciado.getChildren().add(enunciadoDeLaPregunta);
        layout.setTop(layoutEnunciado);
    }

    public void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY){

        layoutOpciones.agregarOpcion(enunciado, desplazamientoEnX, desplazamientoEnY);
        layout.setCenter(layoutOpciones.getLayout());
    }

    public BorderPane getLayout() {

        return layout;
    }

}
