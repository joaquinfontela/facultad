package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeSeisOpciones extends DistribuidorDeOpcionesChicas {

    @Override
    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -450, -75, Color.RED);
        agregarOpcion(opciones.get(1), 450, -75, Color.BLUE);
        agregarOpcion(opciones.get(2), -450, 75, Color.GOLD);
        agregarOpcion(opciones.get(3), 450, 75, Color.GREEN);
        agregarOpcion(opciones.get(4), 0, 75, Color.ORANGE);
        agregarOpcion(opciones.get(5), 0, -75, Color.BLUEVIOLET);
        return layout;
    }
}