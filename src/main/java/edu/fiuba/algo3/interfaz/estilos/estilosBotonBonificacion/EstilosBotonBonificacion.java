package edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.EstilosBotonSeleccionable;

public class EstilosBotonBonificacion extends EstilosBotonSeleccionable {

    public EstilosBotonBonificacion(Boton unBoton) {

        super(unBoton);
        boton.setStyle("-fx-border-color: black; -fx-border-width: 4px");
    }
}