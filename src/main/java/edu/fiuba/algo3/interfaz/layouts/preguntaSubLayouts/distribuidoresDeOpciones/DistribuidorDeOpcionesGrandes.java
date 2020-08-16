package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionGrande;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public abstract class DistribuidorDeOpcionesGrandes extends StackPane {

    protected void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color, TipoBoton tipoBoton) {

        BotonOpcion opcion = new BotonOpcionGrande(enunciado, desplazamientoEnX, desplazamientoEnY, color, tipoBoton);
        this.getChildren().add(opcion);
    }
}