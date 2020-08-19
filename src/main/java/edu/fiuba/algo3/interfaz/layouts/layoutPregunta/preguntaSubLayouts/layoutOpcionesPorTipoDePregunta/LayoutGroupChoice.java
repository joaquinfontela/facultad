package edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Agrupable;
import edu.fiuba.algo3.interfaz.layouts.layoutPregunta.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.layoutPregunta.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutGroupChoice;
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
                enunciadosRespuestaUsuario.agregarEnunciadoGrupoA(botonOpcion.getText());
            } else if (tipoBoton.fueAgrupadaEnElGrupoB()) {
                enunciadosRespuestaUsuario.agregarEnunciadoGrupoB(botonOpcion.getText());
            }
        }

        return enunciadosRespuestaUsuario;
    }

    @Override
    public boolean sePuedeEnviarRespuesta() {
        for (BotonOpcion botonOpcion : this.obtenerBotones()) {
            Agrupable tipoBoton = (Agrupable) botonOpcion.getTipo();
            if (!(tipoBoton.fueAgrupadaEnElGrupoA()) && !(tipoBoton.fueAgrupadaEnElGrupoB())) {
                return false;
            }
        }
        return true;
    }
}
