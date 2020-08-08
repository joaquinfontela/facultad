package edu.fiuba.algo3.interfaz.botones;

import javafx.scene.control.Button;

public abstract class Boton {

    protected Button boton;
    private Boolean seleccionado;

    public Button getBoton() {
        return boton;
    }

    public Boolean seleccionado() {

        return seleccionado;
    }
}
