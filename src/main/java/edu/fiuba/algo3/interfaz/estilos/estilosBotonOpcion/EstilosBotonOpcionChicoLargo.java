package edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EstilosBotonOpcionChicoLargo extends EstilosBotonOpcion {


    public EstilosBotonOpcionChicoLargo(Button opcion, Color color) {

        super(opcion, color);

        opcion.setFont(new Font("FreeSans", 55));
        opcion.setPrefSize(600, 100);
    }
}
