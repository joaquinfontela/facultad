package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonPreturnoHandler;
import edu.fiuba.algo3.interfaz.botones.BotonPreturno;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutRegistroJugadores;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutSeleccionRondas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LayoutRegistro extends BorderPane{

    private LayoutRegistroJugadores layoutRegistroJugadores;
    private LayoutSeleccionRondas layoutSeleccionRondas;
    private BotonPreturno botonComenzar;

    public LayoutRegistro(Stage stage) {

        this.setStyle("-fx-background-color: orange");

        layoutSeleccionRondas = new LayoutSeleccionRondas();
        this.setCenter(layoutSeleccionRondas);

        layoutRegistroJugadores = new LayoutRegistroJugadores();
        this.setTop(layoutRegistroJugadores);

        botonComenzar = new BotonPreturno();
        botonComenzar.setTranslateX(360.0);
        botonComenzar.setTranslateY(-30.0);
        botonComenzar.setOnAction(new BotonPreturnoHandler(stage,this));
        this.setBottom(botonComenzar);
    }

    public ArrayList<String> obtenerNombresJugadores() throws Exception {

        return layoutRegistroJugadores.obtenerNombresJugadores();
    }

    public int obtenerCantidadRondas() {
        return layoutSeleccionRondas.obtenerCantidadRondas();
    }
}