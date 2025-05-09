package com.alexander.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.alexander.App;

public class LecturaEnemigos {
    
    public static ArrayList<Personaje> leerEnemigos(){
        ArrayList<Personaje> enemigos = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(App.class.getResource("data/enemigos.csv").toURI())), StandardCharsets.UTF_8))){
            String linea= br.readLine();
            while ((linea = br.readLine())!=null) {
                String[] atributos = linea.split(",");
                try{
                    enemigos.add(new Enemigo(Integer.parseInt(atributos[0]), Integer.parseInt(atributos[1]), Integer.parseInt(atributos[2]), Integer.parseInt(atributos[3]), atributos[4]));
                }catch (NumberFormatException e) {
                    System.out.println("Error al convertir los atributos"); 
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        } catch(URISyntaxException e){
            e.printStackTrace();
        }
        return enemigos;
    }
}
