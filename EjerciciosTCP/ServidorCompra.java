import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCompra {
    static final int Puerto = 2000;

    public static void main(String[] args) {
        InputStream entrada = null;
        try {
                ServerSocket skServidor = new ServerSocket(Puerto);
                Socket sCliente1 = skServidor.accept();

                entrada = sCliente1.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);
                String producto = flujoEntrada.readUTF();
                System.out.println("Producto recibido del Cliente: \n\t" + producto);

                String ruta = "/home/danescali/IdeaProjects/Ejercicios Clases InetAddress y URL/src/09-01-2025.txt";
                FileWriter escritorArchivo = new FileWriter(ruta, true);
                BufferedWriter writer = new BufferedWriter(escritorArchivo);
                writer.write(producto);
                writer.newLine();
                writer.close();
                System.out.println("Producto guardado en la lista de la compra: " + ruta);
                OutputStream salida = null;
                salida = sCliente1.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                flujoSalida.writeUTF("Se ha recibido el producto " + producto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
