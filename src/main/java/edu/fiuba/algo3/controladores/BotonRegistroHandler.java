package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPreturno;
import edu.fiuba.algo3.interfaz.layouts.layoutRegistro.LayoutRegistro;
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

public class BotonRegistroHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private LayoutRegistro layoutActual;

    public BotonRegistroHandler(Stage unStage, LayoutRegistro layout) {

        stage = unStage;
        layoutActual = layout;
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            GestorDeJuego gestor = this.crearModelo();
            LayoutPreturno layoutPreturno = new LayoutPreturno(stage, gestor);
            stage.setScene(new Scene(layoutPreturno, 640, 480));
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(exception.getMessage());
            alert.show();
        }
    }

    private GestorDeJuego crearModelo() throws Exception {

        ArrayList<String> nombresJugadores = layoutActual.obtenerNombresJugadores();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (String nombre : nombresJugadores) jugadores.add(new Jugador(nombre));
        Collections.shuffle(jugadores, new Random());
        int cantidadRondas = layoutActual.obtenerCantidadRondas();
        LectorDeArchivo lector = new LectorDeArchivo();
        ArrayList<InformacionPregunta> infoLector = lector.obtenerListaDeInformacionDePreguntas(cantidadRondas);
        return new GestorDeJuego(infoLector, jugadores, cantidadRondas);
    }
}