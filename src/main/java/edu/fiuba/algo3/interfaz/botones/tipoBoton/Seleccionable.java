package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonSeleccionable;

public class Seleccionable extends TipoBoton {

    private Boolean seleccionado;

    public Seleccionable() {

        seleccionado = false;
    }

    public void switchSeleccionado() {
        seleccionado = !seleccionado;
    }

    public Boolean fueSeleccionado() {
        return seleccionado;
    }

    @Override
    public void aplicarEstilos(Boton unBoton) {

        new EstilosBotonSeleccionable().aplicarEstilos(unBoton);
    }
}
