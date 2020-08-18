package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutGroupChoice;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import javafx.stage.Stage;

public class LayoutGroupChoice extends LayoutPregunta {

    public LayoutGroupChoice(Stage stage, GestorDeJuego gestor) {

        super(stage, gestor);
        generadorLayoutOpciones = new GeneradorLayoutGroupChoice();
        this.setCenter(generadorLayoutOpciones.generarLayout(gestor.obtenerEnunciadosOpcionesActuales()));
    }

    public EnunciadosOpciones obtenerEnunciadosRespuestaUsuario() {

        EnunciadosOpciones enunciadosRespuestaUsuario = new EnunciadosOpciones();

        for (BotonOpcion botonOpcion : this.obtenerBotones()) {
            Agrupable tipoBoton = (Agrupable) botonOpcion.getTipo();
            if (tipoBoton.fueAgrupadaEnElGrupoA()) {
                enunciadosRespuestaUsuario.agregarEnunciadoEidentificador(0, botonOpcion.getText());
            } if (tipoBoton.fueAgrupadaEnElGrupoB()) {
                enunciadosRespuestaUsuario.agregarEnunciadoEidentificador(1, botonOpcion.getText());
            }
        }

        return enunciadosRespuestaUsuario;
    }
}
