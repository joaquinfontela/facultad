package edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChico;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeCincoOpciones extends DistribuidorDeOpcionesChicas {

    @Override
    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -600, -25, Color.RED);
        agregarOpcion(opciones.get(1), 600, -25, Color.BLUE);
        agregarOpcion(opciones.get(2), -600, 125, Color.GOLD);
        agregarOpcion(opciones.get(3), 600, 125, Color.GREEN);
        agregarOpcion(opciones.get(4), 0, -25, Color.BLUEVIOLET);
        return layout;
    }

}
