package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.layouts.*;
import edu.fiuba.algo3.modelo.LectorDeArchivo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App cC
 */
public class AppModel extends Application {

    LayoutPregunta layoutPregunta;
    LayoutPuntajesParciales layoutPuntajesParciales;
    LayoutPuntajeFinal layoutPuntajeFinal;
    LayoutPreturno layoutPreturno;
    LayoutInicio layoutInicio;
    LayoutRegistro layoutRegistro;
    Scene scene;

    @Override
    public void start(Stage stage) {

        //System.out.println(javafx.scene.text.Font.getFamilies());

        //mostrarLayoutPregunta();
        //mostrarLayoutPuntajesParciales();
        //mostrarLayoutPuntajeFinal();
        //mostrarLayoutInicio(stage);
        //mostrarLayoutPreturno();
        //mostrarLayoutRegistro();

        layoutPregunta = new LayoutPregunta(7, 10);

        layoutPregunta.agregarEnunciadoDeLaPregunta("Que seleccion es la mas ganadora de la historia de los mundiales? (seleccionar mas de una en caso de ser necesario)");

        layoutPregunta.agregarOpcion("Italia");
        layoutPregunta.agregarOpcion("Brasil");
        layoutPregunta.agregarOpcion("Argentina");
        layoutPregunta.agregarOpcion("Alemania");

        layoutRegistro = new LayoutRegistro(stage, new Scene(layoutPregunta.getLayout(), 640, 480));
        layoutInicio = new LayoutInicio(stage, new Scene(layoutRegistro, 640, 480));
        scene = new Scene(layoutInicio, 640, 480);

        mostrarStage(stage);
    }

    private void mostrarStage(Stage stage) {

        stage.setTitle("Algohoot!");
        stage.setScene(scene);
        stage.setHeight(720);
        stage.setWidth(1200);
        stage.show();
    }

    private void mostrarLayoutPregunta() {

        layoutPregunta = new LayoutPregunta(7, 10);

        layoutPregunta.agregarEnunciadoDeLaPregunta("Que seleccion es la mas ganadora de la historia de los mundiales? (seleccionar mas de una en caso de ser necesario)");

        layoutPregunta.agregarOpcion("Italia");
        layoutPregunta.agregarOpcion("Brasil");
        layoutPregunta.agregarOpcion("Argentina");
        layoutPregunta.agregarOpcion("Alemania");
        //layoutPregunta.agregarOpcion("Holanda");
        //layoutPregunta.agregarOpcion("Uruguay");

        scene = new Scene(layoutPregunta.getLayout(), 640, 480);
    }

    private void mostrarLayoutPuntajesParciales() {

        layoutPuntajesParciales = new LayoutPuntajesParciales();
        layoutPuntajesParciales.agregarPuntaje("Miguel", 3);
        layoutPuntajesParciales.agregarPuntaje("Tomás", 1);

        scene = new Scene(layoutPuntajesParciales, 640, 480);
    }

    private void mostrarLayoutPuntajeFinal() {

        layoutPuntajeFinal = new LayoutPuntajeFinal();
        layoutPuntajeFinal.agregarJugadorGanador("Tomás", 14);
        layoutPuntajeFinal.agregarJugadorPerdedor("Miguel", 11);

        scene = new Scene(layoutPuntajeFinal.getLayout(), 640, 480);
    }
    /*
    public void mostrarLayoutInicio(Stage stage) {

        layoutRegistro = new LayoutRegistro();
        layoutInicio = new LayoutInicio(stage, new Scene(layoutRegistro, 640, 480));
        scene = new Scene(layoutInicio, 640, 480);
    }*/

    private void mostrarLayoutPreturno() {

        layoutPreturno = new LayoutPreturno("miguelito123");
        scene = new Scene(layoutPreturno, 640, 480);
    }
    /*
    private void mostrarLayoutRegistro() {

        layoutRegistro = new LayoutRegistro();
        scene = new Scene(layoutRegistro, 640, 480);
    }*/

    public static void main(String[] args) {
        launch();
    }
}