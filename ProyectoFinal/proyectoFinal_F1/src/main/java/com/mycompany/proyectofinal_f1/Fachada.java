package com.mycompany.proyectofinal_f1;

import java.util.ArrayList;

public class Fachada {
    private static Fachada singleton;
    private GranPremio GranP;
    private Fachada(){
        GranPremio GranP = new GranPremio();
    }
    public static Fachada getInstancia(){
        if(singleton==null){
            singleton=new Fachada();
        }
        return singleton;
}
    public ArrayList<Circuito> getArray(){
       return GranP.getArray();
}
    
}