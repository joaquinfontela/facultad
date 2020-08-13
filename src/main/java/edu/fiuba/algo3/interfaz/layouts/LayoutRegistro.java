package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonComenzarHandler;
import edu.fiuba.algo3.interfaz.botones.BotonComenzar;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutRegistroJugadores;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutSeleccionRondas;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LayoutRegistro extends BorderPane{

    private LayoutRegistroJugadores layoutRegistroJugadores;
    private LayoutSeleccionRondas layoutSeleccionRondas;
    private BotonComenzar botonComenzar;

    public LayoutRegistro(Stage stage, Scene proximaEscena) {

        this.setStyle("-fx-background-color: orange");

        layoutSeleccionRondas = new LayoutSeleccionRondas();
        this.setCenter(layoutSeleccionRondas);

        layoutRegistroJugadores = new LayoutRegistroJugadores();
        this.setTop(layoutRegistroJugadores);

        botonComenzar = new BotonComenzar();
        botonComenzar.setTranslateX(360.0);
        botonComenzar.setTranslateY(-30.0);
        botonComenzar.setOnAction(new BotonComenzarHandler(stage, proximaEscena));
        this.setBottom(botonComenzar);
    }
}