package edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class EstilosBotonOrdenable implements EstilosBotonPorTipo {

    protected Boton boton;
    protected Ordenable ordenable;

    public void aplicarEstilos(Boton unBoton) {

        boton = unBoton;
        ordenable = (Ordenable) boton.getTipo();

        eventoMousePasaPorArriba();
    }

    public void eventoMousePasaPorArriba() {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(0.8);
        boton.setOnMouseEntered(e -> {
            fadeIn.playFromStart();

        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.6);
        boton.setOnMouseExited(e -> {
            fadeOut.playFromStart();
        });

        boton.setOpacity(0.6);
    }

}
