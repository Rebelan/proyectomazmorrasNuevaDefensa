package com.alexander;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Clase principal de la aplicación JavaFX.
 * Inicia la ventana principal y gestiona las escenas.
 * 
 * @author Abel Constantino Muñoz y Alexander Plantón Jarmolowicz
 * @version 1.0
 */
public class App extends Application {

    /**
     * Método de inicio de JavaFX.
     * Inicializa el gestor de escenas y carga la escena principal.
     *
     * @param stage Ventana principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar las escenas.
     */
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("La Mazmorra - Juego de Rol");

        SceneManager sm = SceneManager.getInstance();
        sm.init(stage);

        sm.setScene(SceneID.Primera, "primary");
        sm.setScene(SceneID.Segunda, "secondary");
        sm.setScene(SceneID.finJuegoVictoria, "finJuegoVictoria");
        sm.setScene(SceneID.finJuegoDerrota, "finJuegoDerrota");

        sm.loadScene(SceneID.Primera);
    }

    /**
     * Método principal. Lanza la aplicación JavaFX.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}