
package com.mycompany.proyectofinal_f1;

public class Resultado {

    private int posicion;
    private int vueltasCompletadas;
    private double tiempo;
    private int puntos;

    private Piloto piloto;
    private Auto auto;
    private GranPremio granPremio;

    public Resultado(int posicion, int vueltasCompletadas,
            double tiempoPorVuelta, int puntos,
            Piloto piloto, Auto auto, GranPremio granPremio) {

        this.posicion = posicion;
        this.vueltasCompletadas = vueltasCompletadas;
        this.tiempo = tiempo;
        this.puntos = puntos;
        this.piloto = piloto;
        this.auto = auto;
        this.granPremio = granPremio;
    }

    public Resultado(int resultado, Piloto piloto,
            Auto auto, GranPremio granPremio) {

        this(resultado, 0, 0, 0, piloto, auto, granPremio);
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getVueltasCompletadas() {
        return vueltasCompletadas;
    }

    public void setVueltasCompletadas(int vueltasCompletadas) {
        this.vueltasCompletadas = vueltasCompletadas;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
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
