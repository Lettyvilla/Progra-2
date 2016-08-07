package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PowerShell extends Thread {

    @Override
    public void run() {
        super.run();
        try {

            llamarComando(2, 2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String DISKREAD = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk reads/sec'";
    private final String DISKERITE = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk writes/sec'";
    private final String DISKTRANSFER = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk transfers/sec'";
    private final String PROCESSORTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% processor time'";
    private final String USERTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% user time'";
    private final String PRIVILIGEDTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% privileged time'";
    private final String MEMORYUSED = "powershell.exe (get-wmiobject -class '" + "win32_physicalmemory'" + " -namespace '" + "root" + "\\" + "CIMV2'" + ").Capacity";
    private final String NETIN = "powershell.exe wmic path Win32_PerfRawData_Tcpip_NetworkInterface get BytesReceivedPersec";
    private final String NETOUT = "powershell.exe wmic path Win32_PerfRawData_Tcpip_NetworkInterface get BytesSentPersec";
    private final String NETTOTAL = "powershell.exe wmic path Win32_PerfRawData_Tcpip_NetworkInterface get BytesTotalPersec";

    private final String[] Procesos = {"DiskRead", "DiskWrite", "DiskTransfer",
        "Processor Time", "User Time", "Privilige Time", "Memory", "NetIn", "NetOut", "NetTotal"};
    private String[] comandos = {DISKREAD, DISKERITE, DISKTRANSFER, PROCESSORTIME, USERTIME, PRIVILIGEDTIME, MEMORYUSED, NETIN, NETOUT, NETTOTAL};
    private ColeccionDatos datosFinales = null;

    public PowerShell() {
        datosFinales = new ColeccionDatos();
    }

    public void llamarComando(int veces, int tiempo) throws IOException, InterruptedException {
        String resultado = "";
        String linea = "";

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

                switch (Procesos[posNombre]) {
                    case "Memory": {
                        long total_mem = 0;
                        while ((linea = stdInput.readLine()) != null) {
                            total_mem = total_mem + Long.valueOf(linea);
                        }
                        total_mem = ((total_mem / 1024) / 1024);
                        datosFinales.agregarDato("," + total_mem);

                        //Memoria disponible
                        String availableMem = "powershell.exe Get-Counter '" + "\\" + "memory" + "\\" + "available mbytes'";
                        powerShellProcess = Runtime.getRuntime().exec(availableMem);
                        stdInput = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        System.out.println(stdInput.readLine());
                        linea = stdInput.readLine();
                        String[] valor = linea.split(" ");
                        resultado = valor[26];
                        long mem_free = Long.valueOf(resultado);
                        Long Used_mem = total_mem - mem_free;
                        datosFinales.agregarDato("," + Used_mem);
                        posNombre++;
                        break;
                    }
                    case "NetIn": {
                       stdInput.readLine();
                       stdInput.readLine();
                       while ((linea = stdInput.readLine()) != null) {
                           System.out.println("'"+linea+"'");                        
                        }
                        long NetIn =0;
                        datosFinales.agregarDato("," + NetIn);
                        posNombre++;
                        break;

                    }
                    case "NetOut": {
                        break;
                    }
                    case "NetTotal": {
                        break;
                    }
                    default: {
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        System.out.println(stdInput.readLine());
                        String[] valor = stdInput.readLine().split(" ");
                        resultado = valor[26];                        
                        datosFinales.agregarDato("," + resultado);
                        posNombre++;
                        break;
                    }
                }

            }
            datosFinales.agregarDato("\n");

        }
        AdministradorArchivos archivo = new AdministradorArchivos();

        archivo.abrirArchivoEscritura("distribucionDatos.csv");
        archivo.escribirContenidoArchivo(datosFinales.devolverContenido());
        archivo.cerrarArchivoEscritura();
        System.out.println("Checkeo finalizado");
        JOptionPane.showMessageDialog(null, "Checkeo finalizado");
    }
}
