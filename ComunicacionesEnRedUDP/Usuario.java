package ComunicacionesEnRedUDP.Segundos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Usuario {
    public static void main(String[] args) throws IOException {
        final int puerto = 12345;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu nombre de usuario:");
        String usuario = sc.nextLine().trim();

        DatagramSocket socketUDP = new DatagramSocket();

        boolean salir = false;
        while (!salir) {
            System.out.println("==TICKER SERVER==");
            System.out.println("1- Listar Butacas");
            System.out.println("2- Reservar Butacas");
            System.out.println("3- Anular Butacas");
            System.out.println("4- Salir");

            String opcion = sc.nextLine().trim();
            String mensaje = usuario + ":" + opcion;
            byte[] buffer = mensaje.getBytes();
            InetAddress destino = InetAddress.getByName("localhost");

            DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
            socketUDP.send(envio);

            if (opcion.equals("4")) {
                System.out.println("Has salido.");
                salir = true;
                continue;
            }

            // Recibir respuesta del servidor
            byte[] bufferRecepcion = new byte[1024];
            DatagramPacket recibo = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
            socketUDP.receive(recibo);
            String respuesta = new String(recibo.getData(), 0, recibo.getLength()).trim();

            System.out.println("Respuesta del servidor: " + respuesta);
        }

        socketUDP.close();
    }
}
