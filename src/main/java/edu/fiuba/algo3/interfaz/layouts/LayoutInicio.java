package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonCambiarPantallaHandler;
import edu.fiuba.algo3.interfaz.botones.BotonJugar;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LayoutInicio extends StackPane {

    public LayoutInicio(Stage stage, Scene proximaEscena) {

        Image logo = new Image("file:src/imagenes/logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(logo);
        imageView.setTranslateY(-90);
        imageView.setFitHeight(300);
        imageView.setFitWidth(1000);

        this.setBackground(new Background(new BackgroundFill(Color.web("f17316"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().add(imageView);

        BotonJugar boton = new BotonJugar();
        boton.setTranslateY(200);
        boton.setOnAction(new BotonCambiarPantallaHandler(stage, proximaEscena));

        this.getChildren().add(boton);
    }
}