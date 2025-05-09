package com.alexander.Model;

public class LogicaJuego {
    private GestorPersonajes gp;
    private Tablero tablero;

    public LogicaJuego(GestorPersonajes gp, Tablero tablero) {
        this.gp = gp;
        this.tablero = tablero;
    }

    public void MoverProtagonista() {
        // Lógica para mover al protagonista

    }

    public boolean atacar(Personaje objetivo, Personaje atacante) {
        double dmg = 0;
        try {
            dmg = objetivo.getVitalidad() - atacante.getFuerza() * 0.1;

            System.out.println("El daño del ataque es: " + dmg);
        } catch (ArithmeticException e) {
            System.out.println("Excepción aritmética. Objetivo con vida 0");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Excepción genérica");
            e.printStackTrace();
        }

        return objetivo.recibirGolpe(dmg);
    }

    public boolean recibirGolpe(Personaje objetivo, Personaje atacante, int dmg) {
        objetivo.vitalidad = objetivo.vitalidad - atacante.getFuerza();
        if (objetivo.vitalidad <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
