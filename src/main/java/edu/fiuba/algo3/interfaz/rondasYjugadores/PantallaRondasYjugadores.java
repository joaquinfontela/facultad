package edu.fiuba.algo3.interfaz.rondasYjugadores;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.interfaz.estilos.EstilosBotonEnviarRespuesta;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PantallaRondasYjugadores {
    private BorderPane layout;
    private TextField espacioJugador1;
    private TextField espacioJugador2;

    public PantallaRondasYjugadores() {
        layout = new BorderPane();

        Label rondas = new Label("Rondas: ");
        rondas.setFont(new Font("FreeSans", 60));

        Boton cincoRondas = new BotonRonda("5");
        cincoRondas.setPrefSize(100,100);
        Boton diezRondas = new BotonRonda("10");
        diezRondas.setPrefSize(100,100);
        Boton quinceRondas = new BotonRonda("15");
        quinceRondas.setPrefSize(100,100);

        HBox primerJugador = new HBox();
        HBox segundoJugador = new HBox();
        Label jugador1 = new Label("Jugador 1: ");
        Label jugador2 = new Label("Jugador 2: ");
        espacioJugador1 = new TextField();
        espacioJugador2 = new TextField();
        primerJugador.getChildren().addAll(jugador1, espacioJugador1);
        segundoJugador.getChildren().addAll(jugador2, espacioJugador2);

        Boton enviarRespuesta = new BotonEnviarRespuesta();

        layout.getChildren().addAll(rondas,primerJugador,segundoJugador,enviarRespuesta);
    }

    public BorderPane getLayout() {
        return layout;
    }
}
