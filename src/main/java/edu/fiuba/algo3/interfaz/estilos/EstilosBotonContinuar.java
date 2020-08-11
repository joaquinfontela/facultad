package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion.EstilosBotonBonificacion;

public class EstilosBotonContinuar extends EstilosBoton {

    public EstilosBotonContinuar(Boton unBoton) {

        super(unBoton);
        boton.setText("CONTINUAR >>");
        boton.setPrefSize(500, 200);
        boton.setStyle("-fx-background-color: transparent; -fx-text-fill: lawngreen; -fx-font-size: 50px");
    }
}
