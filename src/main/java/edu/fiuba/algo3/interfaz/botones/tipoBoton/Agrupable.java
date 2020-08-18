package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonAgrupable;

public class Agrupable extends TipoBoton {

    private String grupo;

    public Agrupable() {

        grupo = null;
    }

    public void switchGrupo() {

        if (grupo == "B" || grupo == null) {
            grupo = "A";
        } else {
            grupo = "B";
        }
    }

    public Boolean fueAgrupadaEnElGrupoA() {

        return (grupo == "A");
    }

    @Override
    public void aplicarEstilos(Boton unBoton) {

        new EstilosBotonAgrupable().aplicarEstilos(unBoton);
    }
}
