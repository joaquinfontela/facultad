package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonEnviarRespuestaHandler;
import edu.fiuba.algo3.interfaz.botones.botonesComunes.BotonEnviarRespuesta;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutBonificaciones;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutEnunciadoPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.LayoutIzquierdoPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutOpciones;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class LayoutPregunta extends BorderPane {

    protected GeneradorLayoutOpciones generadorLayoutOpciones;
    private LayoutIzquierdoPregunta layoutIzquierdo;
    private LayoutBonificaciones layoutBonificaciones;

    public LayoutPregunta(Stage stage, GestorDeJuego gestor) {

        layoutBonificaciones = new LayoutBonificaciones(gestor);
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

    public abstract EnunciadosOpciones obtenerEnunciadosRespuestaUsuario();

    protected ArrayList<BotonOpcion> obtenerBotones() {

        return generadorLayoutOpciones.obtenerBotones();
    }

    public void detenerTemporizador() {
        layoutIzquierdo.detenerTemporizador();
    }

    public boolean multiplicadorX2Seleccionado() {
        return layoutBonificaciones.multiplicadorX2Seleccionado();
    }

    public boolean multiplicadorX3Seleccionado() {
        return layoutBonificaciones.multiplicadorX3Seleccionado();
    }

    public boolean exclusividadSeleccionada() {
        return layoutBonificaciones.exclusividadSeleccionada();
    }
}