package edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Ordenable;
import edu.fiuba.algo3.interfaz.estilos.FadeInBoton;
import edu.fiuba.algo3.interfaz.estilos.FadeOutBoton;
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

        new FadeInBoton(boton, 1.0);
        new FadeOutBoton(boton, 0.8);

        boton.setOpacity(0.8);
    }

}
