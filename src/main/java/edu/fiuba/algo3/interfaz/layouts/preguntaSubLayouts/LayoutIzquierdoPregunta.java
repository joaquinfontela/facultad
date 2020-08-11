package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import javafx.scene.layout.StackPane;

public class LayoutIzquierdoPregunta {

    private StackPane layout;

    public LayoutIzquierdoPregunta(Integer numeroPreguntaActual, Integer cantidadPreguntasTotales) {

        layout = new StackPane();
        layout.getChildren().add(new ContadorPregunta(numeroPreguntaActual, cantidadPreguntasTotales).getLayout());
        layout.getChildren().add(new RelojPregunta().getContador());
        layout.setTranslateX(35.0);
        layout.setTranslateY(-525.0);
    }

    public StackPane getLayout() {
        return layout;
    }
}