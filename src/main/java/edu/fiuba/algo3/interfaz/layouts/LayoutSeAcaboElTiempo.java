package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonSeAcaboElTiempoHandler;
import edu.fiuba.algo3.interfaz.botones.BotonJugar;
import edu.fiuba.algo3.interfaz.botones.BotonSeAcaboElTiempo;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LayoutSeAcaboElTiempo extends StackPane {

    public LayoutSeAcaboElTiempo(Stage stage, GestorDeJuego gestor) {

        Label label = new Label("Se acabo el tiempo");
        label.setFont(new Font("KacstPoster", 100));
        label.setTextFill(Color.BLACK);
        label.setTranslateY(-250);
        this.getChildren().add(label);

        Image imagen = new Image("file:src/imagenes/seAcaboElTiempo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setTranslateY(0);
        imageView.setFitHeight(300);
        imageView.setFitWidth(350);
        this.getChildren().add(imageView);

        this.setBackground(new Background(new BackgroundFill(Color.web("#d9162c"), CornerRadii.EMPTY, Insets.EMPTY)));

        BotonSeAcaboElTiempo boton = new BotonSeAcaboElTiempo();
        boton.setTranslateY(250);
        boton.setOnAction(new BotonSeAcaboElTiempoHandler(stage, gestor));

        this.getChildren().add(boton);
    }
}