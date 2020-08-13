package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.BotonComenzar;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutRegistroJugadores;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutSeleccionRondas;
import javafx.scene.layout.BorderPane;

public class LayoutRegistro {

    private BorderPane layout;
    private LayoutRegistroJugadores layoutRegistroJugadores;
    private LayoutSeleccionRondas layoutSeleccionRondas;
    private BotonComenzar botonComenzar;

    public LayoutRegistro() {

        layout = new BorderPane();
        layout.setStyle("-fx-background-color: orange");

        layoutSeleccionRondas = new LayoutSeleccionRondas();
        layout.setCenter(layoutSeleccionRondas.getLayout());

        layoutRegistroJugadores = new LayoutRegistroJugadores();
        layout.setTop(layoutRegistroJugadores.getLayout());

        botonComenzar = new BotonComenzar();
        botonComenzar.setTranslateX(360.0);
        botonComenzar.setTranslateY(-30.0);
        layout.setBottom(botonComenzar);
    }

    public BorderPane getLayout() {

        return layout;
    }
}
