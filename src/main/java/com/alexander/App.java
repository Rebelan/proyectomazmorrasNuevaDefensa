package com.alexander;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException{
        stage.setTitle("La Mazmorra - Juego de Rol");

        SceneManager sm = SceneManager.getInstance();

        sm.init(stage);

        sm.setScene(SceneID.Primera, "CrearPersonaje");
        sm.setScene(SceneID.Segunda, "Dungeon");

        sm.loadScene(SceneID.Primera);
    }

    public static void main(String[] args) {
        launch();
    }

}