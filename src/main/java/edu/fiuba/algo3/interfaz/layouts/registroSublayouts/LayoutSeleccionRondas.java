package edu.fiuba.algo3.interfaz.layouts.registroSublayouts;

import edu.fiuba.algo3.controladores.CheckboxRondaHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class LayoutSeleccionRondas extends StackPane {

    private CantidadRondasCheckbox cincoRondasCheckbox;
    private CantidadRondasCheckbox diezRondasCheckbox;
    private CantidadRondasCheckbox quinceRondasCheckbox;
    private ListaDeCheckboxes listaDeCheckboxes;

    public LayoutSeleccionRondas() {

        this.agregarTituloRondas();
        this.agregarRondasBox();
    }

    private void agregarTituloRondas() {

        Label tituloRondas = new Label("RONDAS");
        tituloRondas.setFont(new Font("KacstPoster", 55));
        tituloRondas.setTranslateX(-380.0);
        tituloRondas.setTranslateY(50.0);
        tituloRondas.setStyle("-fx-text-fill: black");
        this.getChildren().add(tituloRondas);
    }

    private void agregarRondasBox() {

        listaDeCheckboxes = new ListaDeCheckboxes();

        cincoRondasCheckbox = new CantidadRondasCheckbox("5");
        cincoRondasCheckbox.setTranslateX(-400.0);
        cincoRondasCheckbox.setTranslateY(150.0);
        cincoRondasCheckbox.setSelected(true);
        cincoRondasCheckbox.setOnAction(new CheckboxRondaHandler(cincoRondasCheckbox));
        listaDeCheckboxes.add(cincoRondasCheckbox);
        this.getChildren().add(cincoRondasCheckbox);

        diezRondasCheckbox = new CantidadRondasCheckbox("10");
        diezRondasCheckbox.setTranslateY(150.0);
        diezRondasCheckbox.setOnAction(new CheckboxRondaHandler(diezRondasCheckbox));
        listaDeCheckboxes.add(diezRondasCheckbox);
        this.getChildren().add(diezRondasCheckbox);

        quinceRondasCheckbox = new CantidadRondasCheckbox("15");
        quinceRondasCheckbox.setTranslateX(400.0);
        quinceRondasCheckbox.setTranslateY(150.0);
        quinceRondasCheckbox.setOnAction(new CheckboxRondaHandler(quinceRondasCheckbox));
        listaDeCheckboxes.add(quinceRondasCheckbox);
        this.getChildren().add(quinceRondasCheckbox);
    }

    public int obtenerCantidadRondas() {

        Integer cantidadRondas = 5;
        for (CheckBox c : listaDeCheckboxes) {
            if (c.isSelected()){
                cantidadRondas = Integer.parseInt(c.getText());
            }
        }
        return cantidadRondas;

    }
}