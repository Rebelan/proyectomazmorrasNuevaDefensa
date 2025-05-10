package com.alexander.Model;


import java.util.Scanner;

public class LogicaJuego {
    private GestorPersonajes gp;
    private Tablero tab;

    public static Scanner sc = new Scanner(System.in);

    public LogicaJuego(GestorPersonajes gp, Tablero tablero) {
        this.gp = gp;
        this.tab = tablero;
    }

    public void MoverPersonajes() {
        gp.ordenarPersonajes();
        for (int i = 0; i < gp.getNombrePersonaje().size(); i++) {
            Personaje p = gp.getNombrePersonaje().get(i);
            p.moverse();
    }
  }
}
