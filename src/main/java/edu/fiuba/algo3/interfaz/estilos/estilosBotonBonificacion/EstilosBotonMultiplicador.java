package edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.PolygonEditor;
import edu.fiuba.algo3.interfaz.estilos.EstilosBoton;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

public abstract class EstilosBotonMultiplicador extends EstilosBoton {

    public EstilosBotonMultiplicador(Boton manejadorDeBoton) {
        super(manejadorDeBoton);

        Polygon forma = new Polygon();
        Polygon hexagonoEquilatero = new PolygonEditor().setPolygonSides(forma, 1, 1, 1, 6);
        boton.setShape(hexagonoEquilatero);
        boton.setFont(new Font("FreeSans", 35));
    }
}
