package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.File;

public class PowerShell extends Thread {

    private final String DISKREAD = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk reads/sec'";
    private final String DISKERITE = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk writes/sec'";
    private final String DISKTRANSFER = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk transfers/sec'";
    private final String PROCESSORTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% processor time'";
    private final String USERTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% user time'";
    private final String PRIVILIGEDTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% privileged time'";
    private final String NETWORKIN = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes received/sec'";
    private final String NETWORKPOUT = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes Sent/sec'";
    private final String NETWORKTOTAL = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes Total/sec'";
    private final String MEMORYUSED = "powershell.exe (get-wmiobject -class '" + "win32_physicalmemory'" + " -namespace '" + "root" + "\\" + "CIMV2'" + ").Capacity";

    private final String[] Procesos = {"DiskRead", "DiskWrite", "DiskTransfer",
        "Processor Time", "User Time", "Privilige Time", "NETWORKIN", "NETWORKPOUT", "NETWORKTOTAL", "MemoryUsed"};
    private String[] comandos = {DISKREAD, DISKERITE, DISKTRANSFER, PROCESSORTIME, USERTIME, PRIVILIGEDTIME,
        NETWORKIN, NETWORKPOUT, NETWORKTOTAL, MEMORYUSED};

    private final String[] encabezados = {"Fecha y Hora", "DiskRead", "DiskWrite", "DiskTransfer",
        "Processor Time", "User Time", "Privilige Time", "Network IN", "Network OUT", "Network TOTAL", "Memory Total", "Memory Used"};

    private ColeccionDatos datosFinales = null;
    private ColeccionDatos datosFinales2 = null;

    public PowerShell() {
        datosFinales = new ColeccionDatos();
        datosFinales2 = new ColeccionDatos();
    }

    public void Encabezados() {
        for (int i = 0; i < encabezados.length; i++) {
            datosFinales.agregarDato(encabezados[i]);
        }
        datosFinales.agregarDato("\n");
    }

    public void EncabezadosCsv() {
        for (int i = 0; i < encabezados.length; i++) {
            datosFinales2.agregarDato(encabezados[i] + ",");
        }
        datosFinales2.agregarDato("\n");
    }

    public void llamarComando(int veces, int tiempo) throws IOException, InterruptedException {
        String resultado = " ";

        for (int i = 0; i < veces; i++) {
            //resultado += "\n";
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String fechaHora = dateFormat.format(cal.getTime());
            datosFinales.agregarDato(fechaHora);

            int posNombre = 0;
            for (String comando : comandos) {
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
                    //System.out.println(stdInput.readLine());
                    linea = stdInput.readLine();
                    String[] partes = linea.split(" ");
                    resultado = partes[26];
                    long mem_free = Long.valueOf(resultado);
                    datosFinales.agregarDato(total_mem + "");
                    total_mem = total_mem - mem_free;
                    datosFinales.agregarDato(total_mem + "");

                } else {
                    stdInput.readLine();
                    stdInput.readLine();
                    stdInput.readLine();
                    //stdInput.readLine();
                    System.out.println(stdInput.readLine());
                    String[] result = stdInput.readLine().split(" ");
                    String estado = result[26];
                    resultado += estado;
                    datosFinales.agregarDato(estado.trim());
                }
                posNombre++;
            }
            datosFinales.agregarDato("\n");

        }
        AdministradorArchivos archivo = new AdministradorArchivos();
        archivo.abrirArchivoEscritura("distribucionDatos.xls");
        archivo.escribirContenidoArchivo(datosFinales.devolverContenido());
        archivo.cerrarArchivoEscritura();
    }

    public void llamarComandoCsv(int veces, int tiempo) throws IOException, InterruptedException {
        String resultado = " ";

        for (int i = 0; i < veces; i++) {
            //resultado += "\n";
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String fechaHora = dateFormat.format(cal.getTime());
            datosFinales2.agregarDato(fechaHora + ",");

            int posNombre = 0;
            for (String comando : comandos) {
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
                    //System.out.println(stdInput.readLine());
                    linea = stdInput.readLine();
                    String[] partes = linea.split(" ");
                    resultado = partes[26];
                    long mem_free = Long.valueOf(resultado);
                    datosFinales2.agregarDato(total_mem + ",");
                    total_mem = total_mem - mem_free;
                    datosFinales2.agregarDato(total_mem + ",");

                } else {
                    stdInput.readLine();
                    stdInput.readLine();
                    stdInput.readLine();
                    //stdInput.readLine();
                    System.out.println(stdInput.readLine());
                    String[] result = stdInput.readLine().split(" ");
                    String estado = result[26];
                    resultado += estado;
                    //long num = Long.parseLong(estado);
                    datosFinales2.agregarDato(estado.trim() + ",");
                }
                posNombre++;
            }
            datosFinales2.agregarDato("\n");

        }
        AdministradorArchivos archivo = new AdministradorArchivos();
        archivo.abrirArchivoEscritura("distribucionDatos.csv");
        archivo.escribirContenidoArchivo(datosFinales2.devolverContenidoCsv());
        archivo.cerrarArchivoEscritura();
        JOptionPane.showMessageDialog(null, "Checkeo finalizado 2");

    }
    
}
