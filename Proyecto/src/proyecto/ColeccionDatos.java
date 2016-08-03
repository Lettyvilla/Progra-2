package proyecto;


import java.util.ArrayList;


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



















