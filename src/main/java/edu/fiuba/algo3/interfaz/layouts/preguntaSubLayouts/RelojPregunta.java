package edu.fiuba.algo3.interfaz.layouts.preguntaSubLayouts;

import edu.fiuba.algo3.interfaz.layouts.LayoutSeAcaboElTiempo;
import edu.fiuba.algo3.modelo.GestorDeJuego;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class RelojPregunta extends StackPane {

    private Label contadorTiempoRestante;
    private Integer tiempoRestante;
    private Timer timer;

    public RelojPregunta(Stage stage, GestorDeJuego gestor) {

        tiempoRestante = 30;

        Circle forma = new Circle();
        forma.setRadius(1.0);
        this.setShape(forma);

        this.setMinSize(100, 90);
        this.setMaxSize(100, 90);
        this.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setStyle("-fx-border-color: gold");

        agregarContadorTiempoRestante(stage, gestor);
    }

    private void agregarContadorTiempoRestante(Stage stage, GestorDeJuego gestor) {

        contadorTiempoRestante = new Label();
        contadorTiempoRestante.setText(tiempoRestante.toString());
        contadorTiempoRestante.setTextFill(Color.GOLD);
        contadorTiempoRestante.setFont(new Font("KacstPoster", 40));
        this.getChildren().add(contadorTiempoRestante);

        agregarAnimacionContador(stage, gestor);
    }

    private void agregarAnimacionContador(Stage stage, GestorDeJuego gestor) {

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (tiempoRestante > 1) {
                            disminuirContador();
                        } else {
                            LayoutSeAcaboElTiempo layout = new LayoutSeAcaboElTiempo(stage, gestor);
                            stage.setScene(new Scene(layout,640, 480));
                            detenerTemporizador();
                        }
                    }
                });
            }
        }, 100, 100);
    }

    private void disminuirContador(){

        tiempoRestante--;
        contadorTiempoRestante.setText(tiempoRestante.toString());
    }

    public void detenerTemporizador() {
        timer.cancel();
    }
}