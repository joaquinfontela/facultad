package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta;

import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutMultipleChoice;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutOrderedChoice;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.stage.Stage;

public class LayoutOrderedChoice extends LayoutPregunta {

    public LayoutOrderedChoice(Stage stage, GestorDeJuego gestor) {

        super(stage, gestor);
        generadorLayoutOpciones = new GeneradorLayoutOrderedChoice();
        this.setCenter(generadorLayoutOpciones.generarLayout(gestor.obtenerEnunciadosOpcionesActuales()));
    }
}
