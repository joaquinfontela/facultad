package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeCincoOpciones extends DistribuidorDeOpcionesChicas {

    @Override
    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -400, -30, Color.RED);
        agregarOpcion(opciones.get(1), 400, -30, Color.BLUE);
        agregarOpcion(opciones.get(2), -400, 80, Color.GOLD);
        agregarOpcion(opciones.get(3), 400, 80, Color.GREEN);
        agregarOpcion(opciones.get(4), 0, -30, Color.BLUEVIOLET);
        return layout;
    }
}