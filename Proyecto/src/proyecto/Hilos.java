package proyecto;

public class Hilos extends Thread {

    PowerShell power = new PowerShell();

    @Override
    public void run() {        
        try {
            power.EncabezadosCsv();
            power.CapturaDatos(1);
            power.CrearArchivos();
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }     

    }
}
