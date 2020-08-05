package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones.*;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class LayoutOpciones {

    private ArrayList<String> opciones;

    LayoutOpciones() {

        opciones = new ArrayList<>();
    }

    public void agregarOpcion(String enunciado) {

        opciones.add(enunciado);
    }

    public StackPane getLayout() {

        StackPane layout = new StackPane();
        if (opciones.size() == 2){
            layout = new DistribuidorDeDosOpciones().getLayout(opciones);
        } else if (opciones.size() == 3) {
            layout = new DistribuidorDeTresOpciones().getLayout(opciones);
        } else if (opciones.size() == 4) {
            layout = new DistribuidorDeCuatroOpciones().getLayout(opciones);
        } else if (opciones.size() == 5) {
            layout = new DistribuidorDeCincoOpciones().getLayout(opciones);
        } else if (opciones.size() == 6) {
            layout = new DistribuidorDeSeisOpciones().getLayout(opciones);
        }

        layout.getChildren().add(new BotonEnviarRespuesta().getBoton());
        return layout;
    }

}
