
package com.mycompany.proyectofinal_f1;

import java.util.ArrayList;

public class Escuderia {

    private int identificador;
    private String nombre;
    private ArrayList<Auto> autos;

    public Escuderia(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.autos = new ArrayList<>();
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public void asignarAuto(Auto auto) {
        if (auto != null) {
            autos.add(auto);
        }
    }
}
