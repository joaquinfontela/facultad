package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones.*;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class LayoutOpciones {

    public StackPane generarLayout(ArrayList<String> opciones) {

        StackPane layout;
        if (opciones.size() == 2){
            layout = new DistribuidorDeDosOpciones().getLayout(opciones);
        } else if (opciones.size() == 3) {
            layout = new DistribuidorDeTresOpciones().getLayout(opciones);
        } else if (opciones.size() == 4) {
            layout = new DistribuidorDeCuatroOpciones().getLayout(opciones);
        } else if (opciones.size() == 5) {
            layout = new DistribuidorDeCincoOpciones().getLayout(opciones);
        } else {
            layout = new DistribuidorDeSeisOpciones().getLayout(opciones);
        }
        return layout;
    }
}