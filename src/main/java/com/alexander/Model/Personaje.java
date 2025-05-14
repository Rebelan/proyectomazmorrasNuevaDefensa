package com.alexander.Model;



public class Personaje {
    private int velocidad;
    protected int vitalidad;
    private int fuerza;
    private int cordX;
    private int cordY;

    /**
     * Constructor de Personaje.
     * 
     * @param velocidad Velocidad del personaje.
     * @param vitalidad Vitalidad del personaje.
     * @param fuerza    Fuerza del personaje.
     */
    public Personaje(int velocidad, int vitalidad, int fuerza) {
        this.velocidad = velocidad;
        this.vitalidad = vitalidad;
        this.fuerza = fuerza;
    }

    /**
     * Obtiene la velocidad del personaje.
     * @return Velocidad.
     */
    public int getVelocidad() {
        return this.velocidad;
    }
    /**
     * Establece la velocidad del personaje.
     * @param velocidad Velocidad a establecer.
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    /**
     * Obtiene la vitalidad del personaje.
     * @return Vitalidad.
     */
    public int getVitalidad() {
        return this.vitalidad;
    }
    /**
     * Establece la vitalidad del personaje.
     * @param vitalidad Vitalidad a establecer.
     */
    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }
    /**
     * Obtiene la fuerza del personaje.
     * @return Fuerza.
     */
    public int getFuerza() {
        return this.fuerza;
    }
    /**
     * Establece la fuerza del personaje.
     * @param fuerza Fuerza a establecer.
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    /**
     * Obtiene la coordenada X del personaje.
     * @return Coordenada X.
     */
    public int getCordX() {
        return this.cordX;
    }
    /**
     * Establece la coordenada X del personaje.
     * @param cordX Coordenada X a establecer.
     */
    public void setCordX(int cordX) {
        this.cordX = cordX;
    }
    /**
     * Obtiene la coordenada Y del personaje.
     * @return Coordenada Y.
     */
    public int getCordY() {
        return this.cordY;
    }
    /**
     * Establece la coordenada Y del personaje.
     * @param cordY Coordenada Y a establecer.
     */
    public void setCordY(int cordY) {
        this.cordY = cordY;
    }
    /**
     * Método para recibir un golpe.
     * @param dmg Daño recibido.
     * @return true si el personaje muere, false en caso contrario.
     */
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
    /**
     * Método para mover el personaje.
     */
    public void moverse(){
      
    }

}

