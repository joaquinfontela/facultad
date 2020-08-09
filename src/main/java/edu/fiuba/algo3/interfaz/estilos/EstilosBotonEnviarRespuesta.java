package edu.fiuba.algo3.interfaz.estilos;

import edu.fiuba.algo3.interfaz.botones.Boton;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class EstilosBotonEnviarRespuesta extends EstilosBoton {

    public EstilosBotonEnviarRespuesta(Boton manejadorDeBoton) {
        super(manejadorDeBoton);

        boton.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        boton.setPrefSize(150, 75);

        boton.setOnMouseClicked(e -> {
            System.out.println("RESPUESTA ENVIADA!");
        });

        Tic formaBoton = new Tic();
        boton.setShape(formaBoton);
    }
}
