package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutRegistroJugadores;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutSeleccionRondas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class LayoutRegistro {

    private BorderPane layout;
    private LayoutRegistroJugadores layoutRegistroJugadores;
    private LayoutSeleccionRondas layoutSeleccionRondas;

    public LayoutRegistro() {

        layout = new BorderPane();
        layout.setStyle("-fx-background-color: orange");

        layoutSeleccionRondas = new LayoutSeleccionRondas();
        layout.setBottom(layoutSeleccionRondas.getLayout());

        layoutRegistroJugadores = new LayoutRegistroJugadores();
        layout.setTop(layoutRegistroJugadores.getLayout());
    }

    public BorderPane getLayout() {

        return layout;
    }
}
