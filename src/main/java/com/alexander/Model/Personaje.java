package com.alexander.Model;



public class Personaje {
    private int velocidad;
    protected int vitalidad;
    private int fuerza;
    private int cordX;
    private int cordY;

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

    public int getCordX() {
        return this.cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return this.cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }

    public boolean recibirGolpe(double dmg) {
        return false;
    }

    @Override
    public String toString() {
        return "{" +
            " velocidad='" + getVelocidad() + "'" +
            ", vitalidad='" + getVitalidad() + "'" +
            ", fuerza='" + getFuerza() + "'" +
            "}";
    }
    public void moverse(){
      
    }

}

