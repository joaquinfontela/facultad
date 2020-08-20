package edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EstilosBotonOpcionChicoLargo extends EstilosBotonOpcion {

    public EstilosBotonOpcionChicoLargo(Boton unBoton, Color color, TipoBoton tipoBoton) {

        super(unBoton, color, tipoBoton);
        boton.setFont(new Font("FreeSans", 25));
        boton.setPrefSize(490, 90);
    }
}