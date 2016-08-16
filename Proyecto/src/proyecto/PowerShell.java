package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PowerShell extends Thread {

    private final String DISKREAD = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk reads/sec'";
    private final String DISKERITE = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk writes/sec'";
    private final String DISKTRANSFER = "powershell.exe Get-Counter '" + "\\" + "physicaldisk(_total)" + "\\" + "disk transfers/sec'";
    private final String PROCESSORTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% processor time'";
    private final String USERTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% user time'";
    private final String IDLETIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% idle time'";
    private final String NETWORKIN = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes received/sec'";
    private final String NETWORKOUT = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes Sent/sec'";
    private final String NETWORKTOTAL = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes Total/sec'";
    private final String MEMORYUSED = "powershell.exe (get-wmiobject -class '" + "win32_physicalmemory'" + " -namespace '" + "root" + "\\" + "CIMV2'" + ").Capacity";

    private final String[] Procesos = {"DiskRead", "DiskWrite", "DiskTransfer",
        "Processor Time", "User Time", "idle Time", "NETWORKIN", "NETWORKOUT", "NETWORKTOTAL", "MemoryUsed"};
    
    private String[] comandos = {DISKREAD, DISKERITE, DISKTRANSFER, PROCESSORTIME, USERTIME, IDLETIME,
        NETWORKIN, NETWORKOUT, NETWORKTOTAL, MEMORYUSED};

    private final String[] encabezados = {"Fecha Hora", "Disk Read", "Disk Write", "Disk Transfer",
        "Processor Time", "User Time", "idle Time", "NETWORKIN", "NETWORKPOUT", "NETWORKTOTAL", "Memory Intalled", "MemoryUsed"};

    private final String[] encabezadosMetricas = {"Metrica", "Disk Read", "Disk Write", "Disk Transfer",
        "Processor Time", "User Time", "idle Time", "NETWORKIN", "NETWORKPOUT", "NETWORKTOTAL", "Memory Intalled", "MemoryUsed"};

    private ColeccionDatos datosExcel = null;
    private ColeccionDatos datosCsv = null;

    private PrintWriter stdErr = new PrintWriter(System.err, true);

    Workbook wb = new HSSFWorkbook();

    public PowerShell() {
        datosExcel = new ColeccionDatos();
        datosCsv = new ColeccionDatos();
    }

    public void EncabezadosCsv() {
        for (int i = 0; i < encabezados.length; i++) {
            datosCsv.agregarDato(encabezados[i] + ",");
        }
        datosCsv.agregarDato("\n");
    }

    public void CapturaDatos(int veces, int tiempo) throws IOException, InterruptedException {
        String resultado = " ";

        for (int i = 0; i < veces; i++) {
            //resultado += "\n";
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String fechaHora = dateFormat.format(cal.getTime());
            datosCsv.agregarDato(fechaHora + ",");
            datosExcel.agregarDato(fechaHora);

            int posNombre = 0;
            for (String comando : comandos) {
                Process powerShellProcess = Runtime.getRuntime().exec(comando);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
                String linea = "";

                switch (Procesos[posNombre]) {
                    case "MemoryUsed": {
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
                        datosCsv.agregarDato(total_mem + ",");
                        datosExcel.agregarDato(total_mem + "");
                        total_mem = total_mem - mem_free;
                        datosCsv.agregarDato(total_mem + ",");
                        datosExcel.agregarDato(total_mem + "");
                        break;
                    }
                    
                    case ("NETWORKOUT"):{
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();
                        System.out.println(stdInput.readLine());
                        String[] result = stdInput.readLine().split(" ");
                        String estado = result[26];                       
                        long num = Long.parseLong(estado);
                        num = ((num / 1024) / 1024);
                        datosCsv.agregarDato(num + ",");
                        datosExcel.agregarDato(num + "");
                        break; 
                    }
                    default: {
                        stdInput.readLine();
                        stdInput.readLine();
                        stdInput.readLine();                        
                        System.out.println(stdInput.readLine());
                        String[] result = stdInput.readLine().split(" ");
                        String estado = result[26];
                        resultado += estado;                        
                        datosCsv.agregarDato(estado.trim() + ",");
                        datosExcel.agregarDato(estado.trim());
                        break;
                    }
                }
                posNombre++;
            }
            datosCsv.agregarDato("\n");
            datosExcel.agregarDato("\n");
        }
        //Crea el archivo CSV
        AdministradorArchivos archivo = new AdministradorArchivos();
        archivo.abrirArchivoEscritura("distribucionDatos.csv");
        archivo.escribirContenidoArchivo(datosCsv.devolverContenidoCsv());
        archivo.cerrarArchivoEscritura();
        JOptionPane.showMessageDialog(null, "Checkeo finalizado 2");
        
        //Crea Archivo .xls
        String contenidoExcel = datosExcel.devolverContenido();        
        File archivo1 = new File("Metricas.xls");
        Workbook workbook = new HSSFWorkbook();
        Sheet pagina = workbook.createSheet("Datos");
        Row fila = pagina.createRow(0);
        int rowCount = 0;
        int cellCount = 2;

        for (int encab = 0; encab < encabezados.length; encab++) {
            Cell celda = fila.createCell(encab);
            celda.setCellValue(encabezados[encab]);
        }

        String[] lineas = contenidoExcel.split("\n");
        for (int row = 0; row < lineas.length; row++) {
            fila = pagina.createRow(row + 1);
            rowCount = row + 1;
            String[] datos = lineas[row].split("\t");
            for (int cells = 0; cells < datos.length; cells++) {
                if (cells == 0) {
                    Cell celda = fila.createCell(cells);
                    celda.setCellValue(datos[cells]);
                    cellCount = cells;
                } else {
                    Cell celda = fila.createCell(cells);
                    celda.setCellValue(Double.parseDouble(datos[cells]));
                    celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                    cellCount = cells;
                }
            }
        }

        Sheet pagina1 = workbook.createSheet("Tabla");
        Row fila2 = pagina1.createRow(0);
        for (int encab2 = 0; encab2 < encabezadosMetricas.length; encab2++) {
            Cell celda = fila2.createCell(encab2);
            celda.setCellValue(encabezadosMetricas[encab2]);
        }

        String[] formulas = {"Suma", "Promedio", "Percentil 95", "Maximo", "Minimo"};
        for (int fileFor = 0; fileFor < formulas.length; fileFor++) {
            fila = pagina1.createRow(fileFor + 1);

            switch (fileFor) {
                case 0:
                    Cell celdaA = fila.createCell(0);
                    celdaA.setCellValue(formulas[0]);
                    Cell celdaB = fila.createCell(1);
                    celdaB.setCellFormula("SUM(Datos!B2:B34)");
                    Cell celdaC = fila.createCell(2);
                    celdaC.setCellFormula("SUM(Datos!C2:C34)");
                    Cell celdaD = fila.createCell(3);
                    celdaD.setCellFormula("SUM(Datos!D2:D34)");
                    Cell celdaE = fila.createCell(4);
                    celdaE.setCellFormula("SUM(Datos!E2:E34)");
                    Cell celdaF = fila.createCell(5);
                    celdaF.setCellFormula("SUM(Datos!F2:F34)");
                    Cell celdaG = fila.createCell(6);
                    celdaG.setCellFormula("SUM(Datos!G2:G34)");
                    Cell celdaH = fila.createCell(7);
                    celdaH.setCellFormula("SUM(Datos!H2:H34)");
                    Cell celdaI = fila.createCell(8);
                    celdaI.setCellFormula("SUM(Datos!I2:I34)");
                    Cell celdaJ = fila.createCell(9);
                    celdaJ.setCellFormula("SUM(Datos!J2:J34)");
                    Cell celdaK = fila.createCell(10);
                    celdaK.setCellFormula("SUM(Datos!K2:K34)");
                    Cell celdaL = fila.createCell(11);
                    celdaL.setCellFormula("SUM(Datos!L2:L34)");
                    break;
                case 1:
                    Cell celdaA1 = fila.createCell(0);
                    celdaA1.setCellValue(formulas[1]);
                    Cell celdaB1 = fila.createCell(1);
                    celdaB1.setCellFormula("AVERAGE(Datos!B2:B34)");
                    Cell celdaC1 = fila.createCell(2);
                    celdaC1.setCellFormula("AVERAGE(Datos!C2:C34)");
                    Cell celdaD1 = fila.createCell(3);
                    celdaD1.setCellFormula("AVERAGE(Datos!D2:D34)");
                    Cell celdaE1 = fila.createCell(4);
                    celdaE1.setCellFormula("AVERAGE(Datos!E2:E34)");
                    Cell celdaF1 = fila.createCell(5);
                    celdaF1.setCellFormula("AVERAGE(Datos!F2:F34)");
                    Cell celdaG1 = fila.createCell(6);
                    celdaG1.setCellFormula("AVERAGE(Datos!G2:G34)");
                    Cell celdaH1 = fila.createCell(7);
                    celdaH1.setCellFormula("AVERAGE(Datos!H2:H34)");
                    Cell celdaI1 = fila.createCell(8);
                    celdaI1.setCellFormula("AVERAGE(Datos!I2:I34)");
                    Cell celdaJ1 = fila.createCell(9);
                    celdaJ1.setCellFormula("AVERAGE(Datos!J2:J34)");
                    Cell celdaK1 = fila.createCell(10);
                    celdaK1.setCellFormula("AVERAGE(Datos!K2:K34)");
                    Cell celdaL1 = fila.createCell(11);
                    celdaL1.setCellFormula("AVERAGE(Datos!L2:L34)");
                    break;
                case 2:
                    Cell celdaA2 = fila.createCell(0);
                    celdaA2.setCellValue(formulas[2]);
                    Cell celdaB2 = fila.createCell(1);
                    celdaB2.setCellFormula("PERCENTILE(Datos!B2:B34,0.95)");
                    Cell celdaC2 = fila.createCell(2);
                    celdaC2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaC2.setCellFormula("PERCENTILE(Datos!C2:C34,0.95)");
                    Cell celdaD2 = fila.createCell(3);
                    celdaD2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaD2.setCellFormula("PERCENTILE(Datos!D2:D34,0.95)");
                    Cell celdaE2 = fila.createCell(4);
                    celdaE2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaE2.setCellFormula("PERCENTILE(Datos!E2:E34,0.95)");
                    Cell celdaF2 = fila.createCell(5);
                    celdaF2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaF2.setCellFormula("PERCENTILE(Datos!F2:F34,0.95)");
                    Cell celdaG2 = fila.createCell(6);
                    celdaG2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaG2.setCellFormula("PERCENTILE(Datos!G2:G34,0.95)");
                    Cell celdaH2 = fila.createCell(7);
                    celdaH2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaH2.setCellFormula("PERCENTILE(Datos!H2:H34,0.95)");
                    Cell celdaI2 = fila.createCell(8);
                    celdaI2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaI2.setCellFormula("PERCENTILE(Datos!I2:I34,0.95)");
                    Cell celdaJ2 = fila.createCell(9);
                    celdaJ2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaJ2.setCellFormula("PERCENTILE(Datos!J2:J34,0.95)");
                    Cell celdaK2 = fila.createCell(10);
                    celdaK2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaK2.setCellFormula("PERCENTILE(Datos!K2:K34,0.95)");
                    Cell celdaL2 = fila.createCell(11);
                    celdaL2.setCellType(Cell.CELL_TYPE_FORMULA);
                    celdaL2.setCellFormula("PERCENTILE(Datos!L2:L34,0.95)");
                    break;
                case 3:
                    Cell celdaA3 = fila.createCell(0);
                    celdaA3.setCellValue(formulas[3]);
                    Cell celdaB3 = fila.createCell(1);
                    celdaB3.setCellFormula("MAX(Datos!B2:B34)");
                    Cell celdaC3 = fila.createCell(2);
                    celdaC3.setCellFormula("MAX(Datos!C2:C34)");
                    Cell celdaD3 = fila.createCell(3);
                    celdaD3.setCellFormula("MAX(Datos!D2:D34)");
                    Cell celdaE3 = fila.createCell(4);
                    celdaE3.setCellFormula("MAX(Datos!E2:E34)");
                    Cell celdaF3 = fila.createCell(5);
                    celdaF3.setCellFormula("MAX(Datos!F2:F34)");
                    Cell celdaG3 = fila.createCell(6);
                    celdaG3.setCellFormula("MAX(Datos!G2:G34)");
                    Cell celdaH3 = fila.createCell(7);
                    celdaH3.setCellFormula("MAX(Datos!H2:H34)");
                    Cell celdaI3 = fila.createCell(8);
                    celdaI3.setCellFormula("MAX(Datos!I2:I34)");
                    Cell celdaJ3 = fila.createCell(9);
                    celdaJ3.setCellFormula("MAX(Datos!J2:J34)");
                    Cell celdaK3 = fila.createCell(10);
                    celdaK3.setCellFormula("MAX(Datos!K2:K34)");
                    Cell celdaL3 = fila.createCell(11);
                    celdaL3.setCellFormula("MAX(Datos!L2:L34)");
                    break;
                case 4:
                    Cell celdaA4 = fila.createCell(0);
                    celdaA4.setCellValue(formulas[4]);
                    Cell celdaB4 = fila.createCell(1);
                    celdaB4.setCellFormula("MIN(Datos!B2:B34)");
                    Cell celdaC4 = fila.createCell(2);
                    celdaC4.setCellFormula("MIN(Datos!C2:C34)");
                    Cell celdaD4 = fila.createCell(3);
                    celdaD4.setCellFormula("MIN(Datos!D2:D34)");
                    Cell celdaE4 = fila.createCell(4);
                    celdaE4.setCellFormula("MIN(Datos!E2:E34)");
                    Cell celdaF4 = fila.createCell(5);
                    celdaF4.setCellFormula("MIN(Datos!F2:F34)");
                    Cell celdaG4 = fila.createCell(6);
                    celdaG4.setCellFormula("MIN(Datos!G2:G34)");
                    Cell celdaH4 = fila.createCell(7);
                    celdaH4.setCellFormula("MIN(Datos!H2:H34)");
                    Cell celdaI4 = fila.createCell(8);
                    celdaI4.setCellFormula("MIN(Datos!I2:I34)");
                    Cell celdaJ4 = fila.createCell(9);
                    celdaJ4.setCellFormula("MIN(Datos!J2:J34)");
                    Cell celdaK4 = fila.createCell(10);
                    celdaK4.setCellFormula("MIN(Datos!K2:K34)");
                    Cell celdaL4 = fila.createCell(11);
                    celdaL4.setCellFormula("MIN(Datos!L2:L34)");
                    break;
                default:
                    break;
            }
        }

        try {
            FileOutputStream salida = new FileOutputStream(archivo1);
            try {
                workbook.write(salida);
                workbook.close();
            } catch (IOException ioe) {
                stdErr.println(ioe);
                ioe.printStackTrace();
            }

        } catch (FileNotFoundException fnfe) {
            stdErr.println(fnfe);
            fnfe.printStackTrace();
        }

    }

}
