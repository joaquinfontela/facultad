package edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.PolygonEditor;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

public abstract class EstilosBotonMultiplicador extends EstilosBotonBonificacion {

    public EstilosBotonMultiplicador(BotonSeleccionable unBoton) {

        super(unBoton);
        Polygon forma = new Polygon();
        Polygon hexagonoEquilatero = new PolygonEditor().setPolygonSides(forma, 1, 1, 1, 6);
        boton.setShape(hexagonoEquilatero);
        boton.setFont(new Font("FreeSans", 35));
    }
}