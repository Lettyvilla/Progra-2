package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PowerShell extends Thread {

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        try {
            llamarComando(5, 2000);

        } catch (IOException ex) {
            Logger.getLogger(PowerShell.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PowerShell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private final String DISKREAD = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk reads/sec'";
    private final String DISKERITE = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk writes/sec'";
    private final String DISKTRANSFER = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk transfers/sec'";
    private final String PROCESSORTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% processor time'";
    private final String USERTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% user time'";
    private final String PRIVILIGEDTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% privileged time'";
    private final String MEMORYUSED = "powershell.exe (get-wmiobject -class '" + "win32_physicalmemory'" + " -namespace '" + "root" + "\\" + "CIMV2'" + ").Capacity";
    private final String MEMORYTOTAL = "powershell.exe (get-wmiobject -class '" + "win32_physicalmemory'" + " -namespace '" + "root" + "\\" + "CIMV2'" + ").Capacity";

    private final String[] Procesos = {"DiskRead", "DiskWrite", "DiskTransfer",
        "Processor Time", "User Time", "Privilige Time", "MemoryUsed"};
    private String[] comandos = {DISKREAD, DISKERITE, DISKTRANSFER, PROCESSORTIME, USERTIME, PRIVILIGEDTIME, MEMORYUSED};
    private ColeccionDatos datosFinales = null;

    public PowerShell() {
        datosFinales = new ColeccionDatos();
    }

    public String llamarComando(int veces, int tiempo) throws IOException, InterruptedException {
        //crear hilo

        String resultado = "";
        int posNombre = 0;
        datosFinales.agregarDato("Fecha" + "," + "Estado" + "," + "Nombre");
        for (String comando : comandos) {
            resultado += "\n";
            for (int i = 0; i < veces; i++) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                String fechaHora = dateFormat.format(cal.getTime());
                Process powerShellProcess = Runtime.getRuntime().exec(comando);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
                String linea = "";
                if (Procesos[posNombre].equals("MemoryUsed")) {
                    long total_mem = 0;
                    while ((linea = stdInput.readLine()) != null) {
                        total_mem = total_mem + Long.valueOf(linea);
                    }
                    total_mem = ((total_mem / 1024) / 1024);
                    String command3 = "powershell.exe Get-Counter '" + "\\" + "memory" + "\\" + "available mbytes'";
                    powerShellProcess = Runtime.getRuntime().exec(command3);
                    stdInput = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
                    linea = "";
                    stdInput.readLine();
                    stdInput.readLine();
                    stdInput.readLine();
                    stdInput.readLine();
                    linea = stdInput.readLine();
                    String[] partes = linea.split(" ");
                    resultado = partes[26];
                    long mem_free = Long.valueOf(resultado);
                    datosFinales.agregarDato(fechaHora + "," + total_mem + "," + "MemoryTotal");
                    total_mem = total_mem - mem_free;
                    datosFinales.agregarDato(fechaHora + "," + total_mem + "," + Procesos[posNombre]);

                } else {
                    stdInput.readLine();
                    stdInput.readLine();
                    stdInput.readLine();
                    stdInput.readLine();
                    String[] result = stdInput.readLine().split(" ");
                    String estado = result[26];
                    resultado += estado + "\n";
                    datosFinales.agregarDato(fechaHora + "," + estado + "," + Procesos[posNombre]);
                }
                Thread.sleep(tiempo);
            }
            posNombre++;
        }
        AdministradorArchivos archivo = new AdministradorArchivos();
        archivo.abrirArchivoEscritura("distribucionDatos.csv");
        archivo.escribirContenidoArchivo(datosFinales.devolverContenido());
        archivo.cerrarArchivoEscritura();
        return resultado;
    }
}