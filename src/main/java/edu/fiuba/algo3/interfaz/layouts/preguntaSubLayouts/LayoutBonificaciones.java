package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonExclusividad;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonMultiplicadorX2;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonMultiplicadorX3;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.scene.layout.StackPane;

public class LayoutBonificaciones extends StackPane {

    public LayoutBonificaciones(GestorDeJuego gestor) {

        BotonExclusividad botonExclusividad = new BotonExclusividad(-50,-420);
        if (!gestor.jugadorActualTieneAlgunaExclusividad()) botonExclusividad.setDisable(true);
        this.getChildren().add(botonExclusividad);
        BotonMultiplicadorX2 botonMultiplicadorX2 = new BotonMultiplicadorX2(-50, -285);
        if (!gestor.jugadorActualTieneAlgunMultiplicadorX2()) botonExclusividad.setDisable(true);
        this.getChildren().add(botonMultiplicadorX2);
        BotonMultiplicadorX3 botonMultiplicadorX3 = new BotonMultiplicadorX3(-50, -170);
        if (!gestor.jugadorActualTieneAlgunMultiplicadorX3()) botonExclusividad.setDisable(true);

        this.getChildren().add(botonMultiplicadorX3);
    }
}