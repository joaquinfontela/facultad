package edu.fiuba.algo3.interfaz.layouts;

import edu.fiuba.algo3.interfaz.botones.BotonJugar;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class LayoutInicio {

    private StackPane layout;
    private final Image logo = new Image("file:src/imagenes/logo.png");

    public LayoutInicio() {

        layout = new StackPane();
        ImageView imageView = new ImageView();
        imageView.setImage(logo);
        imageView.setTranslateY(-90);
        imageView.setFitHeight(300);
        imageView.setFitWidth(1000);
        layout.setBackground(new Background(new BackgroundFill(Color.web("f17316"), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().add(imageView);
    }

    private void crearLayout() {

        BotonJugar boton = new BotonJugar();
        boton.setTranslateY(200);
        layout.getChildren().add(boton);
    }

    public StackPane getLayout() {

        this.crearLayout();
        return layout;
    }
}