package edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EstilosBotonOpcionGrande extends EstilosBotonOpcion {

    public EstilosBotonOpcionGrande(Boton unBoton, Color color) {

        super(unBoton, color);

        boton.setFont(new Font("FreeSans", 50));
        boton.setPrefSize(390, 180);
    }
}