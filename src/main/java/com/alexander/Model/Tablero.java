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

    public Casilla[][] LecturaInicioTablero(GestorPersonajes gp) {
        String[] columnas;
        int filas = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(App.class.getResource("data/tablero.DARKEST").toURI())),
                StandardCharsets.UTF_8))) {
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
                            tablero[filas][i] = new Casilla(TipoCasilla.Suelo, gp.getProta());
                            gp.getProta().setCordX(i);
                            gp.getProta().setCordY(filas);
                            break;
                        case 3:
                            tablero[filas][i] = new Casilla(TipoCasilla.Suelo, gp.getEnemigo());
                            gp.getEnemigo().setCordX(i);
                            gp.getEnemigo().setCordY(filas);
                            break;
                        default:
                        
                            break;
                    }
                }
                filas++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e1) {
          
            e1.printStackTrace();
        }
        return tablero;
    }

    public void actualizarCasilla(Personaje pj, int x, int y) {
        // Actualiza la casilla del personaje en el tablero
        if (tablero[x][y].getTipo() == TipoCasilla.Suelo && tablero[x][y].getPersonaje() == null) {
            tablero[pj.getCordX()][pj.getCordY()].setPersonaje(null);
            tablero[x][y].setPersonaje(pj);
            pj.setCordX(x);
            pj.setCordY(y);
        }

    }

    public TipoCasilla getTipoCasilla(int x, int y) {
        return tablero[x][y].getTipo();
    }

    public boolean EstaCasillaEstaVacia(int x, int y) {
        return tablero[x][y].getPersonaje() == null;

    }

    public int getNFilas(){
        return tablero.length;
    }

    public int getNColumnas() {
        return tablero[0].length;
    }

    public Casilla[][] getTablero() {
        return tablero;
    }
}
