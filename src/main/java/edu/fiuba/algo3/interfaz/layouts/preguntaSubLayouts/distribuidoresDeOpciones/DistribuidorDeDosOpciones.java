package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeDosOpciones extends DistribuidorDeOpcionesGrandes {

    public DistribuidorDeDosOpciones(ArrayList<String> opciones, TipoBoton tipoBoton) {

        this.agregarOpcion(opciones.get(0), -245, 5, Color.RED, tipoBoton);
        this.agregarOpcion(opciones.get(1), 245, 5, Color.BLUE, tipoBoton);
    }
}