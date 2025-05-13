package com.alexander.controllers;

import java.io.IOException;
import java.security.Provider;
import java.util.List;

import com.alexander.App;
import com.alexander.Interfaces.Observer;
import com.alexander.Model.Personaje;
import com.alexander.Model.GestorPersonajes;
import com.alexander.Model.Proveedor;
import com.alexander.Model.Tablero;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Dungeon implements Observer {
    
    @FXML
    Label Ltab;

    @FXML
    GridPane gridTablero;

    GestorPersonajes gp;

    @FXML
    public void initialize() {
        gp = Proveedor.getInstance().getGp();
        gp.subscribe(this);

        gridTablero = new GridPane();
        gridTablero.setPadding(new Insets(10, 50, 10, 50));

        Proveedor.getInstance().getTab().LecturaInicioTablero(gp);

        ColumnConstraints col = new ColumnConstraints();
        col.setHgrow(Priority.ALWAYS);
        col.setHalignment(HPos.LEFT);
        gridTablero.getColumnConstraints().add(col);

    }

    public void generarLista(List<Personaje> personajes) {
        gridTablero.getChildren().clear();
        int row = 0;

        for (Personaje pj : personajes) {
            gridTablero.add(gridTablero, 0, row);

            row++;
        }

    }

    @Override
    public void onChange() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onChange'");
    }

}