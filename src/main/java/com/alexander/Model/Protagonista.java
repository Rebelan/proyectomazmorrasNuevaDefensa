package com.alexander.Model;

import java.util.ArrayList;

import com.alexander.Interfaces.Observer;

public class Protagonista extends Personaje {
    private String nombreProta;
    TipoMov direccion;
    ArrayList<Observer> observers;

    public Protagonista(int velocidad, int vitalidad, int fuerza, String nombreProta) {
        super(velocidad, vitalidad, fuerza);
        this.nombreProta = nombreProta;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(item -> item.onChange());
    }

    public String getNombreProta() {
        return this.nombreProta;
    }

    public void setNombreProta(String nombreProta) {
        this.nombreProta = nombreProta;
    }

    public TipoMov getDireccion() {
        return this.direccion;
    }

    public void setDireccion(TipoMov direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "{" +
                " nombreProta='" + getNombreProta() + "'" +
                super.toString();
    }

    @Override
    public void moverse() {
        Proveedor p = Proveedor.getInstance();
        int nuevaX=p.getP().getCordX();
        int nuevaY=p.getP().getCordY();
        switch (direccion) {
            case ARRIBA:
                nuevaX = p.getP().getCordX() - 1;
                break;
            case ABAJO:
                nuevaX = p.getP().getCordX() + 1;
                break;
            case IZQUIERDA:
                nuevaY = p.getP().getCordY() - 1;
                break;
            case DERECHA:
                nuevaY = p.getP().getCordY() + 1;
                break;
            default:
                break;
        }
        if (p.getTab().EstaCasillaEstaVacia(nuevaX, nuevaY)&& p.getTab().getTipoCasilla(nuevaX, nuevaY)== TipoCasilla.Suelo) {
            p.getTab().actualizarCasilla(p.getP(), nuevaX, nuevaY);
            notifyObservers();
        }
    }
}
