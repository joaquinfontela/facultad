package edu.fiuba.algo3.controladores.controladoresBotonesOpcion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.event.ActionEvent;

public class BotonVerdaderoOFalsoHandler extends BotonSeleccionableHandler {

    public BotonVerdaderoOFalsoHandler(Boton botonSeleccionable) {

        super(botonSeleccionable);
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        super.handle(actionEvent);
        tipoBoton.deseleccionarLosDemasBotonesDeLaPregunta();
    }
}
