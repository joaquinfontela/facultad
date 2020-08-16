package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonEnviarRespuestaHandler;
import edu.fiuba.algo3.interfaz.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutBonificaciones;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutEnunciadoPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutIzquierdoPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.GeneradorLayoutOpciones;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class LayoutPregunta extends BorderPane {

    protected GeneradorLayoutOpciones generadorLayoutOpciones;
    private LayoutIzquierdoPregunta layoutIzquierdo;

    public LayoutPregunta(Stage stage, GestorDeJuego gestor) {

        GeneradorLayoutOpciones generadorLayoutOpciones = new GeneradorLayoutOpciones();
        LayoutBonificaciones layoutBonificaciones = new LayoutBonificaciones(gestor);
        layoutIzquierdo = new LayoutIzquierdoPregunta(stage, gestor);
        LayoutEnunciadoPregunta layoutEnunciado = new LayoutEnunciadoPregunta(gestor.obtenerEnunciadoPreguntaActual());
        this.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setTop(layoutEnunciado);
        this.setRight(layoutBonificaciones);
        this.setLeft(layoutIzquierdo);

        BotonEnviarRespuesta botonEnviarRespuesta = new BotonEnviarRespuesta();
        botonEnviarRespuesta.setTranslateY(-10.0);
        botonEnviarRespuesta.setTranslateX(525.0);
        botonEnviarRespuesta.setOnAction(new BotonEnviarRespuestaHandler(stage, gestor, this));
        this.setBottom(botonEnviarRespuesta);
    }

    public void detenerTemporizador() {
        layoutIzquierdo.detenerTemporizador();
    }
}