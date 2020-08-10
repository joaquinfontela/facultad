package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import javafx.scene.layout.StackPane;

public class LayoutIzquierdoPregunta {

    private StackPane layout;

    public LayoutIzquierdoPregunta() {

        layout = new StackPane();
        layout.getChildren().add(new ContadorPregunta(7, 10).getLayout());
        layout.getChildren().add(new RelojPregunta().getContador());
        layout.setTranslateX(35.0);
        layout.setTranslateY(-550.0);
    }

    public StackPane getLayout() {

        return layout;
    }
}
