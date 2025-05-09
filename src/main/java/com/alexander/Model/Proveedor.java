package com.alexander.Model;

public class Proveedor {
    private static Proveedor instance;
    private GestorPersonajes gp;
    private Tablero tab;
    private Protagonista p;

    private Proveedor() {
        this.gp = new GestorPersonajes();
        this.tab = new Tablero();
    }
    public static Proveedor getInstance() {
        if (instance == null) {
            instance = new Proveedor();
        }
        return instance;
    }
    public GestorPersonajes getGp() {
        return gp;
    }
    public void setGp(GestorPersonajes gp) {
        this.gp = gp;
    }
    public Tablero getTab() {
        return tab;
    }
    public void setTab(Tablero tab) {
        this.tab = tab;
    }
    public Protagonista getP() {
        return p;
    }
    public void setP(Protagonista p) {
        this.p = p;
    }
}
