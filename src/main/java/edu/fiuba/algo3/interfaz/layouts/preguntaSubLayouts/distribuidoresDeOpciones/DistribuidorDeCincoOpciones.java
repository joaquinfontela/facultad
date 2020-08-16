package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeCincoOpciones extends DistribuidorDeOpcionesChicas {

    public DistribuidorDeCincoOpciones(ArrayList<String> opciones, TipoBoton tipoBoton) {

        this.agregarOpcion(opciones.get(0), -400, -30, Color.RED, tipoBoton);
        this.agregarOpcion(opciones.get(1), 400, -30, Color.BLUE, tipoBoton);
        this.agregarOpcion(opciones.get(2), -400, 80, Color.GOLD, tipoBoton);
        this.agregarOpcion(opciones.get(3), 400, 80, Color.GREEN, tipoBoton);
        this.agregarOpcion(opciones.get(4), 0, -30, Color.BLUEVIOLET, tipoBoton);
    }
}