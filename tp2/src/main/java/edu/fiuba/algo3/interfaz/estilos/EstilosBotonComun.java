package edu.fiuba.algo3.interfaz.estilos;

import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;

public class EstilosBotonComun extends ButtonSkin {

    protected Button boton;

    public EstilosBotonComun(Button unBoton) {

        super(unBoton);

        boton = unBoton;

        eventoMousePasaPorArriba();
    }

    protected void eventoMousePasaPorArriba() {

        new FadeInBoton(boton, 1.0);
        new FadeOutBoton(boton, 0.8);

        boton.setOpacity(0.8);
    }
}
