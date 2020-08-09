package edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EstilosBotonOpcionGrande extends EstilosBotonOpcion {

    public EstilosBotonOpcionGrande(Boton manejadorDeBoton, Color color) {

        super(manejadorDeBoton, color);

        boton.setFont(new Font("FreeSans", 55));
        boton.setPrefSize(400, 225);
    }
}
