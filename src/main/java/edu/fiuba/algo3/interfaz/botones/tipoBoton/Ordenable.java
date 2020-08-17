package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonOrdenable;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonPorTipo;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonSeleccionable;

public class Ordenable extends TipoBoton {

    private Integer posicionOrden;

    public Ordenable() {

        posicionOrden = null;
        estilosBotonPorTipo = new EstilosBotonOrdenable();
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
    public void aplicarEstilos(Boton unBoton) {

        new EstilosBotonOrdenable().aplicarEstilos(unBoton);
    }
}
