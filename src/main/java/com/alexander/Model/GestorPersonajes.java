package com.alexander.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alexander.Interfaces.Observer;

public class GestorPersonajes implements Comparable<GestorPersonajes> {
    Protagonista prota;
    ArrayList<Personaje> personajes;
    ArrayList<Observer> observers;

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(item -> item.onChange());
    }

    public GestorPersonajes() {
        this.personajes = LecturaEnemigos.leerEnemigos();
        observers = new ArrayList<>();
    }

    public void insertarPersonaje(Personaje e) {
        this.personajes.add(e);
        notifyObservers();
    }

    public void eliminarEnemigo(Personaje e) {
        this.personajes.remove(e);
        notifyObservers();
    }

    public List<Personaje> getNombrePersonaje() {
        return this.personajes;
    }

    public Protagonista getProta() {
        return prota;
    }
    public Enemigo getEnemigo() {
        Random  random = new Random();
        return (Enemigo) personajes.get(random.nextInt(personajes.size()));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Personaje personaje : personajes) {
            sb.append(personaje + "\n");
        }
        return sb.toString();
    }
    public void ordenarPersonajes() {
        // ordenamos el arraylist de personajes por velocidad
        // de mayor a menor
        personajes.sort(null);
    }

    @Override
    public int compareTo(GestorPersonajes o) {
        // comparamos velocidad de los personajes para ordenar el arraylist de mayor a menor
        if (this.prota.getVelocidad() > o.prota.getVelocidad()) {
            return -1;
        } else if (this.prota.getVelocidad() < o.prota.getVelocidad()) {
            return 1;
        } else {
            return 0;
        }
    }
    

}
