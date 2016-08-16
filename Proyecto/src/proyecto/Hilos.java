package proyecto;

public class Hilos extends Thread {

    PowerShell power = new PowerShell();

    @Override
    public void run() {
        super.run();
        try {
            power.EncabezadosCsv();
            power.CapturaDatos(10, 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }     

    }
}
