package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonEmpezarTurnoHandler extends BotonCambiarPantallaHandler {

    public BotonEmpezarTurnoHandler(Stage unStage, GestorDeJuego gestor) {

        super(unStage,null);
        int rondaActual = gestor.obtenerRondaActual();
        int rondasTotales = gestor.obtenerRondasTotales();
        String pregunta = gestor.obtenerEnunciadoPreguntaActual();
        ArrayList<String> opciones = gestor.obtenerEnunciadosOpcionesActuales();
        LayoutPregunta layoutPregunta = new LayoutPregunta(rondaActual, rondasTotales, pregunta, opciones);
        proximaEscena = new Scene(layoutPregunta, 640, 480);
    }
}
