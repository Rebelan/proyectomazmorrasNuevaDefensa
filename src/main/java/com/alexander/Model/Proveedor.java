package com.alexander.Model;

public class Proveedor {
    private static Proveedor instance;
    private GestorPersonajes gp;
    private Tablero tab;
    private Protagonista p;

    private Proveedor() {
        // Crear y asignar el protagonista con valores predeterminados
        this.p = new Protagonista(10, 100, 15, "Héroe");
        this.gp = new GestorPersonajes(p);
        this.tab = new Tablero();
        gp.setProta(p);
        tab.LecturaInicioTablero(gp);
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

    /**
     * Mueve los personajes en el tablero.
     */
    public void MoverPersonajes() {
        gp.ordenarPersonajes();
        for (int i = 0; i < gp.getNombrePersonaje().size(); i++) {
            Personaje p = gp.getNombrePersonaje().get(i);
            p.moverse();
    }
  }
    
}
