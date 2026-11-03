
package com.mycompany.proyectofinal_f1;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Fachada {

    private static Fachada singleton;
    
    private Persistencia persistencia = new Persistencia();
    private ArrayList<Piloto> pilotos;
    private ArrayList<Auto> autos;
    private ArrayList<Escuderia> escuderias;
    private ArrayList<Circuito> circuitos;
    private ArrayList<GranPremio> grandesPremios;
    private ArrayList<Temporada> temporadas;
    private ArrayList<Resultado> resultados;
    private ArrayList<Motores> motores;
    private ArrayList<Indumentaria> indumentarias;

    private Fachada() {
        this.persistencia = persistencia;
        pilotos = new ArrayList<>();
        autos = new ArrayList<>();
        escuderias = new ArrayList<>();
        circuitos = new ArrayList<>();
        grandesPremios = new ArrayList<>();
        temporadas = new ArrayList<>();
        resultados = new ArrayList<>();
        motores = new ArrayList<>();
        indumentarias = new ArrayList<>();
    }

    

    public static Fachada getInstancia() {
        if (singleton == null) {
            singleton = new Fachada();
        }
        return singleton;
    }

    public void agregarPiloto(Piloto piloto) {
        pilotos.add(piloto);
    }

    public void agregarAuto(Auto auto) {
        autos.add(auto);
    }

    public void agregarEscuderia(Escuderia escuderia) {
        escuderias.add(escuderia);
    }

    public void agregarCircuito(Circuito circuito) {
        circuitos.add(circuito);
    }

    public void agregarGranPremio(GranPremio granPremio) {
        grandesPremios.add(granPremio);
    }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    public void agregarResultado(Resultado resultado) {
        resultados.add(resultado);
    }

    public void agregarMotor(Motores motor) {
        motores.add(motor);
    }

    public void agregarIndumentaria(Indumentaria indumentaria) {
        indumentarias.add(indumentaria);
    }

    public ArrayList<Piloto> getPilotos() {
        return pilotos;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public ArrayList<Escuderia> getEscuderias() {
        return escuderias;
    }

    public ArrayList<Circuito> getCircuitos() {
        return circuitos;
    }

    public ArrayList<GranPremio> getGrandesPremios() {
        return grandesPremios;
    }

    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    public ArrayList<Resultado> getResultados() {
        return resultados;
    }

    public ArrayList<Motores> getMotores() {
        return motores;
    }

    public ArrayList<Indumentaria> getIndumentarias() {
        return indumentarias;
    }
    
    public boolean registrarUsuario(String usuario, String contrasena) {
    return Persistencia.registrarUsuario(usuario, contrasena);
    }

    public boolean validarLogin(String usuario, String contrasena) {
    return Persistencia.validarLogin(usuario, contrasena);
    }
    
    public DefaultTableModel obtenerAutos (){
        return persistencia.obtenerAutos();
    }
    
    public DefaultTableModel obtenerPilotos (){
        return persistencia.obtenerPilotos();
    }
    
    public DefaultTableModel obtenerCircuito (){
        return persistencia.obtenerCircuito();
    }
    
    public DefaultTableModel obtenerEscuderia (){
        return persistencia.obtenerEscuderia();
    }
    
    public DefaultTableModel obtenerGranPremio (){
        return persistencia.obtenerGranPremio();
    }
    
    public DefaultTableModel obtenerIndumentaria (){
        return persistencia.obtenerIndumentaria();
    }
    
    public DefaultTableModel obtenerMotores (){
        return persistencia.obtenerMotores();
    }
    
    public DefaultTableModel obtenerProveedores (){
        return persistencia.obtenerProveedores();
    }
    
    public DefaultTableModel obtenerResultados (){
        return persistencia.obtenerResultados();
    }
    
    public DefaultTableModel obtenerTemporada (){
        return persistencia.obtenerTemporada();
    }
    
    public boolean insertarRegistro(String tabla, Object[] valores) {
        return persistencia.insertarRegistro(tabla, valores);
    }

    public boolean modificarRegistro(String tabla,
                                     Object[] claves,
                                     Object[] valores) {
        return persistencia.modificarRegistro(tabla, claves, valores);
    }

    public boolean eliminarRegistro(String tabla, Object[] claves) {
        return persistencia.eliminarRegistro(tabla, claves);
    }
}
