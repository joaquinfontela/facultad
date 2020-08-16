package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChicoLargo;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DistribuidorDeCuatroOpciones extends StackPane {

    public DistribuidorDeCuatroOpciones(ArrayList<String> opciones, TipoBoton tipoBoton) {

        this.agregarOpcion(opciones.get(0), -300, -50, Color.RED, tipoBoton);
        this.agregarOpcion(opciones.get(1), 300, -50, Color.BLUE, tipoBoton);
        this.agregarOpcion(opciones.get(2), -300, 60, Color.GOLD, tipoBoton);
        this.agregarOpcion(opciones.get(3), 300, 60, Color.GREEN, tipoBoton);
    }

    private void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color, TipoBoton tipoBoton) {

        BotonOpcion opcion = new BotonOpcionChicoLargo(enunciado, desplazamientoEnX, desplazamientoEnY, color, tipoBoton);
        this.getChildren().add(opcion);
    }
}