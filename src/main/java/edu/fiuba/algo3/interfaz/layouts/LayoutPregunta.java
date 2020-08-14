package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutBonificaciones;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutEnunciadoPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutIzquierdoPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutOpciones;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class LayoutPregunta extends BorderPane {

    private LayoutEnunciadoPregunta layoutEnunciado;
    private LayoutOpciones layoutOpciones;
    private LayoutBonificaciones layoutBonificaciones;
    private LayoutIzquierdoPregunta layoutIzquierdo;
    private BotonEnviarRespuesta botonEnviarRespuesta;

    public LayoutPregunta(Integer preguntaActual, Integer preguntasTotales,
                          String enunciadoPregunta, ArrayList<String> enunciadosOpciones) {

        layoutOpciones = new LayoutOpciones();
        layoutBonificaciones = new LayoutBonificaciones();
        layoutIzquierdo = new LayoutIzquierdoPregunta(preguntaActual, preguntasTotales);
        layoutEnunciado = new LayoutEnunciadoPregunta(enunciadoPregunta);
        this.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setTop(layoutEnunciado);
        this.setCenter(layoutOpciones.generarLayout(enunciadosOpciones));
        this.setRight(layoutBonificaciones);
        this.setLeft(layoutIzquierdo);

        botonEnviarRespuesta = new BotonEnviarRespuesta();
        botonEnviarRespuesta.setTranslateY(-10.0);
        botonEnviarRespuesta.setTranslateX(525.0);
        this.setBottom(botonEnviarRespuesta);
    }
}