package edu.fiuba.algo3.controladores.controladoresBotonesOpcion;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BotonAgrupableHandler implements EventHandler<ActionEvent> {

    private BotonOpcion boton;
    private Agrupable tipoBoton;

    public BotonAgrupableHandler(BotonOpcion botonAgrupable) {

        boton = botonAgrupable;
        tipoBoton = (Agrupable) boton.getTipo();
    }

    @Override
    public void handle(ActionEvent event) {

        tipoBoton.switchGrupo();
        if (tipoBoton.fueAgrupadaEnElGrupoA()) {
            boton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            boton.setTextFill(Color.BLACK);
        } else {
            boton.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            boton.setTextFill(Color.WHITE);
        }
    }
}