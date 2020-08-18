package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonExclusividad;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonMultiplicadorX2;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonMultiplicadorX3;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.scene.layout.StackPane;

public class LayoutBonificaciones extends StackPane {

    BotonMultiplicadorX2 botonMultiplicadorX2;
    BotonMultiplicadorX3 botonMultiplicadorX3;
    BotonExclusividad botonExclusividad;

    public LayoutBonificaciones(GestorDeJuego gestor) {

        botonExclusividad = new BotonExclusividad(-50,-420);
        if (!gestor.jugadorActualTieneAlgunaExclusividad() || !gestor.sePuedeUsarExclusividad()){
            botonExclusividad.setDisable(true);
        }
        this.getChildren().add(botonExclusividad);
        botonMultiplicadorX2 = new BotonMultiplicadorX2(-50, -285);
        if (!gestor.jugadorActualTieneAlgunMultiplicadorX2() || gestor.sePuedeUsarExclusividad()) {
            botonMultiplicadorX2.setDisable(true);
        }
        this.getChildren().add(botonMultiplicadorX2);
        botonMultiplicadorX3 = new BotonMultiplicadorX3(-50, -170);
        if (!gestor.jugadorActualTieneAlgunMultiplicadorX3() || gestor.sePuedeUsarExclusividad()) {
            botonMultiplicadorX3.setDisable(true);
        }
        this.getChildren().add(botonMultiplicadorX3);
    }

    public boolean multiplicadorX2Seleccionado() {
        return botonMultiplicadorX2.fueSeleccionado();
    }

    public boolean multiplicadorX3Seleccionado() {
        return botonMultiplicadorX3.fueSeleccionado();
    }

    public boolean exclusividadSeleccionada() {
        return botonExclusividad.fueSeleccionado();
    }
}