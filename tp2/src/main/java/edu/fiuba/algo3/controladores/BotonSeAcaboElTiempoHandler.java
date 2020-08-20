package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonSeAcaboElTiempoHandler extends BotonTerminarTurnoHandler {

    public BotonSeAcaboElTiempoHandler(Stage UnStage, GestorDeJuego unGestor) {

        super(UnStage, unGestor);
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            gestor.avanzarSiguienteTurno();
            this.cambiarEscena();
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
