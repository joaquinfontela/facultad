package edu.fiuba.algo3.controladores.controladoresBotonesOpcion;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonOrdenableHandler implements EventHandler<ActionEvent> {

    private BotonOpcion boton;
    private Ordenable tipoBoton;

    public BotonOrdenableHandler(BotonOpcion botonOpcion) {

        boton = botonOpcion;
        tipoBoton = (Ordenable) boton.getTipo();
    }

    @Override
    public void handle(ActionEvent e) {

        if (tipoBoton.getPosicionOrden() == null) {
            tipoBoton.asignarOrden();
            boton.setText(boton.getText() + " (" + tipoBoton.getPosicionOrden().toString() + ")");
        } else {
            tipoBoton.desasignarOrden();
            boton.setText(boton.getText().substring(0, boton.getText().length() - 4));
        }

    }

}