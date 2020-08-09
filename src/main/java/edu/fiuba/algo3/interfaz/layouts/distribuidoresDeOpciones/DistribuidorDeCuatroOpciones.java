package edu.fiuba.algo3.interfaz.layouts.distribuidoresDeOpciones;

//cC

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChicoLargo;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeCuatroOpciones implements DistribuidorDeOpciones {

    @Override
    public void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color) {

        BotonOpcion opcion = new BotonOpcionChicoLargo(enunciado, desplazamientoEnX, desplazamientoEnY, color);
        layout.getChildren().add(opcion.getBoton());
    }

    @Override
    public StackPane getLayout(ArrayList<String> opciones) {

        agregarOpcion(opciones.get(0), -375, -100, Color.RED);
        agregarOpcion(opciones.get(1), 375, -100, Color.BLUE);
        agregarOpcion(opciones.get(2), -375, 50, Color.GOLD);
        agregarOpcion(opciones.get(3), 375, 50, Color.GREEN);
        return layout;
    }
}
