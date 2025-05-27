package com.alexander.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alexander.Interfaces.Observer;

public class GestorPersonajes {
    private Protagonista prota;
    ArrayList<Personaje> personajes;
    ArrayList<Observer> observers;

    /**
     * Suscribe un observer.
     * 
     * @param observer Observer a suscribir.
     */
    public void subscribe(Observer observer) {
        observers.add(observer);
    }
    /**
     * Elimina un observer.
     * @param observer Observer a eliminar.
     */
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(item -> item.onChange());
    }
    /**
     * Constructor de GestorPersonajes.
     * @param prota Protagonista principal.
     */
    public GestorPersonajes(Protagonista prota) {
        this.personajes = LecturaEnemigos.leerEnemigos();
        this.prota = prota;
        this.observers = new ArrayList<>();

        // Suscribir enemigos al protagonista
        for (Personaje personaje : personajes) {
            if (personaje instanceof Enemigo) {
                prota.subscribe((Observer) personaje);
            }
        }
    }
    /**
     * Método para insertar un personaje en el gestor.
     * 
     * @param e Personaje a insertar.
     */
    public void insertarPersonaje(Personaje e) {
        this.personajes.add(e);
        notifyObservers();
    }
    /**
     * Método para eliminar un personaje del gestor.
     * 
     * @param e Personaje a eliminar
     */
    public void eliminarEnemigo(Personaje e) {
        this.personajes.remove(e);
        notifyObservers();
    }
    /**
     * Método para obtener el personaje por su nombre.
     * 
     * @param nombre Nombre del personaje a buscar.
     * @return Personaje encontrado o null si no se encuentra.
     */
    public List<Personaje> getNombrePersonaje() {
        return this.personajes;
    }
    /**
     * Método para obtener el protagonista.
     * 
     * @return Protagonista.
     */
    public Protagonista getProta() {
        return prota;
    }

    // Método para inicializar el protagonista
    /**
     * Método para establecer el protagonista.
     * 
     * @param prota Protagonista a establecer.
     */
    public void setProta(Protagonista prota) {
        this.prota = prota;
        // Suscribir todos los enemigos al protagonista
        for (Personaje personaje : this.personajes) {
            if (personaje instanceof Enemigo) {
                prota.subscribe((Observer) personaje);
            }
        }
    }
    /**
     * Método para obtener un enemigo aleatorio.
     * 
     * @return Enemigo aleatorio.
     */
    public Enemigo getEnemigo() {
        Random random = new Random();
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
    /**
     * Método para obtener la lista de personajes.
     * 
     * @return Lista de personajes.
     */
    public void ordenarPersonajes() {
        // ordenamos el arraylist de personajes por velocidad
        // de mayor a menor
        personajes.sort(null);
    }

}
