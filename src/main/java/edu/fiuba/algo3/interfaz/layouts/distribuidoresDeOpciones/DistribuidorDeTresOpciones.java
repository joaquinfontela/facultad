package edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class DistribuidorDeTresOpciones extends DistribuidorDeOpciones {

    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -400, -200);
        agregarOpcion(opciones.get(1), 400, -200);
        agregarOpcion(opciones.get(2), 0, 50);
        return layout;
    }

}
