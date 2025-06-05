package com.alexander.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FinDelJuegoVictoria {
    @FXML
    VBox vbox1;

    @FXML
    Label LVictoria;
    
    @FXML
    Button botonCerrar1;

    public void initialize() {
        botonCerrar1.setOnAction(event -> {
            System.exit(0); // Cierra la aplicación
            System.out.println("Juego cerrado.");
        });
    }

    
}
