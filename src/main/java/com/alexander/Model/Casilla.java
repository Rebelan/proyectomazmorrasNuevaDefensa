package com.alexander.Model;

public class Casilla {
    private TipoCasilla tipo;
    private Personaje personaje;

    public Casilla(TipoCasilla tipo, Personaje personaje){
        this.tipo = tipo;
        this.personaje = personaje;
    }

    public TipoCasilla getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoCasilla tipo) {
        this.tipo = tipo;
    }

    public Personaje getPersonaje() {
        return this.personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

}
