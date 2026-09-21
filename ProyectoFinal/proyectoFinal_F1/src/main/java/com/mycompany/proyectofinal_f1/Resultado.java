package com.mycompany.proyectofinal_f1;

public class Resultado {

    private int resultado;
    private Piloto piloto;
    private Auto auto;
    private GranPremio granPremio;

    public Resultado(int resultado, Piloto piloto, Auto auto, GranPremio granPremio) {
        this.resultado = resultado;
        this.piloto = piloto;
        this.auto = auto;
        this.granPremio = granPremio;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public Auto getAuto() {
        return auto;
    }

    public GranPremio getGranPremio() {
        return granPremio;
    }
}