package edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeTresOpciones extends DistribuidorDeOpcionesGrandes {

    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -475, -25, Color.RED);
        agregarOpcion(opciones.get(1), 475, -25, Color.GOLD);
        agregarOpcion(opciones.get(2), 0, -25, Color.BLUE);
        return layout;
    }

}
