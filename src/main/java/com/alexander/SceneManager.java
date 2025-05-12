package com.alexander;

import java.io.IOException;
import java.util.HashMap;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SceneManager {
    private static SceneManager instance;

    private Stage stage; 
    private HashMap<SceneID, Scene> scenes; 

    private SceneManager() {
        scenes = new HashMap<>();
    }

    
    public static SceneManager getInstance(){
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }
   
    @SuppressWarnings("exports")
    public void init(Stage stage){
        this.stage = stage;
    }

    public void setScene(SceneID sceneID, String fxml){
        
        Screen screen = Screen.getPrimary();

        
        double screenWidth = screen.getBounds().getWidth();
        double screenHeight = screen.getBounds().getHeight();
        try {
            
            URL url = App.class.getResource("views/" + fxml + ".fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, screenWidth*0.7, screenHeight*0.7);
            scenes.put(sceneID, scene); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    public void removeScene(SceneID sceneID){
        scenes.remove(sceneID); 
    }

    public void loadScene(SceneID sceneID) {
        if (scenes.containsKey(sceneID)){
            stage.setScene(scenes.get(sceneID)); 
            stage.show(); 
        } else {
            System.err.println("La escena seleccionada no existe");
        }
    }

    @SuppressWarnings("exports")
    public Scene getScene(SceneID sceneID){
        if (scenes.containsKey(sceneID)){
            return scenes.get(sceneID);
        } else {
            System.err.println("La escena seleccionada no existe");
            return null;
        }
    }
}
