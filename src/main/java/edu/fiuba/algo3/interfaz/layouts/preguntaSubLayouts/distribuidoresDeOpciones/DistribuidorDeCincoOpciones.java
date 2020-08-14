package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeCincoOpciones extends DistribuidorDeOpcionesChicas {

    public DistribuidorDeCincoOpciones(ArrayList<String> opciones) {

        this.agregarOpcion(opciones.get(0), -400, -30, Color.RED);
        this.agregarOpcion(opciones.get(1), 400, -30, Color.BLUE);
        this.agregarOpcion(opciones.get(2), -400, 80, Color.GOLD);
        this.agregarOpcion(opciones.get(3), 400, 80, Color.GREEN);
        this.agregarOpcion(opciones.get(4), 0, -30, Color.BLUEVIOLET);
    }
}