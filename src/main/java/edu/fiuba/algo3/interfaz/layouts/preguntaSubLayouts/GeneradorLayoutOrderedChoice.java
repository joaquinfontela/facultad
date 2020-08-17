package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones.*;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class GeneradorLayoutOrderedChoice implements GeneradorLayoutOpciones {

    StackPane layout;

    @Override
    public StackPane generarLayout(ArrayList<String> opciones) {

        Class tipoOrdenable = Ordenable.class;

        if (opciones.size() == 2){
            layout = new DistribuidorDeDosOpciones(opciones, tipoOrdenable);
        } else if (opciones.size() == 3) {
            layout = new DistribuidorDeTresOpciones(opciones,tipoOrdenable);
        } else if (opciones.size() == 4) {
            layout = new DistribuidorDeCuatroOpciones(opciones, tipoOrdenable);
        } else if (opciones.size() == 5) {
            layout = new DistribuidorDeCincoOpciones(opciones, tipoOrdenable);
        } else {
            layout = new DistribuidorDeSeisOpciones(opciones, tipoOrdenable);
        }
        return layout;
    }
}
