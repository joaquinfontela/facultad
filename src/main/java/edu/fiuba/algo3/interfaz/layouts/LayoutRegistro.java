package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutRegistroJugadores;
import edu.fiuba.algo3.interfaz.layouts.registroSublayouts.LayoutSeleccionRondas;
import javafx.scene.layout.StackPane;

public class LayoutRegistro {

    private StackPane layout;
    private LayoutRegistroJugadores layoutRegistroJugadores;
    private LayoutSeleccionRondas layoutSeleccionRondas;

    public LayoutRegistro() {

        layout = new StackPane();
        layout.setStyle("-fx-background-color: orange");

        layoutRegistroJugadores = new LayoutRegistroJugadores();
        layout.getChildren().add(layoutRegistroJugadores.getLayout());

        layoutSeleccionRondas = new LayoutSeleccionRondas();
        layout.getChildren().add(layoutSeleccionRondas.getLayout());
    }

    public StackPane getLayout() {

        return layout;
    }
}
