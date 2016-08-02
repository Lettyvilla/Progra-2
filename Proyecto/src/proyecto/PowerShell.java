package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerShell {

    public PowerShell() {
    }

    public String llamarComando(String comando) throws IOException {
        int numLinea = 1;
        String resultado = "Descarga: \nFecha: ";
        Process powerShellProcess = Runtime.getRuntime().exec(comando);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
        String line;;
        stdInput.readLine();
        stdInput.readLine();
        stdInput.readLine();
        String linea = stdInput.readLine();
        String[] partes = linea.split("  ");
        resultado += partes[0]+"\n";
        resultado += "Velocidad: ";
        stdInput.readLine();;
        stdInput.readLine();;
        stdInput.readLine();
        double valor=(Double.valueOf(stdInput.readLine()));
        
        resultado += String.valueOf(valor/100000)+ "Mb";

        return resultado;
    }

}
