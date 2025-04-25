package com.alexander.Model;

public class Personaje {
    private int velocidad;
    private int vitalidad;
    private int fuerza;

    public Personaje(int velocidad, int vitalidad, int fuerza) {
        this.velocidad = velocidad;
        this.vitalidad = vitalidad;
        this.fuerza = fuerza;
    }


    public int getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVitalidad() {
        return this.vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }


    @Override
    public String toString() {
        return "{" +
            " velocidad='" + getVelocidad() + "'" +
            ", vitalidad='" + getVitalidad() + "'" +
            ", fuerza='" + getFuerza() + "'" +
            "}";
    }


}

