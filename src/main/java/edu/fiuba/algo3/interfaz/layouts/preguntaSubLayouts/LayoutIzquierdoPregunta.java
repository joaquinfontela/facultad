package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import javafx.scene.layout.StackPane;

public class LayoutIzquierdoPregunta {

    private StackPane layout;
    private RelojPregunta relojPregunta;

    public LayoutIzquierdoPregunta() {

        layout = new StackPane();
        relojPregunta = new RelojPregunta();
        layout.getChildren().add(relojPregunta.getContador());
        layout.setTranslateX(35.0);
        layout.setTranslateY(-550.0);
    }

    public StackPane getLayout() {

        return layout;
    }
}
