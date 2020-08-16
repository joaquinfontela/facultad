package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeTresOpciones extends DistribuidorDeOpcionesGrandes {

    public DistribuidorDeTresOpciones(ArrayList<String> opciones, TipoBoton tipoBoton) {

        this.agregarOpcion(opciones.get(0), -395, 5, Color.RED, tipoBoton);
        this.agregarOpcion(opciones.get(1), 395, 5, Color.GOLD, tipoBoton);
        this.agregarOpcion(opciones.get(2), 0, 5, Color.BLUE, tipoBoton);
    }
}