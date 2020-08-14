package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.interfaz.layouts.LayoutPuntajeFinal;
import edu.fiuba.algo3.interfaz.layouts.LayoutPuntajesParciales;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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

        Scene scene;
        if(gestor.juegoFinalizado()) {
            Jugador jugadorGanador = gestor.obtenerJugadorGanador();
            Jugador jugadorPerdedor = gestor.obtenerJugadorPerdedor();
            LayoutPuntajeFinal layoutPuntajeFinal = new LayoutPuntajeFinal(jugadorGanador, jugadorPerdedor);
            scene = new Scene(layoutPuntajeFinal, 640, 480);
        } else {
            LayoutPuntajesParciales layoutPuntajesParciales =
                    new LayoutPuntajesParciales(gestor.obtenerJugadoresRegistrados());
            scene = new Scene(layoutPuntajesParciales, 640, 480);
        }
        stage.setScene(scene);
    }
}