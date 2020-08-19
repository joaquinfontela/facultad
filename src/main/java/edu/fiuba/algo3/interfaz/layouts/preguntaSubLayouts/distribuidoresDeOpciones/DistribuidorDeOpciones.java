package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones;

import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonAgrupableHandler;
import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonOrdenableHandler;
import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonSeleccionableHandler;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public abstract class DistribuidorDeOpciones extends StackPane {

    protected ArrayList<BotonOpcion> botones;

    public DistribuidorDeOpciones() {

        botones = new ArrayList<>();
    }

    public ArrayList<BotonOpcion> obtenerBotones() {

        return botones;
    }

    protected void agregarHandler(Class claseTipoBoton, BotonOpcion opcion) {

        if (claseTipoBoton == Agrupable.class) {
            opcion.setOnAction((new BotonAgrupableHandler(opcion)));
        } else if (claseTipoBoton == Ordenable.class) {
            opcion.setOnAction(new BotonOrdenableHandler(opcion));
        } else if (claseTipoBoton == Seleccionable.class) {
            opcion.setOnAction(new BotonSeleccionableHandler(opcion));
        }
    }
}
