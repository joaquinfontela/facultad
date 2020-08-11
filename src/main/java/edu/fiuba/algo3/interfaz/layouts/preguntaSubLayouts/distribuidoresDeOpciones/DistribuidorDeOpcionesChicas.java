package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChico;
import javafx.scene.paint.Color;

public abstract class DistribuidorDeOpcionesChicas implements DistribuidorDeOpciones {

    @Override
    public void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color) {

        BotonOpcion opcion = new BotonOpcionChico(enunciado, desplazamientoEnX, desplazamientoEnY, color);
        layout.getChildren().add(opcion);
    }
}