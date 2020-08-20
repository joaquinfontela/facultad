package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
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

    public void deseleccionarLosDemasBotonesDeLaPregunta() {

        for (BotonOpcion botonOpcion : botonesDeLaMismaPregunta) {

            Seleccionable tipoSeleccionable = (Seleccionable) botonOpcion.getTipo();
            if ((tipoSeleccionable.fueSeleccionado()) && (tipoSeleccionable != this)) {

                tipoSeleccionable.switchSeleccionado();
                botonOpcion.setOpacity(0.6);
            }
        }
    }
}
