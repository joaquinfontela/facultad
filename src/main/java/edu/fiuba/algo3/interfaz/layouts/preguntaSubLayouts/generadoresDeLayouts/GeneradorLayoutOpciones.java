package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones.DistribuidorDeOpciones;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public interface GeneradorLayoutOpciones {

    StackPane generarLayout(ArrayList<String> opciones);

    ArrayList<BotonOpcion> obtenerBotones();
}