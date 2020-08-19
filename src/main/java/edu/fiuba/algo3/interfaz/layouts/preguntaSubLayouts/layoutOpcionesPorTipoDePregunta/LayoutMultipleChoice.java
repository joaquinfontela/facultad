package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta;

import edu.fiuba.algo3.controladores.controladoresBotonesOpcion.BotonVerdaderoOFalsoHandler;
import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;
import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutMultipleChoice;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LayoutMultipleChoice extends LayoutPregunta {

    public LayoutMultipleChoice(Stage stage, GestorDeJuego gestor) {

        super(stage, gestor);
        generadorLayoutOpciones = new GeneradorLayoutMultipleChoice();
        this.setCenter(generadorLayoutOpciones.generarLayout(gestor.obtenerEnunciadosOpcionesActuales()));
        agregarExclusividadDeEleccionDeOpcionEnCasoDeVerdaderoOFalso(gestor);
    }

    public void agregarExclusividadDeEleccionDeOpcionEnCasoDeVerdaderoOFalso(GestorDeJuego gestorDeJuego) {

        if (gestorDeJuego.esTipoDeRespuestaComparable(RespuestaVerdaderoFalso.class)) {

            ArrayList<BotonOpcion> botones = generadorLayoutOpciones.obtenerBotones();
            for (BotonOpcion botonOpcion : botones) {

                botonOpcion.setOnAction(new BotonVerdaderoOFalsoHandler(botonOpcion));
            }
        }
    }

    public EnunciadosOpciones obtenerEnunciadosRespuestaUsuario() {

        EnunciadosOpciones enunciadosRespuestaUsuario = new EnunciadosOpciones();

        for (BotonOpcion botonOpcion : this.obtenerBotones()) {
            Seleccionable tipoBoton = (Seleccionable) botonOpcion.getTipo();
            if (tipoBoton.fueSeleccionado()) {
                enunciadosRespuestaUsuario.agregarEnunciadoEidentificador(1, botonOpcion.getText());
            } else {
                enunciadosRespuestaUsuario.agregarEnunciadoEidentificador(0, botonOpcion.getText());
            }
        }

        return enunciadosRespuestaUsuario;
    }
}
