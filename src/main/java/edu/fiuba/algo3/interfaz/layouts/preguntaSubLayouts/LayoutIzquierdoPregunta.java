package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import javafx.scene.layout.StackPane;

public class LayoutIzquierdoPregunta extends StackPane {

    public LayoutIzquierdoPregunta(Integer numeroPreguntaActual, Integer cantidadPreguntasTotales) {

        this.getChildren().add(new ContadorPregunta(numeroPreguntaActual, cantidadPreguntasTotales));
        this.getChildren().add(new RelojPregunta());
        this.setTranslateX(35.0);
        this.setTranslateY(-415.0);
    }
}