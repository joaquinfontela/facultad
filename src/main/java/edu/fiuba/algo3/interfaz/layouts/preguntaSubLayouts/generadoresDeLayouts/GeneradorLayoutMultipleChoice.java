package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones.*;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class GeneradorLayoutMultipleChoice extends GeneradorLayoutOpciones {

    @Override
    public StackPane generarLayout(ArrayList<String> opciones) {

        Class tipoSeleccionable = Seleccionable.class;
        return super.obtenerLayout(opciones, tipoSeleccionable);
    }

    @Override
    public ArrayList<BotonOpcion> obtenerBotones() {

        return layout.obtenerBotones();
    }
}
