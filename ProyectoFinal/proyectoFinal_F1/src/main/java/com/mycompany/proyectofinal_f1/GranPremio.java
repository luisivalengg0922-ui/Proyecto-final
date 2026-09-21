package com.mycompany.proyectofinal_f1;
import java.util.ArrayList;
import java.util.Date;
public class GranPremio {
    private Date fecha;
    private int identificador;
    private String nombre;
    private ArrayList<Circuito> circuitos;

    public GranPremio(Date fecha, int identificador, String nombre) {
        this.fecha = fecha;
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public GranPremio() {
        this.circuitos = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void asignarCircuito(Circuito e){
        this.circuitos.add(e);
    }

    ArrayList<Circuito> getArray() {
    return this.circuitos;
    }
}
