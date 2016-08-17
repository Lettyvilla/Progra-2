package proyecto;

public class Hilos extends Thread {

    PowerShell power = new PowerShell();

    @Override
    public void run() {        
        try {
            power.EncabezadosCsv();
            power.CapturaDatos(5);  
        } catch (Exception e) {
            e.printStackTrace();
        }     

    }
}
