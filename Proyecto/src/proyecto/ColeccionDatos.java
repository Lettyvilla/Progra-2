package proyecto;


import java.util.ArrayList;


public class ColeccionDatos {

    private ArrayList<String> lista;
    
    private static ColeccionDatos singletonInstance;
    
    public ColeccionDatos() {
        lista = new ArrayList<String>();
    }
    
    public static ColeccionDatos getsingletonInstance (){
    if (singletonInstance == null){
         singletonInstance = new ColeccionDatos();
    }
    return singletonInstance;
    }

    public synchronized boolean agregarDato(String dato) {
        return lista.add(dato);
    }
    
    public String devolverContenidoCsv() {
        String dato = "";
        for (String d : lista) {
            dato += d;            
        }
        return dato;
    }
    
    public String devolverContenido() {
        String dato = "";
        for (String d : lista) {
            dato += d ;
            dato += " ";
        }
        return dato;
    }
   
    
    public int contarDato() {
        return lista.size();
    }
    
    public String obtenerDato(int posicion){
        if ((posicion >= 0) && (posicion < lista.size())) {
            return lista.get(posicion);
        }
        return null;
    }
    
    public String eliminarStat(int posicion) {
        if ((posicion >= 0) && (posicion < lista.size())) {
            return lista.remove(posicion);
        }
        return null;
    }
}



















