package edu.fiuba.algo3.interfaz.layouts.registroSublayouts;

import edu.fiuba.algo3.interfaz.botones.BotonComenzar;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class LayoutSeleccionRondas {

    private StackPane layout;
    private CantidadRondasCheckbox cincoRondasCheckbox;
    private CantidadRondasCheckbox diezRondasCheckbox;
    private CantidadRondasCheckbox quinceRondasCheckbox;
    private ListaDeCheckboxes listaDeCheckboxes;

    public LayoutSeleccionRondas() {

        layout = new StackPane();

        agregarTituloRondas();
        agregarRondasBox();
    }

    private void agregarTituloRondas() {

        Label tituloRondas = new Label("RONDAS");
        tituloRondas.setFont(new Font("KacstPoster", 55));
        tituloRondas.setTranslateX(-380.0);
        tituloRondas.setTranslateY(50.0);
        tituloRondas.setStyle("-fx-text-fill: black");
        layout.getChildren().add(tituloRondas);
    }

    private void agregarRondasBox() {

        listaDeCheckboxes = new ListaDeCheckboxes();

        cincoRondasCheckbox = new CantidadRondasCheckbox("5");
        cincoRondasCheckbox.setTranslateX(-400.0);
        cincoRondasCheckbox.setTranslateY(150.0);
        listaDeCheckboxes.add(cincoRondasCheckbox);
        layout.getChildren().add(cincoRondasCheckbox);

        diezRondasCheckbox = new CantidadRondasCheckbox("10");
        diezRondasCheckbox.setTranslateY(150.0);
        listaDeCheckboxes.add(diezRondasCheckbox);
        layout.getChildren().add(diezRondasCheckbox);

        quinceRondasCheckbox = new CantidadRondasCheckbox("15");
        quinceRondasCheckbox.setTranslateX(400.0);
        quinceRondasCheckbox.setTranslateY(150.0);
        listaDeCheckboxes.add(quinceRondasCheckbox);
        layout.getChildren().add(quinceRondasCheckbox);
    }

    public StackPane getLayout() {

        return layout;
    }
}
