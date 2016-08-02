
package proyecto;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scerdass
 */
public class HiloCaptura extends Thread{
    
    
    public void run() {
        ColeccionDatos coleccion = new ColeccionDatos();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        String command2 = 
                "powershell.exe Get-Counter |"
                + "-Counter \"\\memory\\available mbytes\" -MaxSamples 10 -SampleInterval 1";

        for (int i = 0; i < 10; i++) {
            Calendar cal = Calendar.getInstance();
            String fechaHora = dateFormat.format(cal.getTime());
            try {
                Process powerShellProcess = Runtime.getRuntime().exec(command2);
                BufferedReader stdInput = 
                        new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
                String line;            
                stdInput.readLine(); 
                stdInput.readLine();
                stdInput.readLine();
                line = stdInput.readLine();               
                String[] partes = line.split("  ");
                String estado = partes[0];
                String nombre = partes[1];            
                coleccion.agregarDato(fechaHora + "," + nombre + "," + estado);
                Thread.sleep(2000);
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        AdministradorArchivos archivo = new AdministradorArchivos();
        archivo.abrirArchivoEscritura("distribucionDatos.csv");
        archivo.escribirContenidoArchivo(coleccion.devolverContenido());
        archivo.cerrarArchivoEscritura();
    }
}
