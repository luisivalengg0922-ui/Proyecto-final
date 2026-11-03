
package com.mycompany.proyectofinal_f1;

import java.util.ArrayList;
import java.util.Date;

public class Piloto {

    private String codigo;
    private String nombre;
    private String nacionalidad;
    private Date fechaNac;
    private ArrayList<Auto> autos;

    public Piloto(String codigo, String nombre,
            String nacionalidad, Date fechaNac) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNac = fechaNac;
        this.autos = new ArrayList<>();
    }

    public Piloto(ArrayList<Auto> autos) {
        this.autos = (autos != null)
                ? new ArrayList<>(autos)
                : new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public void asignarAuto(Auto auto) {
        if (auto != null) {
            autos.add(auto);
        }
    }

    public void eliminarAuto(Auto auto) {
        autos.remove(auto);
    }

}
