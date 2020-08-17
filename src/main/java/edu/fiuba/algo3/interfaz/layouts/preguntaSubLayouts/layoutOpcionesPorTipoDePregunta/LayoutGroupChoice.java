package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutGroupChoice;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutMultipleChoice;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.stage.Stage;

public class LayoutGroupChoice extends LayoutPregunta {

    public LayoutGroupChoice(Stage stage, GestorDeJuego gestor) {

        super(stage, gestor);
        generadorLayoutOpciones = new GeneradorLayoutGroupChoice();
        this.setCenter(generadorLayoutOpciones.generarLayout(gestor.obtenerEnunciadosOpcionesActuales()));
    }
}
