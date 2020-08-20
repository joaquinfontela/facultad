package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.botones.tipoBoton.TipoBoton;
import edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion.EstilosBotonOpcionGrande;
import javafx.scene.paint.Color;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class BotonOpcionGrande extends BotonOpcion {

    public BotonOpcionGrande(String enunciado, double posX, double posY, Color color, Class claseTipoBoton, ArrayList<BotonOpcion> botones) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        super(enunciado, posX, posY, (TipoBoton) claseTipoBoton.getConstructor().newInstance(), botones);
        this.setSkin(new EstilosBotonOpcionGrande(this, color, tipo));
    }
}