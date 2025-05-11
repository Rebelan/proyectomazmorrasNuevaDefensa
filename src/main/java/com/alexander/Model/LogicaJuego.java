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

    public boolean atacar(Personaje objetivo, Personaje atacante, double dmg) {
        try {
            dmg = objetivo.getVitalidad() - atacante.getFuerza() * 0.1;

        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objetivo.recibirGolpe(dmg);
    }

    public boolean recibirGolpe(Personaje objetivo, Personaje atacante) {
        objetivo.vitalidad = objetivo.vitalidad - atacante.getFuerza();
        if (objetivo.vitalidad <= 0) {
            return true;
        } else {
            return false;
        }
    }


    public void MoverPersonajes() {
        gp.ordenarPersonajes();
        for (int i = 0; i < gp.getNombrePersonaje().size(); i++) {
            Personaje p = gp.getNombrePersonaje().get(i);
            p.moverse();
    }
  }
}
