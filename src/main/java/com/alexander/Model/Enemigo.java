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
        float Calculo1 = enemigo.CalculoAlgoritmo(enemigo.getCordX(), enemigo.getCordY(), prota.getCordX(),
                prota.getCordY());
        int nuevaX = enemigo.getCordX();
        int nuevaY = enemigo.getCordY();
        if (Calculo1 <= enemigo.getPercepcion()) {
            if (tab.getTipoCasilla(enemigo.getCordX() - 1, enemigo.getCordY()) != TipoCasilla.Pared) {
                if (Calculo1 < enemigo.CalculoAlgoritmo(enemigo.getCordX() - 1, enemigo.getCordY(), prota.getCordX(),
                        prota.getCordY())) {
                    Calculo1 = enemigo.CalculoAlgoritmo(enemigo.getCordX() - 1, enemigo.getCordY(), prota.getCordX(),
                            prota.getCordY());
                            nuevaX = enemigo.getCordX() - 1;
                            nuevaY = enemigo.getCordY();
                }
            }
            if (tab.getTipoCasilla(enemigo.getCordX() + 1, enemigo.getCordY()) != TipoCasilla.Pared) {
                if (Calculo1 < enemigo.CalculoAlgoritmo(enemigo.getCordX() + 1, enemigo.getCordY(), prota.getCordX(),
                        prota.getCordY())) {
                    Calculo1 = enemigo.CalculoAlgoritmo(enemigo.getCordX() + 1, enemigo.getCordY(), prota.getCordX(),
                            prota.getCordY());
                    nuevaX = enemigo.getCordX() + 1;
                    nuevaY = enemigo.getCordY();
                }
            }
            if (tab.getTipoCasilla(enemigo.getCordX(), enemigo.getCordY() - 1) != TipoCasilla.Pared) {
                if (Calculo1 < enemigo.CalculoAlgoritmo(enemigo.getCordX(), enemigo.getCordY() - 1, prota.getCordX(),
                        prota.getCordY())) {
                    Calculo1 = enemigo.CalculoAlgoritmo(enemigo.getCordX(), enemigo.getCordY() - 1, prota.getCordX(),
                            prota.getCordY());
                    nuevaX = enemigo.getCordX();
                    nuevaY = enemigo.getCordY() - 1;
                }
            }
            if (tab.getTipoCasilla(enemigo.getCordX(), enemigo.getCordY() + 1) != TipoCasilla.Pared) {
                if (Calculo1 < enemigo.CalculoAlgoritmo(enemigo.getCordX(), enemigo.getCordY() + 1, prota.getCordX(),
                        prota.getCordY())) {
                    Calculo1 = enemigo.CalculoAlgoritmo(enemigo.getCordX(), enemigo.getCordY() + 1, prota.getCordX(),
                            prota.getCordY());
                    nuevaX = enemigo.getCordX();
                    nuevaY = enemigo.getCordY() + 1;
                }
            }
            if (tab.EstaCasillaEstaVacia(nuevaX, nuevaY)
                    && tab.getTipoCasilla(nuevaX, nuevaY) == TipoCasilla.Suelo) {
                tab.actualizarCasilla(null, enemigo.getCordX(), enemigo.getCordY());
                enemigo.setCordX(nuevaX);
                enemigo.setCordY(nuevaY);
                tab.actualizarCasilla(enemigo, nuevaX, nuevaY);
                seguir = false;
                enemigo.notifyObservers();
            }

        } else {
            
            while (seguir) {
                int opRandom = r.nextInt(4);
                switch (opRandom) {
                    case 0: // Arriba:
                        nuevaX = nuevaX - 1;
                        break;
                    case 1:// Abajo:
                        nuevaX = nuevaX + 1;
                        break;
                    case 2:// Izquierda:
                        nuevaY = nuevaY - 1;
                        break;
                    case 3:// Derecha
                        nuevaY = nuevaY + 1;
                        break;

                    default:
                        break;
                }
                if (tab.EstaCasillaEstaVacia(nuevaX, nuevaY)
                        && tab.getTipoCasilla(nuevaX, nuevaY) == TipoCasilla.Suelo) {
                    tab.actualizarCasilla(null, enemigo.getCordX(), enemigo.getCordY());
                    enemigo.setCordX(nuevaX);
                    enemigo.setCordY(nuevaY);
                    tab.actualizarCasilla(enemigo, nuevaX, nuevaY);
                    seguir = false;
                    enemigo.notifyObservers();
                    
                }

            }
        }

    }

    public float CalculoAlgoritmo(int x1, int y1, int x2, int y2) {
        // Calcular la distancia entre los dos puntos
        float distancia = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distancia;
    }

}
