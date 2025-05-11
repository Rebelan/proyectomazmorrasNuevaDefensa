package com.alexander.Model;

import java.util.ArrayList;
import java.util.Random;

import com.alexander.Interfaces.Observer;

public class Enemigo extends Personaje {
    private String nombreEnemigo;
    private int percepcion;
    ArrayList<Observer> observers;

    public Enemigo(int velocidad, int vitalidad, int fuerza, int percepcion, String nombreEnemigo) {
        super(velocidad, vitalidad, fuerza);
        this.nombreEnemigo = nombreEnemigo;
        this.percepcion = percepcion;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(item -> item.onChange());
    }

    public String getNombreEnemigo() {
        return this.nombreEnemigo;
    }

    public void setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    public int getPercepcion() {
        return this.percepcion;
    }

    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }

    @Override
    public String toString() {
        return "{" +
                " nombreEnemigo='" + getNombreEnemigo() + "'" +
                super.toString() +
                ", percepcion='" + getPercepcion() + "'";
    }

    @Override
    public void moverse() {
        Random r = new Random();
        Proveedor p = Proveedor.getInstance();
        Tablero tab = p.getTab();
        Protagonista prota = p.getP();
        Enemigo enemigo = p.getE();
        boolean seguir = true;
        if (enemigo.CalculoAlgoritmo(enemigo.getCordX(), enemigo.getCordY(), prota.getCordX(),
                prota.getCordY()) <= enemigo.getPercepcion()) {

        } else {
            int opRandom = r.nextInt(4);
            switch (opRandom) {
                case 0:
                    if (tab.EstaCasillaEstaVacia(enemigo.getCordX() - 1, enemigo.getCordY())
                            && tab.getTipoCasilla(enemigo.getCordX() - 1, enemigo.getCordY()) == TipoCasilla.Suelo) {
                        enemigo.setCordX(enemigo.getCordX() - 1);
                        enemigo.notifyObservers();
                        tab.actualizarCasilla(enemigo, enemigo.getCordX(), enemigo.getCordY());
                    }
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;

                default:
                    break;
            }
        }

    }

    public float CalculoAlgoritmo(int x1, int y1, int x2, int y2) {
        // Calcular la distancia entre los dos puntos
        float distancia = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distancia;
    }

}
