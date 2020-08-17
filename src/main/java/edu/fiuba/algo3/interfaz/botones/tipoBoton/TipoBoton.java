package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.botonesOpcion.BotonOpcion;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonPorTipo;

import java.util.ArrayList;

public abstract class TipoBoton {

    protected EstilosBotonPorTipo estilosBotonPorTipo;
    protected ArrayList<BotonOpcion> botonesDeLaMismaPregunta;

    public TipoBoton() {

        botonesDeLaMismaPregunta = null;
    }

    public void agregarBotones(ArrayList<BotonOpcion> botones) {

        botonesDeLaMismaPregunta = botones;
    }

    public abstract void aplicarEstilos(Boton unBoton);
}
