package com.alexander.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FinDelJuegoDerrota {
    @FXML
    VBox vbox1;

    @FXML
    Label LDerrota;

    @FXML
    Button botonCerrar2;

    public void initialize() {
        botonCerrar2.setOnAction(event -> {
            System.exit(0); // Cierra la aplicación
            System.out.println("Juego cerrado.");
        });
    }

    
}
