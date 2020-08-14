package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPreturno;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.LectorDeArchivo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BotonComenzarHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;
    private GestorDeJuego gestor;
    private Stack<Integer> cantidadRondas;

    public BotonComenzarHandler(Stage unStage, Stack<Integer> rondas) {

        stage = unStage;
        cantidadRondas = rondas;
    }

    @Override
    public void handle(ActionEvent event) {

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Willyrex"));
        jugadores.add(new Jugador("Vegetta777"));
        Collections.shuffle(jugadores);
        LectorDeArchivo lector = new LectorDeArchivo();
        gestor = new GestorDeJuego(lector.obtenerListaDeInformacionDePreguntas(), jugadores, cantidadRondas.pop());
        LayoutPreturno layoutPreturno = new LayoutPreturno(stage, gestor);
        proximaEscena = new Scene(layoutPreturno, 640, 480);
        stage.setScene(proximaEscena);
    }
}