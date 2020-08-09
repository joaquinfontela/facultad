package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion.EstilosBotonOpcionChicoLargo;
import javafx.scene.paint.Color;

public class BotonOpcionChicoLargo extends BotonOpcion {

    public BotonOpcionChicoLargo(String enunciado, double posX, double posY, Color color) {

        super(enunciado, posX, posY, color);
        boton.setSkin(new EstilosBotonOpcionChicoLargo(this, color));
    }
}
