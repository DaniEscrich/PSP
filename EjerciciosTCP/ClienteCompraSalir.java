import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCompraSalir {
    static final int Puerto = 2000;
    static final String Host = "localhost";

    public static void main(String[] args) {
        OutputStream salida = null;
        InputStream entrada = null;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        try {
            while (!salir) {
                System.out.println("Dime un producto para añadir a la lista de la compra (escribe salir para acabar la lista de la compra): ");
                String producto = sc.nextLine();
                Socket sCliente = new Socket(Host, Puerto);
                salida = sCliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                flujoSalida.writeUTF(producto);

                if (producto.equals("salir")) {
                    salir = true;
                } else {
                    entrada = sCliente.getInputStream();
                    DataInputStream flujoEntrada = new DataInputStream(entrada);
                    String mensajeServidor = flujoEntrada.readUTF();
                    System.out.println(mensajeServidor);
                }
                sCliente.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
