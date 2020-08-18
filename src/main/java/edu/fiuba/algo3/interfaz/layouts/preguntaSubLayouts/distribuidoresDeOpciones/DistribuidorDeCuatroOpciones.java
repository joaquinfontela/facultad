package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonAgrupableHandler;
import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonOrdenableHandler;
import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonSeleccionableHandler;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcionChicoLargo;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DistribuidorDeCuatroOpciones extends DistribuidorDeOpciones {

    public DistribuidorDeCuatroOpciones(ArrayList<String> opciones, Class claseTipoBoton) {

        this.agregarOpcion(opciones.get(0), -300, -50, Color.RED, claseTipoBoton);
        this.agregarOpcion(opciones.get(1), 300, -50, Color.BLUE, claseTipoBoton);
        this.agregarOpcion(opciones.get(2), -300, 60, Color.GOLD, claseTipoBoton);
        this.agregarOpcion(opciones.get(3), 300, 60, Color.GREEN, claseTipoBoton);
    }

    private void agregarOpcion(String enunciado, Integer desplazamientoEnX, Integer desplazamientoEnY, Color color, Class claseTipoBoton) {

        BotonOpcion opcion = null;
        try {
            opcion = new BotonOpcionChicoLargo(enunciado, desplazamientoEnX, desplazamientoEnY, color, claseTipoBoton, botones);
            if (claseTipoBoton == Agrupable.class) {
                opcion.setOnAction((new BotonAgrupableHandler(opcion)));
            } else if (claseTipoBoton == Ordenable.class) {
                opcion.setOnAction(new BotonOrdenableHandler(opcion));
            } else if (claseTipoBoton == Seleccionable.class) {
                opcion.setOnAction(new BotonSeleccionableHandler(opcion));
            }
        } catch (Exception e) {}
        this.getChildren().add(opcion);
        botones.add(opcion);
    }
}