package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public interface GeneradorLayoutOpciones {

    StackPane generarLayout(ArrayList<String> opciones);
}