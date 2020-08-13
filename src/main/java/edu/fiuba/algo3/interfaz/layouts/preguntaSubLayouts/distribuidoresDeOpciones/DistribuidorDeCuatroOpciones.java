package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChicoLargo;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeCuatroOpciones implements DistribuidorDeOpciones {

    @Override
    public void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color) {

        BotonOpcion opcion = new BotonOpcionChicoLargo(enunciado, desplazamientoEnX, desplazamientoEnY, color);
        layout.getChildren().add(opcion);
    }

    @Override
    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -300, -50, Color.RED);
        agregarOpcion(opciones.get(1), 300, -50, Color.BLUE);
        agregarOpcion(opciones.get(2), -300, 60, Color.GOLD);
        agregarOpcion(opciones.get(3), 300, 60, Color.GREEN);
        return layout;
    }
}