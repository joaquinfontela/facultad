package edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts.generadoresDeLayouts;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class GeneradorLayoutGroupChoice extends GeneradorLayoutOpciones {

    @Override
    public StackPane generarLayout(ArrayList<String> opciones) {

        Class tipoAgrupable = Agrupable.class;
        return super.obtenerLayout(opciones, tipoAgrupable);

    }

    @Override
    public ArrayList<BotonOpcion> obtenerBotones() {

        return layout.obtenerBotones();
    }
}
