package edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeSeisOpciones extends DistribuidorDeOpcionesChicas {

    @Override
    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -600, -100, Color.RED);
        agregarOpcion(opciones.get(1), 600, -100, Color.BLUE);
        agregarOpcion(opciones.get(2), -600, 50, Color.GOLD);
        agregarOpcion(opciones.get(3), 600, 50, Color.GREEN);
        agregarOpcion(opciones.get(4), 0, 50, Color.ORANGE);
        agregarOpcion(opciones.get(5), 0, -100, Color.BLUEVIOLET);
        return layout;
    }
}
