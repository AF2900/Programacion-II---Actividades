package co.edu.uniquindio.pr2.cafeteria.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.pr2.cafeteria.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class CafeteriaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btCalcular;

    @FXML
    private ComboBox<String> cbMetodoPreparacion;

    @FXML
    private CheckBox chAzucar;

    @FXML
    private CheckBox chCanela;

    @FXML
    private CheckBox chLeche;

    @FXML
    private CheckBox chWhiisky;

    @FXML
    private RadioButton rdEspecial;

    @FXML
    private RadioButton rdPasilla;

    @FXML
    private Label lbCosto;

    @FXML
    private Label lbIngredientes;

    private String metodoSeleccionado = "";

    @FXML
    void onCalcular(ActionEvent event) {
        Cafe cafe = new CafeSimple();
        if (rdEspecial.isSelected()) {
            cafe = new Especial(cafe);
        } else if (rdPasilla.isSelected()) {
            cafe = new Pasilla(cafe);
        }

        if (chLeche.isSelected()) cafe = new Leche(cafe);
        if (chAzucar.isSelected()) cafe = new Azucar(cafe);
        if (chCanela.isSelected()) cafe = new Canela(cafe);
        if (chWhiisky.isSelected()) cafe = new Whisky(cafe);

        double costoFinal = cafe.getCosto();
        String descripcionFinal = cafe.getDescripcion();

        switch (metodoSeleccionado) {
            case "Espresso":
                costoFinal += 500;
                descripcionFinal += ", Espresso";
                break;
            case "Americano":
                costoFinal += 1000;
                descripcionFinal += ", Americano";
                break;
            case "Capuchino":
                costoFinal += 2000;
                descripcionFinal += ", Capuchino";
                break;
        }

        lbCosto.setText("Costo: $" + costoFinal);
        lbIngredientes.setText("Ingredientes: " + descripcionFinal);
    }

    @FXML
    void onMetodoPreparacion(ActionEvent event) {
        metodoSeleccionado = cbMetodoPreparacion.getValue();
    }

    @FXML
    void initialize() {
        assert btCalcular != null : "fx:id=\"btCalcular\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert cbMetodoPreparacion != null : "fx:id=\"cbMetodoPreparacion\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert chAzucar != null : "fx:id=\"chAzucar\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert chCanela != null : "fx:id=\"chCanela\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert chLeche != null : "fx:id=\"chLeche\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert chWhiisky != null : "fx:id=\"chWhiisky\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert rdEspecial != null : "fx:id=\"rdEspecial\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert rdPasilla != null : "fx:id=\"rdPasilla\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert lbCosto != null : "fx:id=\"lbCosto\" was not injected: check your FXML file 'cafeteria.fxml'.";
        assert lbIngredientes != null : "fx:id=\"lbIngredientes\" was not injected: check your FXML file 'cafeteria.fxml'.";

        ObservableList<String> metodos = FXCollections.observableArrayList(
                "Espresso", "Americano", "Capuchino"
        );
        cbMetodoPreparacion.setItems(metodos);
    }
}