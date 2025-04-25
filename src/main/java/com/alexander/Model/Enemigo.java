package com.alexander.Model;

public class Enemigo extends Personaje {
    private String nombreEnemigo;

    public Enemigo(int velocidad, int vitalidad, int fuerza, String nombreEnemigo) {
        super(velocidad, vitalidad, fuerza);
        this.nombreEnemigo = nombreEnemigo;
    }

    public String getNombreEnemigo() {
        return this.nombreEnemigo;
    }

    public void setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    @Override
    public String toString() {
        return "{" +
                " nombreEnemigo='" + getNombreEnemigo() + "'" +
                super.toString();
    }

}
