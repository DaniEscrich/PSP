import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 2000;

        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("Esperando conexión del cliente.... " + puerto);

            try (Socket socket = servidorSocket.accept();
                 ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());) {

                System.out.println("¡Cliente conectado! " + socket.getInetAddress());

                Object mensaje = entrada.readObject();
                System.out.println("Objeto recibido del cliente: " + mensaje);
                System.out.println("Conexión Cerrada");
            } catch (ClassNotFoundException e) {
                System.err.println("Clase no encontrada al leer el objeto.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}