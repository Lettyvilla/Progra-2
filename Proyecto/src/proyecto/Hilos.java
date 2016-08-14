package proyecto;

public class Hilos extends Thread {

    PowerShell power = new PowerShell();
    
    @Override
    public void run() {
        super.run();
        /*try {
            power.Encabezados();
            power.llamarComando(1,1000);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {

            power.EncabezadosCsv();
            power.llamarComandoCsv(3,1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    

    
