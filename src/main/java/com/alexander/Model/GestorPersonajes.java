package com.alexander.Model;

import java.util.ArrayList;
import java.util.List;

import com.alexander.Interfaces.Observer;

public class GestorPersonajes {
    ArrayList<Personaje> personajes;
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

<<<<<<< HEAD
    public CargarPersonajes(){
=======
    public GestorPersonajes(){
>>>>>>> 263ab297eb86f9b576ad1f2370ef8d42664a8de1
        this.personajes = LecturaEnemigos.leerEnemigos();
        observers = new ArrayList<>();
    }

    public void insertarEnemigo(Enemigo e){
<<<<<<< HEAD
        this.personaje.add(e);
=======
        this.personajes.add(e);
>>>>>>> 263ab297eb86f9b576ad1f2370ef8d42664a8de1
        notifyObservers();
    }

    public void eliminarEnemigo(Enemigo e){
        this.personajes.remove(e);
        notifyObservers();
    }

    public List<Personaje> getNombreEnemigo(){
        return this.personajes;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Personaje personaje : personajes) {
            sb.append(personaje + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GestorPersonajes gp = new GestorPersonajes();
        System.out.println(gp.toString());
    }

}
