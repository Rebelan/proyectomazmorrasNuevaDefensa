package com.alexander.controllers;


import com.alexander.App;
import com.alexander.Interfaces.Observer;
import com.alexander.Model.Personaje;
import com.alexander.Model.GestorPersonajes;
import com.alexander.Model.Proveedor;
import com.alexander.Model.Tablero;
import com.alexander.Model.TipoCasilla;

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
        generarMapa();
    }

    public void generarMapa() {
        Tablero tablero = new Tablero();
        tablero.LecturaInicioTablero(gp);
        tablero.getTablero();

        gridTablero.getChildren().clear();

        Image camino = new Image(getClass().getResourceAsStream("data/SpriteCamino.jpg"));
        Image muro = new Image(getClass().getResourceAsStream("data/SpriteMuro.png"));
        ImageView iViewCamino = new ImageView(camino);
        ImageView iViewMuro = new ImageView(muro);

        for (int fila = 0; fila < tablero.getNFilas(); fila++) {
            for (int col = 0; col < tablero.getNColumnas(); col++) {
                if(tablero.getTipoCasilla(fila, col)==TipoCasilla.Pared) {
                    gridTablero.add(iViewMuro, col, fila);
                } else {
                    gridTablero.add(iViewCamino, col, fila);
                }
            }
        }

    }

    @Override
    public void onChange() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onChange'");
    }

}