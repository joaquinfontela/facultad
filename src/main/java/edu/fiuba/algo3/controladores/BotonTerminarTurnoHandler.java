/*package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.respuesta.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {

    private GestorDeJuego gestor;
    private ArrayList<Boton> botones;

    public BotonTerminarTurnoHandler(GestorDeJuego unGestor, ArrayList<Boton> unaListaDeBotones) {

        gestor = unGestor;
        botones = unaListaDeBotones;
    }

    @Override
    public void handle(ActionEvent event) {

        Respuesta respuesta;
        EnunciadosOpciones opciones = new EnunciadosOpciones();
        if (gestor.obtenerTipoRespuesta == RespuestaVerdaderoFalso.class) {
            respuesta = new RespuestaVerdaderoFalso();
        } else if (gestor.obtenerTipoRespuesta == RespuestaMultipleChoice.class) {
            respuesta = new RespuestaMultipleChoice();
        } else if (gestor.obtenerTipoRespuesta == RespuestaGroupChoice.class) {
            respuesta = new RespuestaGroupChoice();
        } else {
            respuesta = new RespuestaOrderedChoice();
        }
        for (Boton boton : botones) {
            if(boton.fueSeleccionado()) {
                opciones.agregarEnunciadoEidentificador(1, boton.getText());
            } else {
                opciones.agregarEnunciadoEidentificador(0, boton.getText());
            }
        }
        respuesta.rellenar(opciones);
        try {
            gestor.terminarTurno(respuesta);
        } catch (Exception exception) { }
    }
}*/