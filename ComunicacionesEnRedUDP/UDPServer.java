package ComunicacionesEnRedUDP.Terceros;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;

public class UDPServer {
    public static void main(String[] args) {
        final int PORT = 6000;

        // Crear diccionario inglés-español
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "hola");
        dictionary.put("world", "mundo");
        dictionary.put("dog", "perro");
        dictionary.put("cat", "gato");
        dictionary.put("food", "comida");

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("Servidor UDP iniciado en el puerto " + PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet); // Recibir mensaje del cliente

                String receivedWord = new String(packet.getData(), 0, packet.getLength()).trim();
                System.out.println("Cliente preguntó por: " + receivedWord);

                // Buscar la traducción
                String translation = dictionary.getOrDefault(receivedWord, "");

                if (!translation.isEmpty()) {
                    byte[] responseBytes = translation.getBytes();
                    DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length,
                            packet.getAddress(), packet.getPort());
                    socket.send(responsePacket);
                    System.out.println("Enviada traducción: " + translation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
