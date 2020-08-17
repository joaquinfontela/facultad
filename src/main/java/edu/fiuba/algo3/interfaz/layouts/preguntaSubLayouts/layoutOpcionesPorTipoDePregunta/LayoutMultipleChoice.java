package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutMultipleChoice;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.stage.Stage;

public class LayoutMultipleChoice extends LayoutPregunta {

    public LayoutMultipleChoice(Stage stage, GestorDeJuego gestor) {

        super(stage, gestor);
        generadorLayoutOpciones = new GeneradorLayoutMultipleChoice();
        this.setCenter(generadorLayoutOpciones.generarLayout(gestor.obtenerEnunciadosOpcionesActuales()));
    }
}
