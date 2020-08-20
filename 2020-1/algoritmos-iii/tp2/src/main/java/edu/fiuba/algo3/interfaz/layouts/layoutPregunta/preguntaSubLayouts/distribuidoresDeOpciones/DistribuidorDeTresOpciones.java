package edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts.distribuidoresDeOpciones;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeTresOpciones extends DistribuidorDeOpcionesGrandes {

    public DistribuidorDeTresOpciones(ArrayList<String> opciones, Class claseTipoBoton) {

        this.agregarOpcion(opciones.get(0), -395, 5, Color.RED, claseTipoBoton);
        this.agregarOpcion(opciones.get(1), 395, 5, Color.web("dad40c"), claseTipoBoton);
        this.agregarOpcion(opciones.get(2), 0, 5, Color.BLUE, claseTipoBoton);
    }
}