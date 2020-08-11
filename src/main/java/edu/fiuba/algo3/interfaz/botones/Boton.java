package edu.fiuba.algo3.interfaz.botones;

import javafx.scene.control.Button;

public abstract class Boton extends Button {

    private Boolean seleccionado;

    public Boton() {
        seleccionado = false;
    }

    public void switchSeleccionado() {
        seleccionado = !seleccionado;
    }

    public Boolean fueSeleccionado() {
        return seleccionado;
    }
}