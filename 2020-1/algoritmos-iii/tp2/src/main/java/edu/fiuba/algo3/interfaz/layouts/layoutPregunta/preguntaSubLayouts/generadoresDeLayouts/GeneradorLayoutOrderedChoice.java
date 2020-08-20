package edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts.generadoresDeLayouts;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class GeneradorLayoutOrderedChoice extends GeneradorLayoutOpciones {

    @Override
    public StackPane generarLayout(ArrayList<String> opciones) {

        Class tipoOrdenable = Ordenable.class;
        return super.obtenerLayout(opciones, tipoOrdenable);
    }

    public ArrayList<BotonOpcion> obtenerBotones() {

        return layout.obtenerBotones();
    }
}
