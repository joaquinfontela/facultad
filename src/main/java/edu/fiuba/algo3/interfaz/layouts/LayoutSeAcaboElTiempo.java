package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonSeAcaboElTiempoHandler;
import edu.fiuba.algo3.interfaz.botones.BotonJugar;
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
import javafx.stage.Stage;

public class LayoutSeAcaboElTiempo extends StackPane {

    public LayoutSeAcaboElTiempo(Stage stage, GestorDeJuego gestor) {

        Label label = new Label("Se acabo el tiempo");
        label.setPrefSize(500,300);
        this.getChildren().add(label);

        /*Image logo = new Image("file:src/imagenes/logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(logo);
        imageView.setTranslateY(-90);
        imageView.setFitHeight(300);
        imageView.setFitWidth(1000);
        this.getChildren().add(imageView);*/

        this.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        BotonJugar boton = new BotonJugar();
        boton.setTranslateY(200);
        boton.setOnAction(new BotonSeAcaboElTiempoHandler(stage, gestor));

        this.getChildren().add(boton);

    }
}