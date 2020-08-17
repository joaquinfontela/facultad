package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion.EstilosBotonOpcionChicoLargo;
import javafx.scene.paint.Color;

import java.lang.reflect.InvocationTargetException;

public class BotonOpcionChicoLargo extends BotonOpcion {

    public BotonOpcionChicoLargo(String enunciado, double posX, double posY, Color color, Class claseTipoBoton) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        super(enunciado, posX, posY, (TipoBoton) claseTipoBoton.getConstructor().newInstance());
        this.setSkin(new EstilosBotonOpcionChicoLargo(this, color, tipo));
    }
}