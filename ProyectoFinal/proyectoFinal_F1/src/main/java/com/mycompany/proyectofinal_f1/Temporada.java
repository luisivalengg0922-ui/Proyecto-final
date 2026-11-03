
package com.mycompany.proyectofinal_f1;

import java.util.ArrayList;

public class Temporada {

    private int ano;
    private ArrayList<GranPremio> granP;

    public Temporada(int ano, ArrayList<GranPremio> granP) {
        this.ano = ano;

        if (granP != null) {
            this.granP = new ArrayList<>(granP);
        } else {
            this.granP = new ArrayList<>();
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public ArrayList<GranPremio> getGranP() {
        return granP;
    }

    public void asignarGranP(GranPremio granPremio) {
        if (granPremio != null) {
            granP.add(granPremio);
        }
    }
}
