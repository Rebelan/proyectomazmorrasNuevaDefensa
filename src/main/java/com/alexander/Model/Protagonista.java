package com.alexander.Model;

public class Protagonista extends Personaje {
    private String nombreProta;

    public Protagonista(int velocidad, int vitalidad, int fuerza, String nombreProta) {
        super(velocidad, vitalidad, fuerza);
        this.nombreProta = nombreProta;
    }

    public String getNombreProta() {
        return this.nombreProta;
    }

    public void setNombreProta(String nombreProta) {
        this.nombreProta = nombreProta;
    }

    @Override
    public String toString() {
        return "{" +
                " nombreProta='" + getNombreProta() + "'" +
                super.toString();
    }
    @Override
    public void moverse(int NuevaX, int NuevaY){
        this.setCordX(NuevaX);
        this.setCordY(NuevaY);
        
    }
    
}
