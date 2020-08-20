package edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts;

import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LayoutIzquierdoPregunta extends StackPane {

    private RelojPregunta reloj;

    public LayoutIzquierdoPregunta(Stage stage, GestorDeJuego gestor) {

        this.agregarModo(gestor);
        this.getChildren().add(new ContadorPregunta(gestor.obtenerRondaActual(), gestor.obtenerRondasTotales()));
        reloj = new RelojPregunta(stage, gestor);
        this.getChildren().add(reloj);
        this.setTranslateX(35.0);
        this.setTranslateY(-415.0);
    }

    public void detenerTemporizador() {
        reloj.detenerTemporizador();
    }

    private void agregarModo(GestorDeJuego gestor) {

        Label label = new Label("Modo:\n" + gestor.obtenerNombreModo());
        label.setFont(new Font("KacstPoster", 20));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setTextFill(Color.GOLD);
        label.setTranslateY(85);
        this.getChildren().add(label);
    }
}