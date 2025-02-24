package ComunicacionesEnRedUDP.Terceros;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        final int SERVER_PORT = 6000;
        final String SERVER_ADDRESS = "localhost";
        final int TIMEOUT = 5000; // 5 segundos

        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(TIMEOUT); // Configurar timeout

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese una palabra en inglés: ");
            String word = scanner.nextLine().trim();

            // Enviar palabra al servidor
            byte[] buffer = word.getBytes();
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, SERVER_PORT);
            socket.send(packet);

            // Recibir respuesta del servidor
            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

            try {
                socket.receive(responsePacket);
                String translation = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("Traducción: " + translation);
            } catch (SocketTimeoutException e) {
                System.out.println("No se encontró traducción.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
