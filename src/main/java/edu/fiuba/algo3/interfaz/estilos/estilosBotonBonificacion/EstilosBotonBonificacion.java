package edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.EstilosBoton;

public class EstilosBotonBonificacion extends EstilosBoton {

    public EstilosBotonBonificacion(Boton unManejadorDeBoton) {

        super(unManejadorDeBoton);
        boton.setStyle("-fx-border-color: black; -fx-border-width: 4px");
    }
}
