package proyecto;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scerdass
 */
public class ColeccionDatos {

    private ArrayList<String> lista;
    
    public ColeccionDatos() {
        lista = new ArrayList<String>();
    }

    public boolean agregarDato(String dato) {
        return lista.add(dato);
    }
    
    public String devolverContenido() {
        String dato = "";
        for (String d : lista) {
            dato += d;
            dato += "\n";
        }
        return dato;

    }
}



















