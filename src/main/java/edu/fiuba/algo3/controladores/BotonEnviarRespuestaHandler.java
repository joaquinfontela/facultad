package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BotonEnviarRespuestaHandler extends BotonTerminarTurnoHandler {

    private LayoutPregunta layoutActual;

    public BotonEnviarRespuestaHandler(Stage unStage, GestorDeJuego unGestor, LayoutPregunta layout) {

        super(unStage, unGestor);
        layoutActual = layout;
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            Respuesta respuesta = gestor.crearRespuestaComparable();
            respuesta.rellenar(layoutActual.obtenerEnunciadosRespuestaUsuario());
            if (layoutActual.multiplicadorX2Seleccionado()) {
                gestor.aplicarMultiplicadorX2DelJugadorActual();
            } else if (layoutActual.multiplicadorX3Seleccionado()) {
                gestor.aplicarMultiplicadorX3DelJugadorActual();
            } else if (layoutActual.exclusividadSeleccionada()) {
                gestor.aplicarExclusividadDelJugadorActual();
            }
            gestor.terminarTurno(respuesta);
            layoutActual.detenerTemporizador();
            this.cambiarEscena();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }
}