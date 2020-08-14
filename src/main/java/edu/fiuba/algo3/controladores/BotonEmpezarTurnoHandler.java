package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonEmpezarTurnoHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private GestorDeJuego gestor;

    public BotonEmpezarTurnoHandler(Stage unStage, GestorDeJuego unGestor) {

        stage = unStage;
        gestor = unGestor;
    }

    @Override
    public void handle(ActionEvent event) {

        int rondaActual = gestor.obtenerRondaActual();
        int rondasTotales = gestor.obtenerRondasTotales();
        String pregunta = gestor.obtenerEnunciadoPreguntaActual();
        ArrayList<String> opciones = gestor.obtenerEnunciadosOpcionesActuales();
        LayoutPregunta layoutPregunta = new LayoutPregunta(rondaActual, rondasTotales, pregunta, opciones);
        stage.setScene(new Scene(layoutPregunta, 640, 480));
    }
}
