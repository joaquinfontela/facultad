package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeDosOpciones extends DistribuidorDeOpcionesGrandes {

    public DistribuidorDeDosOpciones(ArrayList<String> opciones) {

        this.agregarOpcion(opciones.get(0), -245, 5, Color.RED);
        this.agregarOpcion(opciones.get(1), 245, 5, Color.BLUE);
    }
}