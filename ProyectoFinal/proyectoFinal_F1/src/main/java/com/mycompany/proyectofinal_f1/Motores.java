package com.mycompany.proyectofinal_f1;
public class Motores extends Proveedores {
    private int numChasis;

    public Motores(int identificador, String nombre) {
        super(identificador, nombre);
        this.numChasis = numChasis;
    }

    public int getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(int numChasis) {
        this.numChasis = numChasis;
    }
    
}
