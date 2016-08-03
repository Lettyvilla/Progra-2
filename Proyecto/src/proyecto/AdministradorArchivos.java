package proyecto;

import java.io.*;

public class AdministradorArchivos {
    
    private BufferedReader fileIn;
    private PrintWriter fileOut;
    
    private PrintWriter stdErr = new PrintWriter(System.err, true);
    
    public void abrirArchivoLectura(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            fileIn = new BufferedReader(reader);
        }
        catch (FileNotFoundException fnfe) {
            stdErr.println(fnfe);
            fnfe.printStackTrace();
        }
    }
    
    public void abrirArchivoEscritura(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            fileOut = new PrintWriter(writer, true);
        }
        catch (IOException ioe) {
            stdErr.println(ioe);
            ioe.printStackTrace();
        }
    }
    
    public void escribirContenidoArchivo(String contenido) {
        if (fileOut != null) {
            fileOut.println(contenido);
        }
    }
    
    public void cerrarArchivoEscritura() {
        if (fileOut != null) {
            fileOut.close();
        }
    }
    
    public void cerrarArchivoLectura() {
        if (fileIn != null) {
            try {
                fileIn.close();
            }
            catch (IOException ioe) {
                stdErr.println(ioe);
                ioe.printStackTrace();
            }
        } 
    }
    
    public String lecturaArchivo() {
        if (fileIn != null) {
            try {
                String totalLeido = "";
                String lineaLeida = fileIn.readLine();
                while (lineaLeida != null) {
                    totalLeido += lineaLeida;
                    totalLeido += "\n";
                    lineaLeida = fileIn.readLine();
                }
                return totalLeido;
            }
            catch (IOException ioe){
                stdErr.println(ioe);
                ioe.printStackTrace();
            }            
        }
        return null;
        
    }
   public String lecturaArchivoObtenerMetricas() {
        if (fileIn != null) {
            try {
                int contadorLineas = 0;
                int contadorCaracteres = 0;
                String lineaLeida = fileIn.readLine();
                while (lineaLeida != null) {
                    contadorLineas++;
                    contadorCaracteres += lineaLeida.length();
                    lineaLeida = fileIn.readLine();
                }
                return "Cantidad Lineas: " + contadorLineas + "\n" 
                        + "Cantidad Caracteres: " + contadorCaracteres;
            }
            catch (IOException ioe){
                stdErr.println(ioe);
                ioe.printStackTrace();
            }            
        }
        return null;
        
    } 
}
