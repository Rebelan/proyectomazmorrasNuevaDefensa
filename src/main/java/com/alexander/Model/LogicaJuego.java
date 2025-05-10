package com.alexander.Model;

import java.lang.reflect.Array;
import java.util.Scanner;

public class LogicaJuego {
    private GestorPersonajes gp;
    private Tablero tablero;

    public static Scanner sc = new Scanner(System.in);

    public LogicaJuego(GestorPersonajes gp, Tablero tablero) {
        this.gp = gp;
        this.tablero = tablero;
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

    public void MoverPersonajes(GestorPersonajes gp, Tablero tab) {
        gp.ordenarPersonajes();
        String op;
        boolean seguir = true;
        for (int i = 0; i < gp.getNombrePersonaje().size(); i++) {
            Personaje p = gp.getNombrePersonaje().get(i);
            if (p instanceof Protagonista) {
                Protagonista e = (Protagonista) p;
                while (seguir) {
                    System.out.println("A donde te quieres mover ?\n" +
                            "1. W = Arriba\n" +
                            "2. S = Abajo\n" +
                            "3. A = Izquierda\n" +
                            "4. D = Derecha");
                    op = sc.nextLine();
                    switch (op) {
                        case "W":
                            int nuevaX = p.getCordX() - 1;
                            int nuevaY = p.getCordY();
                            if (tab.getTipoCasilla(nuevaX, nuevaY) == TipoCasilla.Suelo
                                    && tab.EstaCasillaEstaVacia(nuevaX, nuevaY)) {
                                p.moverse(nuevaX, nuevaY);
                                seguir = false;
                                tab.actualizarCasilla(p, nuevaX, nuevaY);
                            }
                            break;
                        case "S":
                            nuevaX = p.getCordX() + 1;
                            nuevaY = p.getCordY();
                            if (tab.getTipoCasilla(nuevaX, nuevaY) == TipoCasilla.Suelo
                                    && tab.EstaCasillaEstaVacia(nuevaX, nuevaY)) {
                                p.moverse(nuevaX, nuevaY);
                                seguir = false;
                                tab.actualizarCasilla(p, nuevaX, nuevaY);
                            }
                            break;
                        case "A":
                            nuevaX = p.getCordX();
                            nuevaY = p.getCordY() - 1;
                            if (tab.getTipoCasilla(nuevaX, nuevaY) == TipoCasilla.Suelo
                                    && tab.EstaCasillaEstaVacia(nuevaX, nuevaY)) {
                                p.moverse(nuevaX, nuevaY);
                                seguir = false;
                                tab.actualizarCasilla(p, nuevaX, nuevaY);
                            }
                            break;
                        case "D":
                            nuevaX = p.getCordX();
                            nuevaY = p.getCordY() + 1;
                            if (tab.getTipoCasilla(nuevaX, nuevaY) == TipoCasilla.Suelo
                                    && tab.EstaCasillaEstaVacia(nuevaX, nuevaY)) {
                                p.moverse(nuevaX, nuevaY);
                                seguir = false;
                                tab.actualizarCasilla(p, nuevaX, nuevaY);
                            }
                            break;
                        default:
                            System.out.println("Error, introduce una opcion valida");
                            break;
                    }
                }
            }
        }
    }
}
