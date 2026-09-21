package com.mycompany.proyectofinal_f1;
import java.util.Date;
public class Auto {
    private Date anoFabri;
    private int identificador;
    private String modelo;
    
    public Auto(Date anoFabri, int identificador, String modelo) {
        this.anoFabri = anoFabri;
        this.identificador = identificador;
        this.modelo = modelo;
    }

    public Date getAnoFabri() {
        return anoFabri;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getModelo() {
        return modelo;
    }
    
}
