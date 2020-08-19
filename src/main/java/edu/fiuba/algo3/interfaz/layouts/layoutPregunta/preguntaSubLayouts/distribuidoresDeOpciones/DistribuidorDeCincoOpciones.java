package edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeCincoOpciones extends DistribuidorDeOpcionesChicas {

    public DistribuidorDeCincoOpciones(ArrayList<String> opciones, Class claseTipoBoton) {

        this.agregarOpcion(opciones.get(0), -400, -30, Color.RED, claseTipoBoton);
        this.agregarOpcion(opciones.get(1), 400, -30, Color.BLUE, claseTipoBoton);
        this.agregarOpcion(opciones.get(2), -400, 80, Color.GOLD, claseTipoBoton);
        this.agregarOpcion(opciones.get(3), 400, 80, Color.GREEN, claseTipoBoton);
        this.agregarOpcion(opciones.get(4), 0, -30, Color.BLUEVIOLET, claseTipoBoton);
    }
}