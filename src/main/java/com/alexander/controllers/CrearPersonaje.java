package com.alexander.controllers;




import com.alexander.SceneID;
import com.alexander.SceneManager;

import com.alexander.Model.Protagonista;
import com.alexander.Model.Proveedor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CrearPersonaje {

    @FXML
    VBox vbox1;

    @FXML
    Label L1;

    @FXML
    GridPane Stats;

    @FXML
    Label id_nombre;

    @FXML
    Label id_velocidad;

    @FXML
    Label id_Vitalidad;

    @FXML
    Label id_fuerza;

    @FXML
    TextField textNombre;

    @FXML
    TextField textVelocidad;

    @FXML
    TextField textVitalidad;

    @FXML
    TextField textFuerza;

    @FXML
    Button comenzar;

    Protagonista prota;

    public void initialize() {
        comenzar.setOnAction(event -> {
            String nombre = textNombre.getText();
            int velocidad = Integer.parseInt(textVelocidad.getText());
            int vitalidad = Integer.parseInt(textVitalidad.getText());
            int fuerza = Integer.parseInt(textFuerza.getText());

            prota = new Protagonista(velocidad, vitalidad, fuerza, nombre);
            Proveedor.getInstance().setP(prota);
            Proveedor.getInstance().getGp().insertarPersonaje(prota);
            SceneManager.getInstance().loadScene(SceneID.Segunda);
            
        });
    }
   
}
