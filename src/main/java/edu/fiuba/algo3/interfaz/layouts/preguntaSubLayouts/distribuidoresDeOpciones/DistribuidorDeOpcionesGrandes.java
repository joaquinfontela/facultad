package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChicoLargo;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionGrande;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public abstract class DistribuidorDeOpcionesGrandes extends DistribuidorDeOpciones {

    protected void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color, Class claseTipoBoton) {

        BotonOpcion opcion = null;
        try {
            opcion = new BotonOpcionGrande(enunciado, desplazamientoEnX, desplazamientoEnY, color, claseTipoBoton, botones);
        } catch (Exception e) {}
        this.getChildren().add(opcion);
        botones.add(opcion);
    }
}