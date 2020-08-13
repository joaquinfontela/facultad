package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeTresOpciones extends DistribuidorDeOpcionesGrandes {

    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -395, 5, Color.RED);
        agregarOpcion(opciones.get(1), 395, 5, Color.GOLD);
        agregarOpcion(opciones.get(2), 0, 5, Color.BLUE);
        return layout;
    }
}