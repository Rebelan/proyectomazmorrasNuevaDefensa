package com.alexander.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import com.alexander.App;

public class Tablero {
    private Casilla[][] tablero;

    public void LecturaInicioTablero(){
        String[] columnas;
        int filas = 0;
         try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(App.class.getResource("data/tablero.DARKEST").toURI())), StandardCharsets.UTF_8))){
            String linea;
            while ((linea = br.readLine()) != null) {
                columnas = linea.split(" ");
                for (int i = 0; i < columnas.length; i++) {
                    switch (Integer.parseInt(columnas[i])) {
                        case 0:
                            tablero[filas][i] = new Casilla(TipoCasilla.Suelo, null);
                            break;
                        case 1:
                            tablero[filas][i] = new Casilla(TipoCasilla.Pared, null);
                            break;
                        case 2:
                            tablero[filas][i] = new Casilla(TipoCasilla.Suelo, null);
                            break;
                        case 3:
                            tablero[filas][i] = new Casilla(TipoCasilla.Suelo, null);
                            break; 
                        default:
                        System.out.println("Error en el formato del tablero");
                            break;
                    }
                }
               filas++;
                
            }
            
            
         } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
