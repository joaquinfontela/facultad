package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion.EstilosBotonOpcionGrande;
import javafx.scene.paint.Color;

public class BotonOpcionGrande extends BotonOpcion {

    public BotonOpcionGrande(String enunciado, double posX, double posY, Color color, TipoBoton tipoBoton) {

        super(enunciado, posX, posY, tipoBoton);
        this.setSkin(new EstilosBotonOpcionGrande(this, color));
    }
}