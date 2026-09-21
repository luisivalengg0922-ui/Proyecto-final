package com.mycompany.proyectofinal_f1;
import Visual.Login;
import com.formdev.flatlaf.FlatDarkLaf;
public class ProyectoFinal_F1 {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        NuevaVentana();
    }
        public static void NuevaVentana(){
        Login ventana = new Login();
        ventana.setVisible(true);
    }

}
