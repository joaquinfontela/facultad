package edu.fiuba.algo3.interfaz.botones.tipoBoton;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonPorTipo.EstilosBotonPorTipo;

public abstract class TipoBoton {

    protected EstilosBotonPorTipo estilosBotonPorTipo;

    public void switchSeleccionado() throws Exception {

        throw new Exception("Atributo 'seleccionado' invalido.");
    }

    public Boolean fueSeleccionado() throws Exception {

        throw new Exception("Atributo 'seleccionado' invalido.");
    }

    public void switchGrupo() throws Exception {

        throw new Exception("Atributo 'grupo' invalido.");
    }

    public Boolean fueAgrupadaEnElGrupoA() throws Exception {

        throw new Exception("Atributo 'grupo' invalido.");
    }

    public void asignarOrden(Integer posicionOrden) throws Exception {

        throw new Exception("Atributo 'posicionOrden' invalido.");
    }

    public void desasignarOrden() throws Exception {

        throw new Exception("Atributo 'posicionOrden' invalido.");
    }

    public Integer getPosicionOrden() throws Exception {

        throw new Exception("Atributo 'posicionOrden' invalido.");
    }

    public abstract void aplicarEstilos(Boton unBoton);
}
