package edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import edu.fiuba.algo3.interfaz.estilos.FadeInBoton;
import edu.fiuba.algo3.interfaz.estilos.FadeOutBoton;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class EstilosBotonAgrupable implements EstilosBotonPorTipo {

    private Boton boton;
    private Agrupable agrupable;

    public void aplicarEstilos(Boton unBoton) {

        boton = unBoton;
        boton.setBackground(new Background(new BackgroundFill(Color.web("d8b97b"), CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setTextFill(Color.BLACK);
        agrupable = (Agrupable) boton.getTipo();

        eventoMousePasaPorArriba();
    }

    public void eventoMousePasaPorArriba() {

        new FadeInBoton(boton, 1.0);
        new FadeOutBoton(boton, 0.8);

        boton.setOpacity(0.8);
    }
}
