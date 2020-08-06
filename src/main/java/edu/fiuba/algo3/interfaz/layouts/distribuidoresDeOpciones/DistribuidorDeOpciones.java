package edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.BotonOpcion;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class DistribuidorDeOpciones {

    StackPane layout = new StackPane();

    public abstract StackPane getLayout(ArrayList<String> opciones);

    protected void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY) {

        BotonOpcion opcion = new BotonOpcion(enunciado, desplazamientoEnX, desplazamientoEnY, Color.BLACK);
        layout.getChildren().add(opcion.getBoton());
    }
}
