package com.mycompany.proyectofinal_f1;
import java.util.ArrayList;
import java.util.Date;
public class Piloto {
    private String codigo;
    private String nombre;
    private String nacionalidad;
    private Date fechaNac;
    private ArrayList<Auto> autos;
    
    public Piloto(String codigo, String nombre, String nacionalidad, Date fechaNac) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNac = fechaNac;
    }

    public Piloto(ArrayList<Auto> autos) {
        this.autos = autos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void asignarAuto(Auto e){
        this.autos.add(e);
    } 
}
