package edu.fiuba.algo3.interfaz.rondasYjugadores;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.EstilosBoton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class EstiloBotonRonda extends EstilosBoton {

    public EstiloBotonRonda(Boton unManejadorDeBoton, String cantidadDeRondas) {
        super(unManejadorDeBoton);
        unManejadorDeBoton.setBackground(new Background(new BackgroundFill(Color.MEDIUMVIOLETRED, CornerRadii.EMPTY, Insets.EMPTY)));
        unManejadorDeBoton.setPrefSize(150, 75);
        unManejadorDeBoton.setText(cantidadDeRondas);
        unManejadorDeBoton.setWrapText(true);
    }
}
