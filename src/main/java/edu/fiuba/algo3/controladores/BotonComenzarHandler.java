package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPreturno;
import edu.fiuba.algo3.interfaz.layouts.LayoutRegistro;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.LectorDeArchivo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.pregunta.InformacionPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class BotonComenzarHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;
    private LayoutRegistro layoutActual;

    public BotonComenzarHandler(Stage unStage, LayoutRegistro layout) {

        stage = unStage;
        layoutActual = layout;
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            ArrayList<String> nombresJugadores = layoutActual.obtenerNombresJugadores();
            ArrayList<Jugador> jugadores = new ArrayList<>();
            for (String nombre : nombresJugadores) jugadores.add(new Jugador(nombre));
            Collections.shuffle(jugadores, new Random());
            int cantidadRondas = layoutActual.obtenerCantidadRondas();
            LectorDeArchivo lector = new LectorDeArchivo();
            ArrayList<InformacionPregunta> infoLector = lector.obtenerListaDeInformacionDePreguntas();
            GestorDeJuego gestor = new GestorDeJuego(infoLector, jugadores, cantidadRondas);
            LayoutPreturno layoutPreturno = new LayoutPreturno(stage, gestor);
            proximaEscena = new Scene(layoutPreturno, 640, 480);
            stage.setScene(proximaEscena);
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(exception.getMessage());
            alert.show();
        }
    }
}