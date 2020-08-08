package edu.fiuba.algo3.interfaz.botones.botonesOpcion;

import edu.fiuba.algo3.interfaz.estilos.estilosBotonOpcion.EstilosBotonOpcionGrande;
import javafx.scene.paint.Color;

public class BotonOpcionGrande extends BotonOpcion {

    public BotonOpcionGrande(String enunciado, double posX, double posY, Color color) {

        super(enunciado, posX, posY, color);
        boton.setSkin(new EstilosBotonOpcionGrande(boton, color));
    }
}
