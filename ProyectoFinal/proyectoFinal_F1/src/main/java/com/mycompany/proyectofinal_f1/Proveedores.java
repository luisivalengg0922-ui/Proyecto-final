package com.mycompany.proyectofinal_f1;
public class Proveedores {
    private int identificador;
    private String nombre;


    public Proveedores(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;

    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }
    
}
