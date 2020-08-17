package edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class EstilosBotonAgrupable implements EstilosBotonPorTipo {

    private Boton boton;
    private TipoBoton agrupable;

    public void aplicarEstilos(Boton unBoton) {

        boton = unBoton;
        agrupable = boton.getTipo();

        eventoMousePasaPorArriba();
        eventoBotonClickeado();
    }

    public void eventoMousePasaPorArriba() {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(boton);
        fadeIn.setToValue(1.0);
        boton.setOnMouseEntered(e -> {
            fadeIn.playFromStart();
        });

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
        fadeOut.setNode(boton);
        fadeOut.setToValue(0.8);
        boton.setOnMouseExited(e -> {
            fadeOut.playFromStart();
        });

        boton.setOpacity(0.8);
    }

    public void eventoBotonClickeado() {

        boton.setOnMouseClicked(e -> {

            if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
                try {
                    agrupable.switchGrupo();
                    actualizarGrupo();
                } catch (Exception exception) { }
            }
        });
    }

    private void actualizarGrupo() throws Exception {

        if (agrupable.fueAgrupadaEnElGrupoA()) {
            boton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            boton.setTextFill(Color.BLACK);
        } else {
            boton.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            boton.setTextFill(Color.WHITE);
        }
    }
}
