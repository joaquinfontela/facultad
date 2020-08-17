package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion.EstilosBotonExclusividad;

public class BotonExclusividad extends BotonBonificacion {

    public BotonExclusividad(double posX, double posY) {

        super(posX, posY);
        new EstilosBotonExclusividad(this).aplicarEstilos(this);
    }
}