package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.BotonBonificacion;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.Seleccionable;

import java.util.ArrayList;

public class ListaDeBotonesMultiplicador extends ArrayList<BotonBonificacion> {

    public ListaDeBotonesMultiplicador() {
        super();
    }

    @Override
    public boolean add(BotonBonificacion boton) {

        boolean valorADevolver = super.add(boton);
        boton.setOnMouseClicked(e -> {
            for (BotonBonificacion b : this){
                if (!b.equals(boton) && b.fueSeleccionado()) {
                    Seleccionable tipoSeleccionable = (Seleccionable) b.getTipo();
                    tipoSeleccionable.switchSeleccionado();
                    actualizarOpacidad(b);
                }
            }
        });
        return valorADevolver;
    }

    private void actualizarOpacidad(BotonBonificacion boton) {

        if (boton.fueSeleccionado()) {
            boton.setOpacity(1.0);
        } else {
            boton.setOpacity(0.6);
        }
    }
}
