package edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeTresOpciones extends DistribuidorDeOpcionesGrandes {

    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -550, 50, Color.RED);
        agregarOpcion(opciones.get(1), 550, 50, Color.BLUE);
        agregarOpcion(opciones.get(2), 0, 50, Color.GREEN);
        return layout;
    }

}
