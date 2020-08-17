package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonAgrupable;

public class Agrupable extends TipoBoton {

    private char grupo;

    public Agrupable() {

        grupo = 'A';
        estilosBotonPorTipo = new EstilosBotonAgrupable();
    }

    public void switchGrupo() {

        if (grupo == 'A') {
            grupo = 'B';
        } else {
            grupo = 'A';
        }
    }

    public Boolean fueAgrupadaEnElGrupoA() {

        return (grupo == 'A');
    }

    @Override
    public void aplicarEstilos(Boton unBoton) {

        new EstilosBotonAgrupable().aplicarEstilos(unBoton);
    }
}
