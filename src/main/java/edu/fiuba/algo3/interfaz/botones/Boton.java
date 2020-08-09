package edu.fiuba.algo3.interfaz.botones;

import javafx.scene.control.Button;

public abstract class Boton {

    protected Button boton;
    private Boolean seleccionado;

    public Boton() {

        boton = new Button();
        seleccionado = false;
    }

    public Button getBoton() {
        return boton;
    }

    public void switchSeleccionado() {

        if (seleccionado) {
            seleccionado = false;
        } else {
            seleccionado = true;
        }
    }

    public Boolean fueSeleccionado() {

        return seleccionado;
    }
}
