package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonPorTipo;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonSeleccionable;

public class Seleccionable extends TipoBoton {

    private Boolean seleccionado;

    public Seleccionable() {
        seleccionado = false;
    }

    @Override
    public void switchSeleccionado() {
        seleccionado = !seleccionado;
    }

    @Override
    public Boolean fueSeleccionado() {
        return seleccionado;
    }

    @Override
    public EstilosBotonPorTipo obtenerEstiloBotonSegunTipo() {
        return new EstilosBotonSeleccionable();
    }
}
