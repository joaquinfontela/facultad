package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonOrdenable;

public class Ordenable extends TipoBoton {

    private Integer posicionOrden;

    public Ordenable() {

        posicionOrden = null;
    }

    public void asignarOrden() {

        this.posicionOrden = obtenerProximaPosicionAAsignar();
    }

    private Integer obtenerProximaPosicionAAsignar() {

        Integer mayorPosicion = 0;
        for (BotonOpcion boton : botonesDeLaMismaPregunta) {
            Integer posBotonActual = boton.obtenerPosicionOrden();
            if ((posBotonActual != null) && (posBotonActual >= mayorPosicion)) {
                mayorPosicion = posBotonActual;
            }
        }

        return (mayorPosicion + 1);
    }

    public void desasignarOrden() {

        BotonOpcion botonEnLaSiguientePosicion = obtenerBotonEnLaSiguientePosicion();
        if (botonEnLaSiguientePosicion != null) {
            botonEnLaSiguientePosicion.desasignarOrden();
            botonEnLaSiguientePosicion.setText(botonEnLaSiguientePosicion.getText().substring(0, botonEnLaSiguientePosicion.getText().length() - 4));
        }
        posicionOrden = null;
    }

    private BotonOpcion obtenerBotonEnLaSiguientePosicion() {

        for (BotonOpcion boton : botonesDeLaMismaPregunta) {
            Integer posOrdenBoton = boton.obtenerPosicionOrden();
            if ((posOrdenBoton != null) && (posOrdenBoton == this.posicionOrden + 1)) {
                return boton;
            }
        }

        return null;
    }

    public Integer getPosicionOrden() {

        return posicionOrden;
    }

    @Override
    public void aplicarEstilos(Boton unBoton) {

        estilosBotonPorTipo = new EstilosBotonOrdenable();
        estilosBotonPorTipo.aplicarEstilos(unBoton);
    }
}
