package edu.fiuba.algo3.controladores.controladoresBotonesOpcion;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonOpcionSeleccionableHandler implements EventHandler<ActionEvent> {

    private BotonOpcion boton;
    private Seleccionable tipoBoton;

    public BotonOpcionSeleccionableHandler(BotonOpcion botonSeleccionable) {

        boton = botonSeleccionable;
        tipoBoton = (Seleccionable) boton.getTipo();
    }

    @Override
    public void handle(ActionEvent event) {

        tipoBoton.switchSeleccionado();
        actualizarOpacidad();
    }

    private void actualizarOpacidad() {

        if (tipoBoton.fueSeleccionado()) {
            boton.setOpacity(1.0);
        } else {
            boton.setOpacity(0.6);
        }
    }
}