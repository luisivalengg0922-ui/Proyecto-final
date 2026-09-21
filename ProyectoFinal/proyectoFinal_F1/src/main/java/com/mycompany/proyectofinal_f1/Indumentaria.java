package com.mycompany.proyectofinal_f1;
public class Indumentaria extends Proveedores {
    private String nombreInd;
    
    public Indumentaria(int identificador, String nombre) {
        super(identificador, nombre);
        this.nombreInd = nombreInd;
    }

    public String getNombreInd() {
        return nombreInd;
    }

    public void setNombreInd(String nombreInd) {
        this.nombreInd = nombreInd;
    }
    
    
}
