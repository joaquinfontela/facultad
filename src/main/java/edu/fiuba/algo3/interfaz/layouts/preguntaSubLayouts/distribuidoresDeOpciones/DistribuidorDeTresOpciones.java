package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeTresOpciones extends DistribuidorDeOpcionesGrandes {

    public DistribuidorDeTresOpciones(ArrayList<String> opciones) {

        this.agregarOpcion(opciones.get(0), -395, 5, Color.RED);
        this.agregarOpcion(opciones.get(1), 395, 5, Color.GOLD);
        this.agregarOpcion(opciones.get(2), 0, 5, Color.BLUE);
    }
}