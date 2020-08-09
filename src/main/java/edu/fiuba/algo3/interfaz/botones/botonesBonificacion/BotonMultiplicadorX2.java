package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion.EstilosBotonMultiplicadorX2;

public class BotonMultiplicadorX2 extends BotonBonificacion {

    public BotonMultiplicadorX2(double posX, double posY) {

        super(posX, posY);
        boton.setSkin(new EstilosBotonMultiplicadorX2(this));
    }
}
