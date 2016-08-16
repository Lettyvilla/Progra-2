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
    private final String PRIVILIGEDTIME = "powershell.exe Get-Counter '" + "\\" + "processor(_total)" + "\\" + "% privileged time'";
    private final String NETWORKIN = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes received/sec'";
    private final String NETWORKPOUT = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes Sent/sec'";
    private final String NETWORKTOTAL = "powershell.exe Get-Counter '" + "\\" + "Network Interface(*)" + "\\" + "bytes Total/sec'";
    private final String MEMORYUSED = "powershell.exe (get-wmiobject -class '" + "win32_physicalmemory'" + " -namespace '" + "root" + "\\" + "CIMV2'" + ").Capacity";

    private final String[] Procesos = {"DiskRead", "DiskWrite", "DiskTransfer",
        "Processor Time", "User Time", "Privilige Time","NETWORKIN","NETWORKPOUT","NETWORKTOTAL","MemoryUsed"};
    private String[] comandos = {DISKREAD, DISKERITE, DISKTRANSFER, PROCESSORTIME, USERTIME, PRIVILIGEDTIME, 
        NETWORKIN, NETWORKPOUT, NETWORKTOTAL, MEMORYUSED};
    
     private final String[] encabezados = {"Fecha y Hora","DiskRead", "DiskWrite", "DiskTransfer",
        "Processor Time", "User Time", "Privilige Time","Network IN","Network OUT","Network TOTAL","Memory Total", "Memory Used"};
     
<<<<<<< HEAD
     private final String[] encabezadosxls = {"Hola","FechaHora","DiskRead", "DiskWrite", "DiskTransfer",
        "Processor Time", "User Time", "Privilige Time","Network IN","Network OUT","Network TOTAL","Memory Total", "Memory Used"};
=======
     private final String[] encabezadosxls = {"Bievenido" ,"Fecha&Hora","DiskRead", "DiskWrite", "DiskTransfer",
        "Processor_Time", "User_Time", "Privilige_Time","Network_IN","Network_OUT","Network_TOTAL","Memory_Total", "Memory_Used"};
