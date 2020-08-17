package edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonPorTipo;
import javafx.geometry.Insets;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class EstilosBotonOpcion extends ButtonSkin {

    protected Boton boton;

    public EstilosBotonOpcion(Boton unBoton, Color color, TipoBoton tipoBoton) {

        super(unBoton);
        boton = unBoton;
        boton.setStyle("-fx-border-color: black; -fx-border-width: 2px");

        boton.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setTextFill(Color.WHITE);

        tipoBoton.aplicarEstilos(boton);
    }
}