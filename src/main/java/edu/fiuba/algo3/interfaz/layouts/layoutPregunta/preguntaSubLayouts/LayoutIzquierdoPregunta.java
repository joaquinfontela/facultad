package edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts;

import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LayoutIzquierdoPregunta extends StackPane {

    private RelojPregunta reloj;

    public LayoutIzquierdoPregunta(Stage stage, GestorDeJuego gestor) {

        this.getChildren().add(new ContadorPregunta(gestor.obtenerRondaActual(), gestor.obtenerRondasTotales()));
        reloj = new RelojPregunta(stage, gestor);
        this.getChildren().add(reloj);
        this.setTranslateX(35.0);
        this.setTranslateY(-415.0);
    }

    public void detenerTemporizador() {
        reloj.detenerTemporizador();
    }
}