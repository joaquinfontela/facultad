package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion.EstilosBotonOpcionChico;
import javafx.scene.paint.Color;

public class BotonOpcionChico extends BotonOpcion {

    public BotonOpcionChico(String enunciado, double posX, double posY, Color color, TipoBoton tipoBoton) {

        super(enunciado, posX, posY, tipoBoton);
        this.setSkin(new EstilosBotonOpcionChico(this, color));
    }
}