package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeSeisOpciones extends DistribuidorDeOpcionesChicas {

    public DistribuidorDeSeisOpciones(ArrayList<String> opciones) {

        this.agregarOpcion(opciones.get(0), -400, -50, Color.RED);
        this.agregarOpcion(opciones.get(1), 400, -50, Color.BLUE);
        this.agregarOpcion(opciones.get(2), -400, 60, Color.GOLD);
        this.agregarOpcion(opciones.get(3), 400, 60, Color.GREEN);
        this.agregarOpcion(opciones.get(4), 0, 60, Color.ORANGE);
        this.agregarOpcion(opciones.get(5), 0, -50, Color.BLUEVIOLET);
    }
}