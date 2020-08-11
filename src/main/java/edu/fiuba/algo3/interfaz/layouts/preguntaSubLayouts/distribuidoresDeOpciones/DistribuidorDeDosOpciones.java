package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeDosOpciones extends DistribuidorDeOpcionesGrandes {

    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -245, 5, Color.RED);
        agregarOpcion(opciones.get(1), 245, 5, Color.BLUE);
        return layout;
    }
}