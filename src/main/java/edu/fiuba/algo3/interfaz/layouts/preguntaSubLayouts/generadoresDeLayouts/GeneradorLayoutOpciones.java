package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.generadoresDeLayouts;

import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts.distribuidoresDeOpciones.*;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public abstract class GeneradorLayoutOpciones {

    protected DistribuidorDeOpciones layout;

    public abstract StackPane generarLayout(ArrayList<String> opciones);

    public StackPane obtenerLayout(ArrayList<String> opciones, Class claseTipoBoton) {

        if (opciones.size() == 2){
            layout = new DistribuidorDeDosOpciones(opciones, claseTipoBoton);
        } else if (opciones.size() == 3) {
            layout = new DistribuidorDeTresOpciones(opciones, claseTipoBoton);
        } else if (opciones.size() == 4) {
            layout = new DistribuidorDeCuatroOpciones(opciones, claseTipoBoton);
        } else if (opciones.size() == 5) {
            layout = new DistribuidorDeCincoOpciones(opciones, claseTipoBoton);
        } else {
            layout = new DistribuidorDeSeisOpciones(opciones, claseTipoBoton);
        }
        return layout;
    }

    public abstract ArrayList<BotonOpcion> obtenerBotones();
}