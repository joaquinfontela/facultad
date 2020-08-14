package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChicoLargo;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeCuatroOpciones extends StackPane {

    public DistribuidorDeCuatroOpciones(ArrayList<String> opciones) {

        this.agregarOpcion(opciones.get(0), -300, -50, Color.RED);
        this.agregarOpcion(opciones.get(1), 300, -50, Color.BLUE);
        this.agregarOpcion(opciones.get(2), -300, 60, Color.GOLD);
        this.agregarOpcion(opciones.get(3), 300, 60, Color.GREEN);
    }

    private void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color) {

        BotonOpcion opcion = new BotonOpcionChicoLargo(enunciado, desplazamientoEnX, desplazamientoEnY, color);
        this.getChildren().add(opcion);
    }
}