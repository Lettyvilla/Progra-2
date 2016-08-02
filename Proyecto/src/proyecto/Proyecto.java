package proyecto;

import java.io.IOException;

public class Proyecto {
    public static void main(String[] args) throws IOException {
        String  comando="powershell.exe Get-Counter '"+"\\"+"Network Interface(*)"+"\\"+"Bytes Sent/sec'";
        PowerShell handler=new PowerShell();
        System.out.println(handler.llamarComando(comando));
        Interfaz menu= new Interfaz();
    }    
}
