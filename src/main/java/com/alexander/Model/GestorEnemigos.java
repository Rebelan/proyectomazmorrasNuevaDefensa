package com.alexander.Model;

import java.util.ArrayList;
import java.util.List;

import com.alexander.Interfaces.Observer;

public class GestorEnemigos {
    ArrayList<Enemigo> enemigos;
    ArrayList<Observer> observers;

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        observers.forEach(item -> item.onChange());
    }

    public GestorEnemigos(){
        this.enemigos = LectorEnemigos.leerEnemigos();
        observers = new ArrayList<>();
    }

    public void insertarEnemigo(Enemigo e){
        this.enemigos.add(e);
        notifyObservers();
    }

    public void eliminarEnemigo(Enemigo e){
        this.enemigos.remove(e);
        notifyObservers();
    }

    public List<Enemigo> getNombreEnemigo(){
        return this.enemigos;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Enemigo enemigo : enemigos) {
            sb.append(enemigo + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GestorEnemigos ge = new GestorEnemigos();
        System.out.println(ge.toString());
    }

}
