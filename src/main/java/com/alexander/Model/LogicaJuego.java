package com.alexander.Model;


import java.util.Scanner;

public class LogicaJuego {
    private GestorPersonajes gp;
    private Tablero tab;

    public static Scanner sc = new Scanner(System.in);
    /**
    * Constructor de LogicaJuego.
    * @param gp Gestor de personajes.
    * @param tablero Tablero del juego.
    */
    public LogicaJuego(GestorPersonajes gp, Tablero tablero) {
        this.gp = gp;
        this.tab = tablero;
    }
    /**
     * Realiza un ataque de un personaje a otro.
     * @param objetivo Personaje objetivo.
     * @param atacante Personaje atacante.
     * @param dmg Daño a infligir.
     * @return true si el objetivo muere, false en caso contrario.
     */
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
    /**
     * Realiza un ataque de un personaje a otro.
     * @param objetivo Personaje objetivo.
     * @param atacante Personaje atacante.
     * @return true si el objetivo muere, false en caso contrario.
     */
    public boolean recibirGolpe(Personaje objetivo, Personaje atacante) {
        objetivo.vitalidad = objetivo.vitalidad - atacante.getFuerza();
        if (objetivo.vitalidad <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mueve los personajes en el tablero.
     */
    public void MoverPersonajes() {
        gp.ordenarPersonajes();
        for (int i = 0; i < gp.getNombrePersonaje().size(); i++) {
            Personaje p = gp.getNombrePersonaje().get(i);
            p.moverse();
    }
  }
}
