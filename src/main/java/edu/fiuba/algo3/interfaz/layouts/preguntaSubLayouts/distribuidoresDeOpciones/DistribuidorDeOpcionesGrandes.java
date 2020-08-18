package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonAgrupableHandler;
import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonOpcionSeleccionableHandler;
import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonOrdenableHandler;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionGrande;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;
import javafx.scene.paint.Color;

public abstract class DistribuidorDeOpcionesGrandes extends DistribuidorDeOpciones {

    protected void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color, Class claseTipoBoton) {

        BotonOpcion opcion = null;
        try {
            opcion = new BotonOpcionGrande(enunciado, desplazamientoEnX, desplazamientoEnY, color, claseTipoBoton, botones);
            if (claseTipoBoton == Agrupable.class) {
                opcion.setOnAction((new BotonAgrupableHandler(opcion)));
            } else if (claseTipoBoton == Ordenable.class) {
                opcion.setOnAction(new BotonOrdenableHandler(opcion));
            } else if (claseTipoBoton == Seleccionable.class) {
                opcion.setOnAction(new BotonOpcionSeleccionableHandler(opcion));
            }
        } catch (Exception e) {}
        this.getChildren().add(opcion);
        botones.add(opcion);
    }
}