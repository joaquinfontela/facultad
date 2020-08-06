package edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class DistribuidorDeDosOpciones extends DistribuidorDeOpciones {

    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -400, -75);
        agregarOpcion(opciones.get(1), 400, -75);
        return layout;
    }
}
