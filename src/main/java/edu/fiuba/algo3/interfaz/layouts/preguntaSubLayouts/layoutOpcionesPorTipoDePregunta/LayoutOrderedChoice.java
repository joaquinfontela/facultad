package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.layoutOpcionesPorTipoDePregunta;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.layouts.LayoutPregunta;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts.GeneradorLayoutOrderedChoice;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import javafx.stage.Stage;

public class LayoutOrderedChoice extends LayoutPregunta {

    public LayoutOrderedChoice(Stage stage, GestorDeJuego gestor) {

        super(stage, gestor);
        generadorLayoutOpciones = new GeneradorLayoutOrderedChoice();
        this.setCenter(generadorLayoutOpciones.generarLayout(gestor.obtenerEnunciadosOpcionesActuales()));
    }

    public EnunciadosOpciones obtenerEnunciadosRespuestaUsuario() {

        EnunciadosOpciones enunciadosRespuestaUsuario = new EnunciadosOpciones();
        Integer cantidadDeOpcionesSinOrdenar = 0;
        Integer cantidadDeOpcionesOrdenadas = 0;

        for (BotonOpcion botonOpcion : this.obtenerBotones()) {

            if (botonOpcion.obtenerPosicionOrden() != null) {
                cantidadDeOpcionesSinOrdenar++;
            } else {
                enunciadosRespuestaUsuario.agregarEnunciadoEidentificador(botonOpcion.obtenerPosicionOrden() - 1,
                                                        botonOpcion.getText().substring(0, botonOpcion.getText().length() - 4));
                cantidadDeOpcionesOrdenadas++;
            }
        }

        for (int i = 0; i < cantidadDeOpcionesSinOrdenar; i++) {
            enunciadosRespuestaUsuario.agregarEnunciadoEidentificador(cantidadDeOpcionesOrdenadas + i, null);
        }

        return enunciadosRespuestaUsuario;
    }
}
