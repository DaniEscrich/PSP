import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.*;
public class TCPejemplo1Servidor {
    static final int Puerto = 2000;
    public static void main(String[] arg) {
        OutputStream salida = null;
        try {
// Inicio la escucha del servidor en un determinado puerto
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto " + Puerto);
            System.out.println("Escuchando al Cliente 1 ");
// Aquí atiendo la petición del cliente1 ...
            Socket sCliente1 = skServidor.accept();
            salida = sCliente1.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("Saludos al cliente del servidor");
            System.out.println("Escuchando al Cliente 2 ");
// Aquí atiendo la petición del cliente2 ...
            Socket sCliente2 = skServidor.accept();
// Cierro el socket
            skServidor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Servidor cerrado. ");
    }
}
