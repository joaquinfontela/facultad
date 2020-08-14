package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPreturno;
import edu.fiuba.algo3.interfaz.layouts.LayoutPuntajeFinal;
import edu.fiuba.algo3.interfaz.layouts.LayoutPuntajesParciales;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BotonEnviarRespuestaHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private GestorDeJuego gestor;

    public BotonEnviarRespuestaHandler(Stage unStage, GestorDeJuego unGestor) {

        stage = unStage;
        gestor = unGestor;
    }

    @Override
    public void handle(ActionEvent event) {

        this.cambiarEscena();
    }

    private void cambiarEscena() {

        StackPane layout;
        if (gestor.juegoFinalizado()) {
            Jugador jugadorGanador = gestor.obtenerJugadorGanador();
            Jugador jugadorPerdedor = gestor.obtenerJugadorPerdedor();
            layout = new LayoutPuntajeFinal(jugadorGanador, jugadorPerdedor);
        } else if (gestor.comienzaNuevaRonda()) {
            layout = new LayoutPuntajesParciales(gestor.obtenerJugadoresRegistrados());
        } else {
            layout = new LayoutPreturno(stage, gestor);
        }
        stage.setScene(new Scene(layout, 640, 480));
    }
}