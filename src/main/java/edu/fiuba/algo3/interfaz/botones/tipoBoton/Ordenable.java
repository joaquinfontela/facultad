package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonPorTipo;

public class Ordenable extends TipoBoton {

    private Integer posicionOrden;

    public Ordenable() {

        posicionOrden = null;
    }

    @Override
    public void asignarOrden(Integer posicionOrden) {

        this.posicionOrden = posicionOrden;
    }

    @Override
    public void desasignarOrden() {

        this.posicionOrden = null;
    }

    @Override
    public Integer getPosicionOrden() {

        return posicionOrden;
    }

    @Override
    public EstilosBotonPorTipo obtenerEstiloBotonSegunTipo() {
        return null;
    }
}
