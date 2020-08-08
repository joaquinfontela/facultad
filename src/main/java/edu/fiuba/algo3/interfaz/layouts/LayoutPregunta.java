package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonBonificacion;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonExclusividad;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LayoutPregunta {

    private BorderPane layout;
    private LayoutEnunciadoPregunta layoutEnunciado;
    private LayoutOpciones layoutOpciones;
    private LayoutBonificaciones layoutBonificaciones;

    public LayoutPregunta() {

        layout = new BorderPane();
        layoutOpciones = new LayoutOpciones();
        layoutBonificaciones = new LayoutBonificaciones();

        layout.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setCenter(layoutOpciones.getLayout());
        layout.setRight(layoutBonificaciones.getLayout());
        layout.setLeft(new StackPane());
    }

     public void agregarEnunciadoDeLaPregunta(String enunciado){

        layoutEnunciado = new LayoutEnunciadoPregunta(enunciado);
        layout.setTop(layoutEnunciado.getLayout());
    }

    public void agregarOpcion(String enunciado){

        layoutOpciones.agregarOpcion(enunciado);
    }

    public BorderPane getLayout() {

        layout.setCenter(layoutOpciones.getLayout());
        return layout;
    }

}