>>>>>>> origin/master
    
    private ColeccionDatos datosFinales = null;
    private ColeccionDatos datosFinales2 = null;
    
    private PrintWriter stdErr = new PrintWriter(System.err,true);
    
    
    Workbook wb = new HSSFWorkbook();

    public PowerShell() {
        datosFinales = new ColeccionDatos();
        datosFinales2 = new ColeccionDatos();
        
    }
    
    public void Encabezados(){
        for (int i =0;i<encabezadosxls.length;i++){        
        datosFinales.agregarDato(encabezadosxls[i]);
        }
        datosFinales.agregarDato("\n");
    }
    
    public void EncabezadosCsv(){
        for (int i =0;i<encabezados.length;i++){
        datosFinales2.agregarDato(encabezados[i]+",");        
        }
        datosFinales2.agregarDato("\n");
    }

  
    public void llamarComandoCsv(int veces, int tiempo) throws IOException, InterruptedException {
        String resultado = " ";

        for (int i = 0; i < veces; i++) {
            //resultado += "\n";
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String fechaHora = dateFormat.format(cal.getTime());
            datosFinales2.agregarDato(fechaHora+",");
            

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
                    datosFinales2.agregarDato(total_mem+",");
                    total_mem = total_mem - mem_free;
                    datosFinales2.agregarDato(total_mem+",");

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
                    datosFinales2.agregarDato(estado.trim()+",");
                }
                posNombre++;
            }
            datosFinales2.agregarDato("\n");
            
        }
        AdministradorArchivos archivo = new AdministradorArchivos();
        archivo.abrirArchivoEscritura("distribucionDatos.csv");
        archivo.escribirContenidoArchivo(datosFinales2.devolverContenidoCsv());
        archivo.cerrarArchivoEscritura();
        JOptionPane.showMessageDialog(null,"Checkeo finalizado 2");
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
                    datosFinales.agregarDato(total_mem+"");
                    total_mem = total_mem - mem_free;
                    datosFinales.agregarDato(total_mem+"");

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
        String contenidoExcel = datosFinales.devolverContenido();
        System.out.println(contenidoExcel);
        File archivo = new File("Metricas.xls");
        Workbook workbook = new HSSFWorkbook();
        Sheet pagina = workbook.createSheet("Tabla Metricas");
        Row fila = pagina.createRow(0);
        int rowCount = 0;
        int cellCount = 2;
       
        String[] lineas = contenidoExcel.split("\n");
        for (int row = 0; row < lineas.length; row++){
            fila = pagina.createRow(row + 1);
            rowCount = row + 1;
            String[] datos = lineas[row].split("\t");
<<<<<<< HEAD
            System.out.println(datos);
=======
>>>>>>> origin/master
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

        /* una vez que las metricas que capturan y se ponen en el archivo de excel se revisa en el
        archivo de excel donde van las formulas y se ponen manual*/
        
        String[] formulas = {"Suma", "Promedio", "Percentil 95","Maximo","Minimo"};
        for(int fileFor = 0; fileFor < formulas.length; fileFor++){
            fila = pagina.createRow(rowCount + fileFor + 1);
            switch(fileFor){
                case 0:
                    Cell celdaA = fila.createCell(0);
                    celdaA.setCellValue(formulas[0]);
                    Cell celdaB = fila.createCell(1);
                    celdaB.setCellFormula("SUM(B2:B31)");
                    Cell celdaC = fila.createCell(2);
                    celdaC.setCellFormula("SUM(C2:C31)");
                    Cell celdaD = fila.createCell(3);
                    celdaD.setCellFormula("SUM(D2:D31)");
                    Cell celdaE = fila.createCell(4);
                    celdaE.setCellFormula("SUM(E2:E31)");
                    Cell celdaF = fila.createCell(5);
                    celdaF.setCellFormula("SUM(F2:F31)");
                    Cell celdaG = fila.createCell(6);
                    celdaG.setCellFormula("SUM(G2:G31)");
                    Cell celdaH = fila.createCell(7);
                    celdaH.setCellFormula("SUM(H2:H31)");
                    Cell celdaI = fila.createCell(8);
                    celdaI.setCellFormula("SUM(I2:I31)");
                    Cell celdaJ = fila.createCell(9);
                    celdaJ.setCellFormula("SUM(J2:J31)");
                    Cell celdaK = fila.createCell(10);
                    celdaK.setCellFormula("SUM(K2:K31)");
                    Cell celdaL = fila.createCell(11);
                    celdaL.setCellFormula("SUM(L2:L31)");
                    break;
                case 1:
                    Cell celdaA1 = fila.createCell(0);
                    celdaA1.setCellValue(formulas[1]);
                    Cell celdaB1 = fila.createCell(1);
                    celdaB1.setCellFormula("AVERAGE(B2:B31)");
                    Cell celdaC1 = fila.createCell(2);
                    celdaC1.setCellFormula("AVERAGE(C2:C31)");
                    Cell celdaD1 = fila.createCell(3);
                    celdaD1.setCellFormula("AVERAGE(D2:D31)");
                    Cell celdaE1 = fila.createCell(4);
                    celdaE1.setCellFormula("AVERAGE(E2:E31)");
                    Cell celdaF1 = fila.createCell(5);
                    celdaF1.setCellFormula("AVERAGE(F2:F31)");
                    Cell celdaG1 = fila.createCell(6);
                    celdaG1.setCellFormula("AVERAGE(G2:G31)");
                    Cell celdaH1 = fila.createCell(7);
                    celdaH1.setCellFormula("AVERAGE(H2:H31)");
                    Cell celdaI1 = fila.createCell(8);
                    celdaI1.setCellFormula("AVERAGE(I2:I31)");
                    Cell celdaJ1 = fila.createCell(9);
                    celdaJ1.setCellFormula("AVERAGE(J2:J31)");
                    Cell celdaK1 = fila.createCell(10);
                    celdaK1.setCellFormula("AVERAGE(K2:K31)");
                    Cell celdaL1 = fila.createCell(11);
                    celdaL1.setCellFormula("AVERAGE(L2:L31)");
                    break;
                case 2:
                    Cell celdaA2 = fila.createCell(0);
                    celdaA2.setCellValue(formulas[2]);
                    Cell celdaB2 = fila.createCell(1);
                    celdaB2.setCellValue("=PERCENTILE(B2:B31,95%)");
                    Cell celdaC2 = fila.createCell(2);
                    celdaC2.setCellValue("=PERCENTILE(C2:C31,95%)");
                    Cell celdaD2 = fila.createCell(3);
                    celdaD2.setCellValue("=PERCENTILE(D2:D31,95%)");
                    Cell celdaE2 = fila.createCell(4);
                    celdaE2.setCellValue("=PERCENTILE(E2:E31,95%)");
                    Cell celdaF2 = fila.createCell(5);
                    celdaF2.setCellValue("=PERCENTILE(F2:F31,95%)");
                    Cell celdaG2 = fila.createCell(6);
                    celdaG2.setCellValue("=PERCENTILE(G2:G31,95%)");
                    Cell celdaH2 = fila.createCell(7);
                    celdaH2.setCellValue("=PERCENTILE(H2:H31,95%)");
                    Cell celdaI2 = fila.createCell(8);
                    celdaI2.setCellValue("=PERCENTILE(I2:I31,95%)");
                    Cell celdaJ2 = fila.createCell(9);
                    celdaJ2.setCellValue("=PERCENTILE(J2:J31,95%)");
                    Cell celdaK2 = fila.createCell(10);
                    celdaK2.setCellValue("=PERCENTILE(K2:K31,95%)");
                    Cell celdaL2 = fila.createCell(11);
                    celdaL2.setCellValue("=PERCENTILE(L2:L31,95%)");
                    break;
                case 3:
                    Cell celdaA3 = fila.createCell(0);
                    celdaA3.setCellValue(formulas[3]);
                    Cell celdaB3 = fila.createCell(1);
                    celdaB3.setCellFormula("MAX(B2:B31)");
                    Cell celdaC3 = fila.createCell(2);
                    celdaC3.setCellFormula("MAX(C2:C31)");
                    Cell celdaD3 = fila.createCell(3);
                    celdaD3.setCellFormula("MAX(D2:D31)");
                    Cell celdaE3 = fila.createCell(4);
                    celdaE3.setCellFormula("MAX(E2:E31)");
                    Cell celdaF3 = fila.createCell(5);
                    celdaF3.setCellFormula("MAX(F2:F31)");
                    Cell celdaG3 = fila.createCell(6);
                    celdaG3.setCellFormula("MAX(G2:G31)");
                    Cell celdaH3 = fila.createCell(7);
                    celdaH3.setCellFormula("MAX(H2:H31)");
                    Cell celdaI3 = fila.createCell(8);
                    celdaI3.setCellFormula("MAX(I2:I31)");
                    Cell celdaJ3 = fila.createCell(9);
                    celdaJ3.setCellFormula("MAX(J2:J31)");
                    Cell celdaK3 = fila.createCell(10);
                    celdaK3.setCellFormula("MAX(K2:K31)");
                    Cell celdaL3 = fila.createCell(11);
                    celdaL3.setCellFormula("MAX(L2:L31)");
                    break;
                case 4:
                    Cell celdaA4 = fila.createCell(0);
                    celdaA4.setCellValue(formulas[4]);
                    Cell celdaB4 = fila.createCell(1);
                    celdaB4.setCellFormula("MIN(B2:B31)");
                    Cell celdaC4 = fila.createCell(2);
                    celdaC4.setCellFormula("MIN(C2:C31)");
                    Cell celdaD4 = fila.createCell(3);
                    celdaD4.setCellFormula("MIN(D2:D31)");
                    Cell celdaE4 = fila.createCell(4);
                    celdaE4.setCellFormula("MIN(E2:E31)");
                    Cell celdaF4 = fila.createCell(5);
                    celdaF4.setCellFormula("MIN(F2:F31)");
                    Cell celdaG4 = fila.createCell(6);
                    celdaG4.setCellFormula("MIN(G2:G31)");
                    Cell celdaH4 = fila.createCell(7);
                    celdaH4.setCellFormula("MIN(H2:H31)");
                    Cell celdaI4 = fila.createCell(8);
                    celdaI4.setCellFormula("MIN(I2:I31)");
                    Cell celdaJ4 = fila.createCell(9);
                    celdaJ4.setCellFormula("MIN(J2:J31)");
                    Cell celdaK4 = fila.createCell(10);
                    celdaK4.setCellFormula("MIN(K2:K31)");
                    Cell celdaL4 = fila.createCell(11);
                    celdaL4.setCellFormula("MIN(L2:L31)");
                    break;    
                default:
                    break;
            }
        }
        
        try {
            FileOutputStream salida = new FileOutputStream(archivo);
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
        
        

