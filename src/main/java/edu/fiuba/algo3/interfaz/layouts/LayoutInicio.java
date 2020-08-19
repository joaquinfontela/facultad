package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.controladores.BotonInicioHandler;
import edu.fiuba.algo3.interfaz.botones.botonesComunes.BotonInicio;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LayoutInicio extends StackPane {

    public LayoutInicio(Stage stage) {

        Image logo = new Image("file:src/imagenes/logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(logo);
        imageView.setTranslateY(-90);
        imageView.setFitHeight(300);
        imageView.setFitWidth(1000);

        this.setBackground(new Background(new BackgroundFill(Color.web("f17316"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().add(imageView);

        BotonInicio boton = new BotonInicio();
        boton.setTranslateY(200);
        boton.setOnAction(new BotonInicioHandler(stage));

        this.getChildren().add(boton);
    }
}