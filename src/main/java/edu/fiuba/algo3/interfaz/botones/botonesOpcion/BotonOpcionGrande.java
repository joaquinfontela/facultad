package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion.EstilosBotonOpcionGrande;
import javafx.scene.paint.Color;

import java.lang.reflect.InvocationTargetException;

public class BotonOpcionGrande extends BotonOpcion {

    public BotonOpcionGrande(String enunciado, double posX, double posY, Color color, Class claseTipoBoton) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        super(enunciado, posX, posY, (TipoBoton) claseTipoBoton.getConstructor().newInstance());
        this.setSkin(new EstilosBotonOpcionGrande(this, color, tipo));
    }
}