package edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion;

import edu.fiuba.algo3.interfaz.estilos.EstilosBoton;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class EstilosBotonOpcion extends EstilosBoton {

    public EstilosBotonOpcion(Button opcion, Color color) {
        super(opcion);

        opcion.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        opcion.setTextFill(Color.WHITE);
    }
}
