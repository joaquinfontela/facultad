package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion.EstilosBotonOpcionChicoLargo;
import javafx.scene.paint.Color;

public class BotonOpcionChicoLargo extends BotonOpcion {

    public BotonOpcionChicoLargo(String enunciado, double posX, double posY, Color color, TipoBoton tipoBoton) {

        super(enunciado, posX, posY, tipoBoton);
        this.setSkin(new EstilosBotonOpcionChicoLargo(this, color));
    }
}