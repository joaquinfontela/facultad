package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones.*;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class GeneradorLayoutOpciones {

    public StackPane generarLayout(ArrayList<String> opciones) {

        StackPane layout;
        if (opciones.size() == 2){
            layout = new DistribuidorDeDosOpciones(opciones);
        } else if (opciones.size() == 3) {
            layout = new DistribuidorDeTresOpciones(opciones);
        } else if (opciones.size() == 4) {
            layout = new DistribuidorDeCuatroOpciones(opciones);
        } else if (opciones.size() == 5) {
            layout = new DistribuidorDeCincoOpciones(opciones);
        } else {
            layout = new DistribuidorDeSeisOpciones(opciones);
        }
        return layout;
    }
}