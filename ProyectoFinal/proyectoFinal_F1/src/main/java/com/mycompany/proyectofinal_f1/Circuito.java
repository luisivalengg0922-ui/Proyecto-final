package com.mycompany.proyectofinal_f1;

import java.util.ArrayList;

public class Circuito {
    private String pais;
    private String nombre;
    private double longitud;
    private int identificador;
    private int cantVuel;

    public Circuito(String pais, String nombre, double longitud, int identificador, int cantVuel) {
        this.pais = pais;
        this.nombre = nombre;
        this.longitud = longitud;
        this.identificador = identificador;
        this.cantVuel = cantVuel;
    }

    public String getPais() {
        return pais;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLongitud() {
        return longitud;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getCantVuel() {
        return cantVuel;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setCantVuel(int cantVuel) {
        this.cantVuel = cantVuel;
    }

}
