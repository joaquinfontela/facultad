package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones.*;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class GeneradorLayoutGroupChoice implements GeneradorLayoutOpciones {

    StackPane layout;

    @Override
    public StackPane generarLayout(ArrayList<String> opciones) {

        Class tipoAgrupable = Agrupable.class;

        if (opciones.size() == 2){
            layout = new DistribuidorDeDosOpciones(opciones, tipoAgrupable);
        } else if (opciones.size() == 3) {
            layout = new DistribuidorDeTresOpciones(opciones, tipoAgrupable);
        } else if (opciones.size() == 4) {
            layout = new DistribuidorDeCuatroOpciones(opciones, tipoAgrupable);
        } else if (opciones.size() == 5) {
            layout = new DistribuidorDeCincoOpciones(opciones, tipoAgrupable);
        } else {
            layout = new DistribuidorDeSeisOpciones(opciones, tipoAgrupable);
        }
        return layout;
    }
}
