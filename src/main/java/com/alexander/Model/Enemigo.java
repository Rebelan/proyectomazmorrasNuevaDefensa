package com.alexander.Model;

public class Enemigo extends Personaje {
    private String nombreEnemigo;
    private int percepcion;

    public Enemigo(int velocidad, int vitalidad, int fuerza, int percepcion, String nombreEnemigo) {
        super(velocidad, vitalidad, fuerza);
        this.nombreEnemigo = nombreEnemigo;
        this.percepcion = percepcion;
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
    public void moverse(int newX, int newY){
        
       
    }

}
