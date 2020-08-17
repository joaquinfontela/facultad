package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChico;
import javafx.scene.paint.Color;

public abstract class DistribuidorDeOpcionesChicas extends DistribuidorDeOpciones {

    public DistribuidorDeOpcionesChicas() {

        super();
    }

    protected void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color, Class claseTipoBoton) {

        BotonOpcion opcion = null;
        try {
            opcion = new BotonOpcionChico(enunciado, desplazamientoEnX, desplazamientoEnY, color, claseTipoBoton, botones);
        } catch (Exception e) { }
        this.getChildren().add(opcion);
        botones.add(opcion);
    }
}