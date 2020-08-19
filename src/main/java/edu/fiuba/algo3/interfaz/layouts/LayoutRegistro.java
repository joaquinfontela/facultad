package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonRegistroHandler;
import edu.fiuba.algo3.interfaz.botones.botonesComunes.BotonRegistro;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutRegistroJugadores;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutSeleccionRondas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LayoutRegistro extends BorderPane{

    private LayoutRegistroJugadores layoutRegistroJugadores;
    private LayoutSeleccionRondas layoutSeleccionRondas;
    private BotonRegistro botonRegistro;

    public LayoutRegistro(Stage stage) {

        this.setStyle("-fx-background-color: orange");

        layoutSeleccionRondas = new LayoutSeleccionRondas();
        this.setCenter(layoutSeleccionRondas);

        layoutRegistroJugadores = new LayoutRegistroJugadores();
        this.setTop(layoutRegistroJugadores);

        botonRegistro = new BotonRegistro();
        botonRegistro.setTranslateX(360.0);
        botonRegistro.setTranslateY(-30.0);
        botonRegistro.setOnAction(new BotonRegistroHandler(stage,this));
        this.setBottom(botonRegistro);
    }

    public ArrayList<String> obtenerNombresJugadores() throws Exception {

        return layoutRegistroJugadores.obtenerNombresJugadores();
    }

    public int obtenerCantidadRondas() {
        return layoutSeleccionRondas.obtenerCantidadRondas();
    }
}