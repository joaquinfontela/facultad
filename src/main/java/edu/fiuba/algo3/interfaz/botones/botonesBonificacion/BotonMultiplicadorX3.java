package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion.EstilosBotonExclusividad;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion.EstilosBotonMultiplicadorX3;

public class BotonMultiplicadorX3 extends BotonBonificacion {

    public BotonMultiplicadorX3(double posX, double posY) {

        super(posX, posY);
        new EstilosBotonMultiplicadorX3(this).aplicarEstilos(this);

    }
}