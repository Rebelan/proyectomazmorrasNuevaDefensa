package com.alexander.Model;

import java.util.ArrayList;

import com.alexander.Interfaces.Observer;

public class Proveedor {
    private static Proveedor instance;
    private GestorPersonajes gp;
    private Tablero tab;
    private Protagonista p;
    ArrayList<Observer> observers;

    private Proveedor() {
        // Crear y asignar el protagonista con valores predeterminados
        this.p = new Protagonista(10, 100, 15, "Héroe");
        this.gp = new GestorPersonajes(p);
        this.tab = new Tablero();
        gp.setProta(p);
        tab.LecturaInicioTablero(gp);
        observers = new ArrayList<>();
    }

    /**
     * Método para suscribir un observador.
     * 
     * @param observer Observador a suscribir.
     */
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    /**
     * Método para eliminar un observador.
     * 
     * @param observer Observador a eliminar.
     */
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Método para notificar a los observadores.
     */
    public void notifyObservers() {
        observers.forEach(item -> item.onChange());
    }

    public static Proveedor getInstance() {
        if (instance == null) {
            instance = new Proveedor();
        }
        return instance;
    }
    public GestorPersonajes getGp() {
        return gp;
    }
    public void setGp(GestorPersonajes gp) {
        this.gp = gp;
    }
    public Tablero getTab() {
        return tab;
    }
    public void setTab(Tablero tab) {
        this.tab = tab;
    }
    public Protagonista getP() {
        return p;
    }
    public void setP(Protagonista p) {
        this.p = p;
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
        notifyObservers();
  }
    
}
