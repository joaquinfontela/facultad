package edu.fiuba.algo3.interfaz.estilos;

import javafx.scene.shape.Polygon;

public class Tic extends Polygon {

    public Tic() {

        super();
        this.getPoints().addAll(0.0, 0.0,
                1.0, 1.0,
                2.0, 0.0,
                3.0, -1.0,
                4.0, -2.0,
                5.0, -2.0,
                4.0, -1.0,
                3.0, 0.0,
                2.0, 1.0,
                1.0, 2.0,
                0.0, 1.0,
                -1.0, 0.0);
    }
}
