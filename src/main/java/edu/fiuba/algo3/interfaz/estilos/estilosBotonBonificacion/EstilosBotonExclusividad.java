package edu.fiuba.algo3.interfaz.estilos.estilosBotonBonificacion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.botonesBonificacion.PolygonEditor;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

public class EstilosBotonExclusividad extends EstilosBotonBonificacion {

    public EstilosBotonExclusividad(Boton unBoton) {
        super(unBoton);

        Polygon forma = new Polygon();
        Polygon pentagonoEquilatero = new PolygonEditor().setPolygonSides(forma, 1, 1, 1, 5);
        boton.setShape(pentagonoEquilatero);
        boton.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        boton.setText("E");
        boton.setFont(new Font("FreeSans", 55));
    }
}