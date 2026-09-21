package com.mycompany.proyectofinal_f1;
import java.util.ArrayList;
public class Temporada {
    private int ano;
    private ArrayList<GranPremio> granP;

    public Temporada(int ano, ArrayList<GranPremio> granP) {
        this.ano = ano;
        this.granP = granP;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public void asignarGranP(GranPremio e){
        this.granP.add(e);
    }
}
