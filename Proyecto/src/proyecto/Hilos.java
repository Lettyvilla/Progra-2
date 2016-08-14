package proyecto;

public class Hilos extends Thread {

    PowerShell power = new PowerShell();
    
    @Override
    public void run() {
        super.run();
        try {
<<<<<<< HEAD
            power.llamarComando(1, 2000);
=======
            power.Encabezados();
            power.llamarComando(1,1000);
>>>>>>> origin/master
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
<<<<<<< HEAD
            power.llamarComandoCvs(1, 2000);
=======
            power.EncabezadosCsv();
            power.llamarComandoCsv(1,1000);
>>>>>>> origin/master
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    

    
