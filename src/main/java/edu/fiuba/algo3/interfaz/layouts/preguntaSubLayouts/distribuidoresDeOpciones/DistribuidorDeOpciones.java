package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public abstract class DistribuidorDeOpciones extends StackPane {

    protected ArrayList<BotonOpcion> botones;

    public DistribuidorDeOpciones() {

        botones = new ArrayList<>();
    }
}
