package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.util.Timer;
import java.util.TimerTask;

public class RelojPregunta {

    private StackPane contador;
    private Label contadorTiempoRestante;
    private Integer tiempoRestante;

    public RelojPregunta() {

        contador = new StackPane();
        tiempoRestante = 30;

        Circle forma = new Circle();
        forma.setRadius(1.0);
        contador.setShape(forma);

        contador.setMinSize(120, 120);
        contador.setMaxSize(120, 120);
        contador.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
        contador.setStyle("-fx-border-color: gold");

        agregarContadorTiempoRestante();
    }

    private void agregarContadorTiempoRestante() {

        contadorTiempoRestante = new Label();
        contadorTiempoRestante.setText(tiempoRestante.toString());
        contadorTiempoRestante.setTextFill(Color.GOLD);
        contadorTiempoRestante.setFont(new Font("KacstPoster", 40));
        contador.getChildren().add(contadorTiempoRestante);

        agregarAnimacionContador();
    }

    private void agregarAnimacionContador() {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (tiempoRestante > 0 ) disminuirContador();
                    }
                });
            }
        }, 1000, 1000);
    }

    private void disminuirContador(){

        tiempoRestante--;
        contadorTiempoRestante.setText(tiempoRestante.toString());
    }

    public StackPane getContador() {
        return contador;
    }
}