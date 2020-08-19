package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta.LayoutGroupChoice;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta.LayoutMultipleChoice;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta.LayoutOrderedChoice;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonPreturnoHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private GestorDeJuego gestor;

    public BotonPreturnoHandler(Stage unStage, GestorDeJuego unGestor) {

        stage = unStage;
        gestor = unGestor;
    }

    @Override
    public void handle(ActionEvent event) {

        LayoutPregunta layoutPregunta;
        if (gestor.esTipoDeRespuestaComparable(RespuestaOrderedChoice.class)) {
            layoutPregunta = new LayoutOrderedChoice(stage, gestor);
        } else if (gestor.esTipoDeRespuestaComparable(RespuestaGroupChoice.class)) {
            layoutPregunta = new LayoutGroupChoice(stage, gestor);
        } else {
            layoutPregunta = new LayoutMultipleChoice(stage, gestor);
        }
        stage.setScene(new Scene(layoutPregunta, 640, 480));
    }
}