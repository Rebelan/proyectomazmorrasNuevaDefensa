package com.alexander.Model;

public class Proveedor {
    private static Proveedor instance;
    private GestorPersonajes gp;
    private Tablero tab;
    private Protagonista p;
    private Enemigo e;

    private Proveedor() {
        // Crear y asignar el protagonista con valores predeterminados
        this.p = new Protagonista(10, 100, 15, "Héroe");
        this.gp = new GestorPersonajes(p);
        this.tab = new Tablero();
        gp.setProta(p);
        tab.LecturaInicioTablero(gp);
        // Crear y asignar un enemigo con valores predeterminados
        this.e = new Enemigo(5, 50, 10, 3, "Enemigo Inicial");
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
    public Enemigo getE() {
        return e;
    }
    public void setE(Enemigo e) {
        this.e = e;
    }
    
}
