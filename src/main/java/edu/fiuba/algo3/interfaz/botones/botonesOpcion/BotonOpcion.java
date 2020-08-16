package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.BotonSeleccionable;
import javafx.scene.paint.Color;

public abstract class BotonOpcion extends BotonSeleccionable {

    public BotonOpcion(String enunciado, double posX, double posY, Color color) {

        super();
        this.setText(enunciado);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
}