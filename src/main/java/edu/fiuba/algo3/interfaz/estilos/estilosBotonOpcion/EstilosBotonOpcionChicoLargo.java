package edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EstilosBotonOpcionChicoLargo extends EstilosBotonOpcion {

    public EstilosBotonOpcionChicoLargo(Boton unBoton, Color color) {

        super(unBoton, color);

        boton.setFont(new Font("FreeSans", 55));
        boton.setPrefSize(650, 100);
    }
}